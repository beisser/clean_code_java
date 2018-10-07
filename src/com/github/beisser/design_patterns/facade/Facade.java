package com.github.beisser.design_patterns.facade;

import java.util.Map;

/**
 * Facade
 *
 * Providing a simple, easy to understand public API around a complex functionality / chunk of code where the
 * internals remain hidden / private
 *
 * facade: simple usage public API built to communicate with low level interfaces
 */

// e.g. the ModelFacade provides access to the app configuration
// in general the user of this configuration does not care about
// how the config is loaded and stuff

interface ConfigurationProvider {
    boolean getBooleanEntry(String key);
    String getStringEntry(String key);
}

interface ConfigContainer {
    public void readConfig();
}

class ConfigurationProviderImpl implements ConfigurationProvider {

    private ConfigContainer container;

    public ConfigContainer getContainer() {
        return container;
    }

    public void setContainer(ConfigContainer container) {
        this.container = container;
    }

    @Override
    public boolean getBooleanEntry(String key) {
        return false;
    }

    @Override
    public String getStringEntry(String key) {
        return null;
    }

    // ...complex configuration setup with environments, defaults etc
    public class DefaultConfigContainer implements ConfigContainer{
        @Override
        public void readConfig() {

        }
    }

    public class EnvironmentConfigContainer implements ConfigContainer{
        @Override
        public void readConfig() {

        }
    }

}

// ModelFacade
class ModelFacade {

    public void init() {
        // does the complex setup of the configurationprovider
        // so the model facade has direct access to the configuration out of the box
    }

    private ConfigurationProvider config;


}
