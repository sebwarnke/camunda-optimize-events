package com.camunda.consulting.examples;

import com.camunda.consulting.simulator.SimulationExecutor;
import com.camunda.consulting.simulator.SimulatorPlugin;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        SimulationExecutor.execute(DateTime.now().minusMonths(1).toDate(), DateTime.now().toDate());
    }

    @Bean
    public SimulatorPlugin simulatorPlugin() {
        return new SimulatorPlugin();
    }

    @Bean
    JavaDelegate doWork() {
        return delegateExecution -> {
            System.out.println("Step done");
        };
    }
}