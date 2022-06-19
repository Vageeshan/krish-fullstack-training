package com.innovation.session_one.Controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 04:31 am Saturday
 **/

@Component
@Endpoint(id = "stage")
public class StageEndpoint {

    Map<String, Stage> stages = new ConcurrentHashMap<>();

    @ReadOperation
    public Map<String, Stage> getStages() {
        // this is a GET operation
        return stages;
    }

    @ReadOperation
    public Stage getStage(@Selector String name) {
        // this is a POST operation & Selector always in a URL path
        return stages.get(name);
    }

    @WriteOperation
    public void setValue(@Selector String name, int stage) {
        this.stages.put(name, new Stage(stage));
    }

    static class Stage {
        int value;

        public Stage(int value) {
            this.value = value;
        }

        public Stage() {
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
