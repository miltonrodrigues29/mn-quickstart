package com.milton.udemy;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;


@Singleton
public class MySecondService implements MyService {
    public String helloFromService()
    {
        return "Hello from Second service";
    }
}
