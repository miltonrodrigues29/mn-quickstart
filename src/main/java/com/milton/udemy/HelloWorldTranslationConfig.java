package com.milton.udemy;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("hello.world.translation")
public interface HelloWorldTranslationConfig {

    String getDe();
    String getEn();
}
