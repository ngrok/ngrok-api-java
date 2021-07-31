package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Representation of an API error from ngrok.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NgrokApiError extends RuntimeException {
    /** */
    private final int httpStatusCode;
    /** */
    private final Optional<String> errorCode;
    /** */
    private final Map<String, String> details;

    /**
     * Creates a new API error.
     *
     * @param message informative message
     * @param httpStatusCode HTTP response status
     * @param errorCode ngrok API error code
     * @param details arbitrary error details
     */
    @JsonCreator
    public NgrokApiError(@JsonProperty("msg") final String message,
                         @JsonProperty("status_code") final int httpStatusCode,
                         @JsonProperty("error_code") final Optional<String> errorCode,
                         @JsonProperty("details") final Map<String, String> details)
    {
        super(message != null ? message : "HTTP server returned status " + httpStatusCode);
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode != null ? errorCode : Optional.empty();
        this.details = details != null ? details : Collections.emptyMap();
    }

    /**
     * Creates a new API error.
     *
     * @param httpStatusCode HTTP response status
     * @param responseBody possible response body
     * @param cause exception cause
     */
    public NgrokApiError(final int httpStatusCode, final Optional<String> responseBody, final Throwable cause) {
        super(cause.getMessage(), cause);
        this.httpStatusCode = httpStatusCode;
        this.errorCode = Optional.empty();
        this.details = responseBody.map(body -> {
            final Map<String, String> details = new HashMap<>();
            details.put("response_body", body);
            return Collections.unmodifiableMap(details);
        }).orElse(Collections.emptyMap());
    }

    /**
     * Creates a new API error.
     *
     * @param httpStatusCode HTTP response status
     */
    public NgrokApiError(final int httpStatusCode) {
        this("HTTP server returned status " + httpStatusCode, httpStatusCode, Optional.empty(), Collections.emptyMap());
    }

    /**
     * Fetches the HTTP status code.
     *
     * @return HTTP response status
     */
    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    /**
     * Fetches the ngrok API error code, if any.
     *
     * @return ngrok API error code
     */
    public Optional<String> getErrorCode() {
        return this.errorCode;
    }

    /**
     * Fetches any further details about the error.
     *
     * @return key-value map containing error details
     */
    public Map<String, String> getDetails() {
        return this.details;
    }

    /**
     * Checks if this error object contains one of the provided codes.
     *
     * @param codes error codes to check
     * @return whether or not one of the codes matches what is in this error object
     */
    public boolean isErrorCode(final String... codes) {
        final Set<String> codeSet = new HashSet<>(Arrays.asList(codes));
        return this.errorCode.filter(codeSet::contains).isPresent();
    }
}
