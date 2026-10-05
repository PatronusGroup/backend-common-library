package com.patronusgroup.common.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.patronusgroup.common.gateway"])
class CommonBeanAutoConfiguration