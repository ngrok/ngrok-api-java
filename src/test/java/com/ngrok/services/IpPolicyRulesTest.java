package com.ngrok.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.linecorp.armeria.common.HttpHeaderNames;
import com.ngrok.Ngrok;
import com.ngrok.TestBase;
import com.ngrok.Version;
import com.ngrok.definitions.IpPolicy;
import com.ngrok.definitions.IpPolicyRule;
import com.ngrok.definitions.Ref;
import de.mkammerer.wiremock.WireMockExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IpPolicyRulesTest extends TestBase {
    private static final IpPolicy MOCK_IP_POLICY = new IpPolicy(
        "some-id",
        URI.create("https://api.ngrok.com/ip_policies/some-id"),
        OffsetDateTime.now(),
        "",
        ""
    );

    private static final IpPolicyRule MOCK_IP_POLICY_RULE = new IpPolicyRule(
        "some-rule-id",
        URI.create("https://api.ngrok.com/ip_policy_rules/some-rule-id"),
        OffsetDateTime.now(),
        "",
        "",
        "10.1.2.0/24",
        new Ref("some-id", URI.create("https://api.ngrok.com/ip_policy/some-id")),
        "allow"
    );

    private static final Map<String, Object> IP_POLICY_RULE_CREATE = Stream.of(
        entry("ip_policy_id", MOCK_IP_POLICY.getId()),
        entry("cidr", MOCK_IP_POLICY_RULE.getCidr()),
        entry("action", MOCK_IP_POLICY_RULE.getAction())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    @RegisterExtension
    final WireMockExtension wireMock = new WireMockExtension(new WireMockConfiguration().dynamicPort().dynamicHttpsPort());

    private Ngrok ngrok() {
        return TestBase.ngrok(wireMock.getBaseUri());
    }

    @BeforeEach
    public void stubIpPolicies() throws JsonProcessingException {
        if (USE_LIVE_API) {
            return;
        }

        wireMock.resetAll();

        wireMock.stubFor(
            post(urlPathEqualTo("/ip_policies"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), containing("application/json"))
                .withRequestBody(equalToJson("{}"))
                .willReturn(
                    ok(MAPPER.writeValueAsString(MOCK_IP_POLICY))
                        .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            delete(urlPathEqualTo("/ip_policies/" + MOCK_IP_POLICY.getId()))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(noContent())
        );

        wireMock.stubFor(
            post(urlPathEqualTo("/ip_policy_rules"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), containing("application/json"))
                .withRequestBody(equalToJson(MAPPER.writeValueAsString(IP_POLICY_RULE_CREATE)))
                .willReturn(
                    ok(MAPPER.writeValueAsString(MOCK_IP_POLICY_RULE))
                        .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
        )
      );

        wireMock.stubFor(
            delete(urlPathEqualTo("/ip_policy_rules/" + MOCK_IP_POLICY_RULE.getId()))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(noContent())
        );
    }

    @Test
    public void testIpPoliciesAndRules() throws InterruptedException {
        final String policyId = createIpPolicy();
        try {
            final String ruleId = assertCreateIpPolicyRule(policyId);
            deleteIpPolicyRule(ruleId);
        } finally {
            deleteIpPolicy(policyId);
        }
    }

    private String createIpPolicy() throws InterruptedException {
        return ngrok().ipPolicies().create().blockingCall().getId();
    }

    private void deleteIpPolicy(final String id) throws InterruptedException {
        ngrok().ipPolicies().delete(id).blockingCall();
    }

    private String assertCreateIpPolicyRule(final String policyId) throws InterruptedException {
        final IpPolicyRule rule = ngrok().ipPolicyRules().create("10.1.2.0/24", policyId, "allow").blockingCall();
        assertThat(rule.getIpPolicy().getId()).isEqualTo(policyId);
        assertThat(rule.getAction()).isEqualTo("allow");
        assertThat(rule.getCidr()).isEqualTo("10.1.2.0/24");
        return rule.getId();
    }

    private void deleteIpPolicyRule(final String id) throws InterruptedException {
        ngrok().ipPolicyRules().delete(id).blockingCall();
    }
}
