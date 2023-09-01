<!-- Code generated for API Clients. DO NOT EDIT. -->

# Unstable

This library is currently unstable. We know of rough edges
and are working to bring it to parity with our other API client
libraries. Please feel free to try it out and let us know if you find
it useful!

# ngrok API client library for Java

This library wraps the [ngrok HTTP API](https://ngrok.com/docs/api) to
make it easier to consume in Java.

## Usage

This library is published on [Maven
Central](https://search.maven.org/artifact/com.ngrok/ngrok-api-java).

In your Maven `pom.xml` file, add:

```xml
<dependencies>
  <dependency>
    <groupId>com.ngrok</groupId>
    <artifactId>ngrok-api-java</artifactId>
    <version>${ngrok-api-java.version}</version>
  </dependency>
</dependencies>
```

See the above URL for the latest version of the API client.

## Support

The best place to get support using this library is through the [ngrok Slack Community](https://ngrok.com/slack). If you find any bugs, please contribute by opening a [new GitHub issue](https://github.com/ngrok/ngrok-api-java/issues/new/choose).

## Documentation

All objects, methods and properties are documented with Javadoc for
integration with an IDE like IntelliJ IDEA or Eclipse. You can also
[view the documentation online](https://java-api.docs.ngrok.com/).

Beyond that, this readme is the best source of documentation for the
library.

### Versioning

This class library is published to Maven Central using semantic
versioning. Breaking changes to the API will only be released with a
bump of the major version number. Each released commit is tagged in
this repository.

No compatibility promises are made for versions < 1.0.0.

### Quickstart

First, use the ngrok dashboard to generate an API key. Store that in a
safe place. Inject it into your application using the environment
variable `NGROK_API_KEY`. The `Ngrok.createDefault()` method will pull
from that environment variable. If you prefer, you can also pass the API
key explicitly.

#### Create an IP Policy that allows traffic from some subnets

```java
import com.ngrok.*;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Example {
    public static void main(final String[] args) {
        final var ngrok = Ngrok.createDefault();

        ngrok.ipPolicies().create().call().thenCompose(policy ->
            CompletableFuture.allOf(
                Stream.of("24.0.0.0/8", "12.0.0.0/8")
                    .map(cidr ->
                        ngrok.ipPolicyRules()
                            .create(cidr, policy.getId(), "allow")
                            .call()
                            .toCompletableFuture()
                    )
                    .toArray(CompletableFuture[]::new)
            )
        ).toCompletableFuture().join();
    }
}
```

#### List all online tunnels

```java
import com.ngrok.*;
import com.ngrok.definitions.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(final String[] args) {
        final var ngrok = Ngrok.createDefault();

        System.out.println("Tunnels:");
        ngrok.tunnels().list().call()
            .thenCompose(tunnelPage -> printRecursively(ngrok, tunnelPage))
            .toCompletableFuture().join();
    }

    private static CompletionStage<Void> printRecursively(final Ngrok ngrok, final Page<TunnelList> currentPage) {
        currentPage.getPage().getTunnels.forEach(System.out::println);
        return currentPage.next().thenCompose(maybeTunnelPage -> maybeTunnelPage
            .map(tunnelPage -> printRecursively(ngrok, tunnelPage))
            .orElseGet(() -> CompletableFuture.<Void>completedFuture(null))
        );
    }
}
```

### Conventions

Conventional usage of this package is to construct a root `Ngrok` object
using the static `createDefault()` method. You can then access API
resources using that object. Do not construct the individual API
resource client classes in your application code.

You can also customize low-level behavior by instantiating the
`DefaultNgrokApiClient` yourself, and then using it to construct the
`Ngrok` instance. If you'd like to use a different HTTP library
entirely, you can even implement the `NgrokApiClient` interface
yourself.

```java
import com.ngrok.*;

public class Example {
    public static void main(final String[] args) {
        // Create the root api client using an API key from the environment variable NGROK_API_KEY
        final var defaultNgrok = Ngrok.createDefault();

        // ... or create the root api client using an API key provided directly
        final var defaultNgrokWithApiKey = Ngrok.createDefault("my secret api key");

        // ... or create the root api client by customizing the low-level networking details
        final var customApiClient = DefaultNgrokApiClient
            .newBuilder(System.getenv("NGROK_API_KEY"))
            .ojectMapper(new ObjectMapper().registerModule(new JavaTimeModule()).registerModule(new Jdk8Module()))
            .baseUri(URI.create("https://some-other-server.com"))
            .build();
        final var ngrokWithCustomApiClient = new Ngrok(customApiClient);

        // Clients for all api resources (like ip policies) are acccessible via methods on the root client
        final var policy = defaultNgrok.ipPolicies()
            .get(policyId)
            .call().toCompletableFuture().join();

        // Some api resources are 'namespaced' through another method
        final var circuitBreaker = defaultNgrok.pointcfgModule()
            .circuitBreaker()
            .get(endpointConfigId).call()
            .toCompletableFuture().join();
    }
}
```

### Paging

All list responses from the ngrok API are paged. All list response
objects implement the `Pageable` interface, and are wrapped in a `Page`
class, which has a `next()` method. Calling `next()` will asyncronously
request the next page. If no next page is available, an empty `Optional`
will be returned inside the `CompletionStage`.

```java
import com.ngrok.*;
import com.ngrok.definitions.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(final String[] args) {
        final var ngrok = Ngrok.createDefault();

        ngrok.credentials().list().call()
            .thenCompose(credentialPage -> printRecursively(ngrok, credentiasPage))
            .toCompletableFuture().join();
    }

    private static CompletionStage<Void> printRecursively(final Ngrok ngrok, final Page<CredentialList> currentPage) {
        currentPage.getPage().getTunnels.forEach(System.out::println);
        return currentPage.next().thenCompose(maybeCredentialPage -> maybeCredentialPage
            .map(credentialPage -> printRecursively(ngrok, credentialPage))
            .orElseGet(() -> CompletableFuture.<Void>completedFuture(null))
        );
    }
}
```

### Error Handling

All errors returned by the ngrok API are serialized as structured
payloads for easy error handling. If a structured error is returned by
the ngrok API, this library will return a failed `CompletionStage`
containing a `NgrokApiError`.

This object will allow you to check the unique ngrok error code and the
http status code of a failed response. Use the `getErrorCode()` method
to check for unique ngrok error codes returned by the API. All error
codes are documented at
[https://ngrok.com/docs/errors](https://ngrok.com/docs/errors). There is
also an `isErrorCode()` method on the exception object to check against
multiple error codes. The `getHttpStatusCode()` method can be used to
check not found errors.

Other non-structured errors encountered while making an API call from
e.g. networking or serialization failures are not wrapped in any way and
will bubble up as normal.

```java
import com.ngrok.*;
import com.ngrok.definitions.*;

public class Example {
    public static void main(final String[] args) {
        final var ngrok = Ngrok.createDefault();

        ngrok.reservedDomains().create(System.getenv("NGROK_DOMAIN"))
            .description("example domain")
            .call()
            .whenComplete((domain, error) -> {
                if (error != null) {
                    if (error instanceof NgrokApiError ngrokError) {
                        if (ngrokError.isErrorCode("NGROK_ERR_402", "NGROK_ERR_403")) {
                            System.out.println("Ignoring invalid wildcard domain.");
                        } else {
                            System.out.printf("API Error (%s): %s%n", ngrokError.getErrorCode().orElse(""), ngrokError.getMessage());
                        }
                    } else {
                        System.out.println("Other error: " + error.getMessage());
                    }
                } else {
                    System.out.println("Successfully reserved domain");
                }
            })
            .toCompletableFuture().join();
    }
}
```

### Datatype Overrides

All datatype objects in the ngrok API library properly override
`equals()` and `hashCode()` so that the objects can be compared.
Similarly, they override `toString()` for more helpful pretty printing
of ngrok domain objects.

### Sync / Async Interfaces

The `call()` method on each API client operation is asynchronous and
returns a `CompletionStage`. If you require a synchronous call, you can
use `blockingCall()` instead.
