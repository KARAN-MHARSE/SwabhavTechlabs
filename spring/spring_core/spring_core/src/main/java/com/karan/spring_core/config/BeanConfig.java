package com.karan.spring_core.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackages = "com.karan.spring_core.model")
public class BeanConfig {

}
