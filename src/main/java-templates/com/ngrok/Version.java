package com.ngrok;

/**
 * Client version information
 */
public abstract class Version {
    /**
     * The ngrok API version in use
     */
    public static final String API_VERSION = "2";

    /**
     * This API client's version string
     */
    public static final String CLIENT_VERSION = "${project.version}";

    private Version() {}
}
