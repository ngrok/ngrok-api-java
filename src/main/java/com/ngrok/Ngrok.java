package com.ngrok;

import com.ngrok.services.*;

import java.util.Objects;

/**
 * Main entry point for the ngrok API.
 */
public class Ngrok {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new ngrok API instance using the default API client.
     *
     * @param apiKey API key used to access the ngrok API
     * @return an ngrok API instance
     */
    public static Ngrok createDefault(final String apiKey) {
        return new Ngrok(DefaultNgrokApiClient.newBuilder(apiKey).build());
    }

    /**
     * Creates a new ngrok API instance using the default API client.
     *
     * The API key is pulled from the environment variable <code>NGROK_API_KEY</code>.
     *
     * @return an ngrok API instance
     */
    public static Ngrok createDefault() {
        return createDefault(System.getenv("NGROK_API_KEY"));
    }

    /**
     * Create a new ngrok API instance.
     *
     * @param apiClient an instance of {@link NgrokApiClient}
     * @see DefaultNgrokApiClient
     */
    public Ngrok(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * Abuse Reports allow you to submit take-down requests for URLs hosted by
     *  ngrok that violate ngrok's terms of service.
     *
     * See also <a href="https://ngrok.com/docs/api#api-abuse-reports">https://ngrok.com/docs/api#api-abuse-reports</a>.
     *
     * @return a service client
     */
    public AbuseReports abuseReports() {
        return new AbuseReports(this.apiClient);
    }
    
    /**
     * Creates a service client for AgentIngresses.
     *
     * See also <a href="https://ngrok.com/docs/api#api-agent-ingresses">https://ngrok.com/docs/api#api-agent-ingresses</a>.
     *
     * @return a service client
     */
    public AgentIngresses agentIngresses() {
        return new AgentIngresses(this.apiClient);
    }
    
    /**
     * API Keys are used to authenticate to the <a
     * href="https://ngrok.com/docs/api#authentication">ngrok
     *  API</a>. You may use the API itself
     *  to provision and manage API Keys but you'll need to provision your first API
     *  key from the <a href="https://dashboard.ngrok.com/api/keys">API Keys page</a>
     * on your
     *  ngrok.com dashboard.
     *
     * See also <a href="https://ngrok.com/docs/api#api-api-keys">https://ngrok.com/docs/api#api-api-keys</a>.
     *
     * @return a service client
     */
    public ApiKeys apiKeys() {
        return new ApiKeys(this.apiClient);
    }
    
    /**
     * Certificate Authorities are x509 certificates that are used to sign other
     *  x509 certificates. Attach a Certificate Authority to the Mutual TLS module
     *  to verify that the TLS certificate presented by a client has been signed by
     *  this CA. Certificate Authorities  are used only for mTLS validation only and
     *  thus a private key is not included in the resource.
     *
     * See also <a href="https://ngrok.com/docs/api#api-certificate-authorities">https://ngrok.com/docs/api#api-certificate-authorities</a>.
     *
     * @return a service client
     */
    public CertificateAuthorities certificateAuthorities() {
        return new CertificateAuthorities(this.apiClient);
    }
    
    /**
     * Tunnel Credentials are ngrok agent authtokens. They authorize the ngrok
     *  agent to connect the ngrok service as your account. They are installed with
     *  the <code>ngrok authtoken</code> command or by specifying it in the
     * <code>ngrok.yml</code>
     *  configuration file with the <code>authtoken</code> property.
     *
     * See also <a href="https://ngrok.com/docs/api#api-credentials">https://ngrok.com/docs/api#api-credentials</a>.
     *
     * @return a service client
     */
    public Credentials credentials() {
        return new Credentials(this.apiClient);
    }
    
    /**
     * Endpoint Configurations are a reusable group of modules that encapsulate how
     *  traffic to a domain or address is handled. Endpoint configurations are only
     *  applied to Domains and TCP Addresses they have been attached to.
     *
     * See also <a href="https://ngrok.com/docs/api#api-endpoint-configurations">https://ngrok.com/docs/api#api-endpoint-configurations</a>.
     *
     * @return a service client
     */
    public EndpointConfigurations endpointConfigurations() {
        return new EndpointConfigurations(this.apiClient);
    }
    
    /**
     * Creates a service client for EventStreams.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-streams">https://ngrok.com/docs/api#api-event-streams</a>.
     *
     * @return a service client
     */
    public EventStreams eventStreams() {
        return new EventStreams(this.apiClient);
    }
    
    /**
     * Creates a service client for EventDestinations.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-destinations">https://ngrok.com/docs/api#api-event-destinations</a>.
     *
     * @return a service client
     */
    public EventDestinations eventDestinations() {
        return new EventDestinations(this.apiClient);
    }
    
    /**
     * Creates a service client for EventSubscriptions.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-subscriptions">https://ngrok.com/docs/api#api-event-subscriptions</a>.
     *
     * @return a service client
     */
    public EventSubscriptions eventSubscriptions() {
        return new EventSubscriptions(this.apiClient);
    }
    
    /**
     * Creates a service client for EventSources.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-sources">https://ngrok.com/docs/api#api-event-sources</a>.
     *
     * @return a service client
     */
    public EventSources eventSources() {
        return new EventSources(this.apiClient);
    }
    
    /**
     * IP Policies are reusable groups of CIDR ranges with an <code>allow</code> or
     * <code>deny</code>
     *  action. They can be attached to endpoints via the Endpoint Configuration IP
     *  Policy module. They can also be used with IP Restrictions to control source
     *  IP ranges that can start tunnel sessions and connect to the API and dashboard.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policies">https://ngrok.com/docs/api#api-ip-policies</a>.
     *
     * @return a service client
     */
    public IpPolicies ipPolicies() {
        return new IpPolicies(this.apiClient);
    }
    
    /**
     * IP Policy Rules are the IPv4 or IPv6 CIDRs entries that
     *  make up an IP Policy.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policy-rules">https://ngrok.com/docs/api#api-ip-policy-rules</a>.
     *
     * @return a service client
     */
    public IpPolicyRules ipPolicyRules() {
        return new IpPolicyRules(this.apiClient);
    }
    
    /**
     * An IP restriction is a restriction placed on the CIDRs that are allowed to
     *  initate traffic to a specific aspect of your ngrok account. An IP
     *  restriction has a type which defines the ingress it applies to. IP
     *  restrictions can be used to enforce the source IPs that can make API
     *  requests, log in to the dashboard, start ngrok agents, and connect to your
     *  public-facing endpoints.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-restrictions">https://ngrok.com/docs/api#api-ip-restrictions</a>.
     *
     * @return a service client
     */
    public IpRestrictions ipRestrictions() {
        return new IpRestrictions(this.apiClient);
    }
    
    /**
     * Reserved Addresses are TCP addresses that can be used to listen for traffic.
     *  TCP address hostnames and ports are assigned by ngrok, they cannot be
     *  chosen.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-addrs">https://ngrok.com/docs/api#api-reserved-addrs</a>.
     *
     * @return a service client
     */
    public ReservedAddrs reservedAddrs() {
        return new ReservedAddrs(this.apiClient);
    }
    
    /**
     * Reserved Domains are hostnames that you can listen for traffic on. Domains
     *  can be used to listen for http, https or tls traffic. You may use a domain
     *  that you own by creating a CNAME record specified in the returned resource.
     *  This CNAME record points traffic for that domain to ngrok's edge servers.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains">https://ngrok.com/docs/api#api-reserved-domains</a>.
     *
     * @return a service client
     */
    public ReservedDomains reservedDomains() {
        return new ReservedDomains(this.apiClient);
    }
    
    /**
     * An SSH Certificate Authority is a pair of an SSH Certificate and its private
     *  key that can be used to sign other SSH host and user certificates.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-certificate-authorities">https://ngrok.com/docs/api#api-ssh-certificate-authorities</a>.
     *
     * @return a service client
     */
    public SshCertificateAuthorities sshCertificateAuthorities() {
        return new SshCertificateAuthorities(this.apiClient);
    }
    
    /**
     * SSH Credentials are SSH public keys that can be used to start SSH tunnels
     *  via the ngrok SSH tunnel gateway.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-credentials">https://ngrok.com/docs/api#api-ssh-credentials</a>.
     *
     * @return a service client
     */
    public SshCredentials sshCredentials() {
        return new SshCredentials(this.apiClient);
    }
    
    /**
     * SSH Host Certificates along with the corresponding private key allows an SSH
     *  server to assert its authenticity to connecting SSH clients who trust the
     *  SSH Certificate Authority that was used to sign the certificate.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-host-certificates">https://ngrok.com/docs/api#api-ssh-host-certificates</a>.
     *
     * @return a service client
     */
    public SshHostCertificates sshHostCertificates() {
        return new SshHostCertificates(this.apiClient);
    }
    
    /**
     * SSH User Certificates are presented by SSH clients when connecting to an SSH
     *  server to authenticate their connection. The SSH server must trust the SSH
     *  Certificate Authority used to sign the certificate.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-user-certificates">https://ngrok.com/docs/api#api-ssh-user-certificates</a>.
     *
     * @return a service client
     */
    public SshUserCertificates sshUserCertificates() {
        return new SshUserCertificates(this.apiClient);
    }
    
    /**
     * TLS Certificates are pairs of x509 certificates and their matching private
     *  key that can be used to terminate TLS traffic. TLS certificates are unused
     *  until they are attached to a Domain. TLS Certificates may also be
     *  provisioned by ngrok automatically for domains on which you have enabled
     *  automated certificate provisioning.
     *
     * See also <a href="https://ngrok.com/docs/api#api-tls-certificates">https://ngrok.com/docs/api#api-tls-certificates</a>.
     *
     * @return a service client
     */
    public TlsCertificates tlsCertificates() {
        return new TlsCertificates(this.apiClient);
    }
    
    /**
     * Tunnel Sessions represent instances of ngrok agents or SSH reverse tunnel
     *  sessions that are running and connected to the ngrok service. Each tunnel
     *  session can include one or more Tunnels.
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-sessions">https://ngrok.com/docs/api#api-tunnel-sessions</a>.
     *
     * @return a service client
     */
    public TunnelSessions tunnelSessions() {
        return new TunnelSessions(this.apiClient);
    }
    
    /**
     * Tunnels provide endpoints to access services exposed by a running ngrok
     *  agent tunnel session or an SSH reverse tunnel session.
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnels">https://ngrok.com/docs/api#api-tunnels</a>.
     *
     * @return a service client
     */
    public Tunnels tunnels() {
        return new Tunnels(this.apiClient);
    }
    
    /**
     * Creates a namespace object for PointcfgModule.
     *
     * @return a namespace object
     */
    public PointcfgModuleNamespace pointcfgModule() {
        return new PointcfgModuleNamespace();
    }
    
    /**
     * A namespace object for PointcfgModule.
     */
    public class PointcfgModuleNamespace {
        private PointcfgModuleNamespace() {}
        
        /**
         * Creates a service client for {@link EndpointLoggingModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-logging-module">https://ngrok.com/docs/api#api-endpoint-logging-module</a>
         *
         * @return a service client
         */
        public EndpointLoggingModule logging() {
            return new EndpointLoggingModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointCircuitBreakerModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-circuit-breaker-module">https://ngrok.com/docs/api#api-endpoint-circuit-breaker-module</a>
         *
         * @return a service client
         */
        public EndpointCircuitBreakerModule circuitBreaker() {
            return new EndpointCircuitBreakerModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointCompressionModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-compression-module">https://ngrok.com/docs/api#api-endpoint-compression-module</a>
         *
         * @return a service client
         */
        public EndpointCompressionModule compression() {
            return new EndpointCompressionModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointTlsTerminationModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-tls-termination-module">https://ngrok.com/docs/api#api-endpoint-tls-termination-module</a>
         *
         * @return a service client
         */
        public EndpointTlsTerminationModule tlsTermination() {
            return new EndpointTlsTerminationModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointIpPolicyModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-ip-policy-module">https://ngrok.com/docs/api#api-endpoint-ip-policy-module</a>
         *
         * @return a service client
         */
        public EndpointIpPolicyModule ipPolicy() {
            return new EndpointIpPolicyModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointMutualTlsModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-mutual-tls-module">https://ngrok.com/docs/api#api-endpoint-mutual-tls-module</a>
         *
         * @return a service client
         */
        public EndpointMutualTlsModule mutualTls() {
            return new EndpointMutualTlsModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointRequestHeadersModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-request-headers-module">https://ngrok.com/docs/api#api-endpoint-request-headers-module</a>
         *
         * @return a service client
         */
        public EndpointRequestHeadersModule requestHeaders() {
            return new EndpointRequestHeadersModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointResponseHeadersModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-response-headers-module">https://ngrok.com/docs/api#api-endpoint-response-headers-module</a>
         *
         * @return a service client
         */
        public EndpointResponseHeadersModule responseHeaders() {
            return new EndpointResponseHeadersModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointOAuthModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-o-auth-module">https://ngrok.com/docs/api#api-endpoint-o-auth-module</a>
         *
         * @return a service client
         */
        public EndpointOAuthModule oauth() {
            return new EndpointOAuthModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointWebhookValidationModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-webhook-validation-module">https://ngrok.com/docs/api#api-endpoint-webhook-validation-module</a>
         *
         * @return a service client
         */
        public EndpointWebhookValidationModule webhookValidation() {
            return new EndpointWebhookValidationModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointSamlModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-saml-module">https://ngrok.com/docs/api#api-endpoint-saml-module</a>
         *
         * @return a service client
         */
        public EndpointSamlModule saml() {
            return new EndpointSamlModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointOidcModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-endpoint-oidc-module">https://ngrok.com/docs/api#api-endpoint-oidc-module</a>
         *
         * @return a service client
         */
        public EndpointOidcModule oidc() {
            return new EndpointOidcModule(Ngrok.this.apiClient);
        }
        
    }
}
