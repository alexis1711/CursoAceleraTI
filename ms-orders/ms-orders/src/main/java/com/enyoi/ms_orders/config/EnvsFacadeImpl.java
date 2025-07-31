package com.enyoi.ms_orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvsFacadeImpl implements EnvsFacade{

    @Value("${app.envs.client.host}")
    private String host;

    @Override
    public String getClientHostEnv() {
        return host;
    }
}
