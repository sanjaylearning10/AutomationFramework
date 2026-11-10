package com.pogo;

import java.util.Map;

public class Config {
    private Map<String, Env> environments;

    public Map<String, Env> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<String, Env> environments) {
        this.environments = environments;
    }
}
