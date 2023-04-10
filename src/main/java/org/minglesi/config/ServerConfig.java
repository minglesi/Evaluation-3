package org.minglesi.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class ServerConfig extends ResourceConfig {
    public ServerConfig() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}
