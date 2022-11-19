package ru.golikov.activity_example.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DataGeneratorService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        Random random = new Random();
        delegateExecution.setVariable("randomData", random.nextInt(100));
    }
}
