/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import java.net.URI;
import java.util.Optional;

/**
 * Interface indicating a resource type that can have more than one page of responses.
 */
public interface Pageable {
    /**
     * Fetches the URI of the next page.
     *
     * @return a URI
     */
    Optional<URI> getNextPageUri();
}
