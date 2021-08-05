package com.customertimes.framework.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("file:src/test/resources/config.properties")
public interface TestConfig extends Config {
    TestConfig CONFIG = ConfigFactory.create(TestConfig.class, System.getenv(), System.getProperties());

    @DefaultValue("Chrome")
    String browser();

    String browserVersion();

    //@DefaultValue("true")
    boolean remote();

    @Key("selenium.server.url")
    String seleniumServerUrl();

    @Key("base.url")
    String baseUrl();
}
