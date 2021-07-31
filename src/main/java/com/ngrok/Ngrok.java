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
     * @return a service client
     */
    public AbuseReports abuseReports() {
        return new AbuseReports(this.apiClient);
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
     * @return a service client
     */
    public EndpointConfigurations endpointConfigurations() {
        return new EndpointConfigurations(this.apiClient);
    }
    
    /**
     * Creates a service client for EventStreams.
     *
     * @return a service client
     */
    public EventStreams eventStreams() {
        return new EventStreams(this.apiClient);
    }
    
    /**
     * Creates a service client for EventDestinations.
     *
     * @return a service client
     */
    public EventDestinations eventDestinations() {
        return new EventDestinations(this.apiClient);
    }
    
    /**
     * Creates a service client for EventSubscriptions.
     *
     * @return a service client
     */
    public EventSubscriptions eventSubscriptions() {
        return new EventSubscriptions(this.apiClient);
    }
    
    /**
     * Creates a service client for EventSources.
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
     * @return a service client
     */
    public IpPolicies ipPolicies() {
        return new IpPolicies(this.apiClient);
    }
    
    /**
     * IP Policy Rules are the IPv4 or IPv6 CIDRs entries that
     *  make up an IP Policy.
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
     * @return a service client
     */
    public IpRestrictions ipRestrictions() {
        return new IpRestrictions(this.apiClient);
    }
    
    /**
     * The IP Whitelist is deprecated and will be removed. Use an IP Restriction
     *  with an <code>endpoints</code> type instead.
     *
     * @return a service client
     */
    public IpWhitelist ipWhitelist() {
        return new IpWhitelist(this.apiClient);
    }
    
    /**
     * Reserved Addresses are TCP addresses that can be used to listen for traffic.
     *  TCP address hostnames and ports are assigned by ngrok, they cannot be
     *  chosen.
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
     * @return a service client
     */
    public ReservedDomains reservedDomains() {
        return new ReservedDomains(this.apiClient);
    }
    
    /**
     * An SSH Certificate Authority is a pair of an SSH Certificate and its private
     *  key that can be used to sign other SSH host and user certificates.
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
     * @return a service client
     */
    public TunnelSessions tunnelSessions() {
        return new TunnelSessions(this.apiClient);
    }
    
    /**
     * Tunnels provide endpoints to access services exposed by a running ngrok
     *  agent tunnel session or an SSH reverse tunnel session.
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
         * @return a service client
         */
        public EndpointLoggingModule logging() {
            return new EndpointLoggingModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointCircuitBreakerModule}.
         *
         * @return a service client
         */
        public EndpointCircuitBreakerModule circuitBreaker() {
            return new EndpointCircuitBreakerModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointCompressionModule}.
         *
         * @return a service client
         */
        public EndpointCompressionModule compression() {
            return new EndpointCompressionModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointTlsTerminationModule}.
         *
         * @return a service client
         */
        public EndpointTlsTerminationModule tlsTermination() {
            return new EndpointTlsTerminationModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointIpPolicyModule}.
         *
         * @return a service client
         */
        public EndpointIpPolicyModule ipPolicy() {
            return new EndpointIpPolicyModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointMutualTlsModule}.
         *
         * @return a service client
         */
        public EndpointMutualTlsModule mutualTls() {
            return new EndpointMutualTlsModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointRequestHeadersModule}.
         *
         * @return a service client
         */
        public EndpointRequestHeadersModule requestHeaders() {
            return new EndpointRequestHeadersModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointResponseHeadersModule}.
         *
         * @return a service client
         */
        public EndpointResponseHeadersModule responseHeaders() {
            return new EndpointResponseHeadersModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointOAuthModule}.
         *
         * @return a service client
         */
        public EndpointOAuthModule oauth() {
            return new EndpointOAuthModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointWebhookValidationModule}.
         *
         * @return a service client
         */
        public EndpointWebhookValidationModule webhookValidation() {
            return new EndpointWebhookValidationModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointSamlModule}.
         *
         * @return a service client
         */
        public EndpointSamlModule saml() {
            return new EndpointSamlModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EndpointOidcModule}.
         *
         * @return a service client
         */
        public EndpointOidcModule oidc() {
            return new EndpointOidcModule(Ngrok.this.apiClient);
        }
        
    }
}
