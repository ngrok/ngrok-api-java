/* Code generated for API Clients. DO NOT EDIT. */

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
     *  ngrok that violate ngrok&#39;s terms of service.
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
     *  to provision and manage API Keys but you&#39;ll need to provision your first
     * API
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
     * Creates a service client for ApplicationSessions.
     *
     * See also <a href="https://ngrok.com/docs/api#api-application-sessions">https://ngrok.com/docs/api#api-application-sessions</a>.
     *
     * @return a service client
     */
    public ApplicationSessions applicationSessions() {
        return new ApplicationSessions(this.apiClient);
    }
    
    /**
     * Creates a service client for ApplicationUsers.
     *
     * See also <a href="https://ngrok.com/docs/api#api-application-users">https://ngrok.com/docs/api#api-application-users</a>.
     *
     * @return a service client
     */
    public ApplicationUsers applicationUsers() {
        return new ApplicationUsers(this.apiClient);
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
     * Creates a service client for BotUsers.
     *
     * See also <a href="https://ngrok.com/docs/api#api-bot-users">https://ngrok.com/docs/api#api-bot-users</a>.
     *
     * @return a service client
     */
    public BotUsers botUsers() {
        return new BotUsers(this.apiClient);
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
     *  the <code>ngrok config add-authtoken</code> command or by specifying it in the
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
     * Endpoints provides an API for querying the endpoint objects
     *  which define what tunnel or edge is used to serve a hostport.
     *  Only active endpoints associated with a tunnel or backend are returned.
     *
     * See also <a href="https://ngrok.com/docs/api#api-endpoints">https://ngrok.com/docs/api#api-endpoints</a>.
     *
     * @return a service client
     */
    public Endpoints endpoints() {
        return new Endpoints(this.apiClient);
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
     *  initiate traffic to a specific aspect of your ngrok account. An IP
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
     *  This CNAME record points traffic for that domain to ngrok&#39;s edge servers.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains">https://ngrok.com/docs/api#api-reserved-domains</a>.
     *
     * @return a service client
     */
    public ReservedDomains reservedDomains() {
        return new ReservedDomains(this.apiClient);
    }
    
    /**
     * Secrets is an api service for securely storing and managing sensitive data such
     * as secrets, credentials, and tokens.
     *
     * See also <a href="https://ngrok.com/docs/api#api-secrets">https://ngrok.com/docs/api#api-secrets</a>.
     *
     * @return a service client
     */
    public Secrets secrets() {
        return new Secrets(this.apiClient);
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
     * Vaults is an api service for securely storing and managing sensitive data such
     * as secrets, credentials, and tokens.
     *
     * See also <a href="https://ngrok.com/docs/api#api-vaults">https://ngrok.com/docs/api#api-vaults</a>.
     *
     * @return a service client
     */
    public Vaults vaults() {
        return new Vaults(this.apiClient);
    }
    
    /**
     * Creates a namespace object for Backends.
     *
     * @return a namespace object
     */
    public BackendsNamespace backends() {
        return new BackendsNamespace();
    }
    
    /**
     * Creates a namespace object for Edges.
     *
     * @return a namespace object
     */
    public EdgesNamespace edges() {
        return new EdgesNamespace();
    }
    
    /**
     * Creates a namespace object for EdgeModules.
     *
     * @return a namespace object
     */
    public EdgeModulesNamespace edgeModules() {
        return new EdgeModulesNamespace();
    }
    
    /**
     * A namespace object for Backends.
     */
    public class BackendsNamespace {
        private BackendsNamespace() {}
        
        /**
         * A Failover backend defines failover behavior within a list of referenced
         *  backends. Traffic is sent to the first backend in the list. If that backend
         *  is offline or no connection can be established, ngrok attempts to connect to
         *  the next backend in the list until one is successful.
         *
         * See also <a href="https://ngrok.com/docs/api#api-failover-backends">https://ngrok.com/docs/api#api-failover-backends</a>
         *
         * @return a service client
         */
        public FailoverBackends failover() {
            return new FailoverBackends(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link HttpResponseBackends}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-http-response-backends">https://ngrok.com/docs/api#api-http-response-backends</a>
         *
         * @return a service client
         */
        public HttpResponseBackends httpResponse() {
            return new HttpResponseBackends(Ngrok.this.apiClient);
        }
        
        /**
         * A static backend sends traffic to a TCP address (hostname and port) that
         *  is reachable on the public internet.
         *
         * See also <a href="https://ngrok.com/docs/api#api-static-backends">https://ngrok.com/docs/api#api-static-backends</a>
         *
         * @return a service client
         */
        public StaticBackends staticAddress() {
            return new StaticBackends(Ngrok.this.apiClient);
        }
        
        /**
         * A Tunnel Group Backend balances traffic among all online tunnels that match
         *  a label selector.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tunnel-group-backends">https://ngrok.com/docs/api#api-tunnel-group-backends</a>
         *
         * @return a service client
         */
        public TunnelGroupBackends tunnelGroup() {
            return new TunnelGroupBackends(Ngrok.this.apiClient);
        }
        
        /**
         * A Weighted Backend balances traffic among the referenced backends. Traffic
         *  is assigned proportionally to each based on its weight. The percentage of
         *  traffic is calculated by dividing a backend&#39;s weight by the sum of all
         *  weights.
         *
         * See also <a href="https://ngrok.com/docs/api#api-weighted-backends">https://ngrok.com/docs/api#api-weighted-backends</a>
         *
         * @return a service client
         */
        public WeightedBackends weighted() {
            return new WeightedBackends(Ngrok.this.apiClient);
        }
        
    }
    /**
     * A namespace object for Edges.
     */
    public class EdgesNamespace {
        private EdgesNamespace() {}
        
        /**
         * Creates a service client for {@link EdgesHttpsRoutes}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edges-https-routes">https://ngrok.com/docs/api#api-edges-https-routes</a>
         *
         * @return a service client
         */
        public EdgesHttpsRoutes httpsRoutes() {
            return new EdgesHttpsRoutes(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgesHttps}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edges-https">https://ngrok.com/docs/api#api-edges-https</a>
         *
         * @return a service client
         */
        public EdgesHttps https() {
            return new EdgesHttps(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgesTcp}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edges-tcp">https://ngrok.com/docs/api#api-edges-tcp</a>
         *
         * @return a service client
         */
        public EdgesTcp tcp() {
            return new EdgesTcp(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgesTls}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edges-tls">https://ngrok.com/docs/api#api-edges-tls</a>
         *
         * @return a service client
         */
        public EdgesTls tls() {
            return new EdgesTls(Ngrok.this.apiClient);
        }
        
    }
    /**
     * A namespace object for EdgeModules.
     */
    public class EdgeModulesNamespace {
        private EdgeModulesNamespace() {}
        
        /**
         * Creates a service client for {@link HttpsEdgeMutualTlsModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-https-edge-mutual-tls-module">https://ngrok.com/docs/api#api-https-edge-mutual-tls-module</a>
         *
         * @return a service client
         */
        public HttpsEdgeMutualTlsModule httpsEdgeMutualTls() {
            return new HttpsEdgeMutualTlsModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link HttpsEdgeTlsTerminationModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-https-edge-tls-termination-module">https://ngrok.com/docs/api#api-https-edge-tls-termination-module</a>
         *
         * @return a service client
         */
        public HttpsEdgeTlsTerminationModule httpsEdgeTlsTermination() {
            return new HttpsEdgeTlsTerminationModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteBackendModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-backend-module">https://ngrok.com/docs/api#api-edge-route-backend-module</a>
         *
         * @return a service client
         */
        public EdgeRouteBackendModule httpsEdgeRouteBackend() {
            return new EdgeRouteBackendModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteIpRestrictionModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-ip-restriction-module">https://ngrok.com/docs/api#api-edge-route-ip-restriction-module</a>
         *
         * @return a service client
         */
        public EdgeRouteIpRestrictionModule httpsEdgeRouteIpRestriction() {
            return new EdgeRouteIpRestrictionModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteRequestHeadersModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-request-headers-module">https://ngrok.com/docs/api#api-edge-route-request-headers-module</a>
         *
         * @return a service client
         */
        public EdgeRouteRequestHeadersModule httpsEdgeRouteRequestHeaders() {
            return new EdgeRouteRequestHeadersModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteResponseHeadersModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-response-headers-module">https://ngrok.com/docs/api#api-edge-route-response-headers-module</a>
         *
         * @return a service client
         */
        public EdgeRouteResponseHeadersModule httpsEdgeRouteResponseHeaders() {
            return new EdgeRouteResponseHeadersModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteCompressionModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-compression-module">https://ngrok.com/docs/api#api-edge-route-compression-module</a>
         *
         * @return a service client
         */
        public EdgeRouteCompressionModule httpsEdgeRouteCompression() {
            return new EdgeRouteCompressionModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteCircuitBreakerModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-circuit-breaker-module">https://ngrok.com/docs/api#api-edge-route-circuit-breaker-module</a>
         *
         * @return a service client
         */
        public EdgeRouteCircuitBreakerModule httpsEdgeRouteCircuitBreaker() {
            return new EdgeRouteCircuitBreakerModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteWebhookVerificationModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-webhook-verification-module">https://ngrok.com/docs/api#api-edge-route-webhook-verification-module</a>
         *
         * @return a service client
         */
        public EdgeRouteWebhookVerificationModule httpsEdgeRouteWebhookVerification() {
            return new EdgeRouteWebhookVerificationModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteOAuthModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-o-auth-module">https://ngrok.com/docs/api#api-edge-route-o-auth-module</a>
         *
         * @return a service client
         */
        public EdgeRouteOAuthModule httpsEdgeRouteOauth() {
            return new EdgeRouteOAuthModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteSamlModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-saml-module">https://ngrok.com/docs/api#api-edge-route-saml-module</a>
         *
         * @return a service client
         */
        public EdgeRouteSamlModule httpsEdgeRouteSaml() {
            return new EdgeRouteSamlModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteOidcModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-oidc-module">https://ngrok.com/docs/api#api-edge-route-oidc-module</a>
         *
         * @return a service client
         */
        public EdgeRouteOidcModule httpsEdgeRouteOidc() {
            return new EdgeRouteOidcModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteWebsocketTcpConverterModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-websocket-tcp-converter-module">https://ngrok.com/docs/api#api-edge-route-websocket-tcp-converter-module</a>
         *
         * @return a service client
         */
        public EdgeRouteWebsocketTcpConverterModule httpsEdgeRouteWebsocketTcpConverter() {
            return new EdgeRouteWebsocketTcpConverterModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteUserAgentFilterModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-user-agent-filter-module">https://ngrok.com/docs/api#api-edge-route-user-agent-filter-module</a>
         *
         * @return a service client
         */
        public EdgeRouteUserAgentFilterModule httpsEdgeRouteUserAgentFilter() {
            return new EdgeRouteUserAgentFilterModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link EdgeRouteTrafficPolicyModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-edge-route-traffic-policy-module">https://ngrok.com/docs/api#api-edge-route-traffic-policy-module</a>
         *
         * @return a service client
         */
        public EdgeRouteTrafficPolicyModule httpsEdgeRouteTrafficPolicy() {
            return new EdgeRouteTrafficPolicyModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link TcpEdgeBackendModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tcp-edge-backend-module">https://ngrok.com/docs/api#api-tcp-edge-backend-module</a>
         *
         * @return a service client
         */
        public TcpEdgeBackendModule tcpEdgeBackend() {
            return new TcpEdgeBackendModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link TcpEdgeIpRestrictionModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module">https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module</a>
         *
         * @return a service client
         */
        public TcpEdgeIpRestrictionModule tcpEdgeIpRestriction() {
            return new TcpEdgeIpRestrictionModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link TcpEdgeTrafficPolicyModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tcp-edge-traffic-policy-module">https://ngrok.com/docs/api#api-tcp-edge-traffic-policy-module</a>
         *
         * @return a service client
         */
        public TcpEdgeTrafficPolicyModule tcpEdgeTrafficPolicy() {
            return new TcpEdgeTrafficPolicyModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link TlsEdgeBackendModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tls-edge-backend-module">https://ngrok.com/docs/api#api-tls-edge-backend-module</a>
         *
         * @return a service client
         */
        public TlsEdgeBackendModule tlsEdgeBackend() {
            return new TlsEdgeBackendModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link TlsEdgeIpRestrictionModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tls-edge-ip-restriction-module">https://ngrok.com/docs/api#api-tls-edge-ip-restriction-module</a>
         *
         * @return a service client
         */
        public TlsEdgeIpRestrictionModule tlsEdgeIpRestriction() {
            return new TlsEdgeIpRestrictionModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link TlsEdgeMutualTlsModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tls-edge-mutual-tls-module">https://ngrok.com/docs/api#api-tls-edge-mutual-tls-module</a>
         *
         * @return a service client
         */
        public TlsEdgeMutualTlsModule tlsEdgeMutualTls() {
            return new TlsEdgeMutualTlsModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link TlsEdgeTlsTerminationModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tls-edge-tls-termination-module">https://ngrok.com/docs/api#api-tls-edge-tls-termination-module</a>
         *
         * @return a service client
         */
        public TlsEdgeTlsTerminationModule tlsEdgeTlsTermination() {
            return new TlsEdgeTlsTerminationModule(Ngrok.this.apiClient);
        }
        
        /**
         * Creates a service client for {@link TlsEdgeTrafficPolicyModule}.
         *
         * See also <a href="https://ngrok.com/docs/api#api-tls-edge-traffic-policy-module">https://ngrok.com/docs/api#api-tls-edge-traffic-policy-module</a>
         *
         * @return a service client
         */
        public TlsEdgeTrafficPolicyModule tlsEdgeTrafficPolicy() {
            return new TlsEdgeTrafficPolicyModule(Ngrok.this.apiClient);
        }
        
    }
}
