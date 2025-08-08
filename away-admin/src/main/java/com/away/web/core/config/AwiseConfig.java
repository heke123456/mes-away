package com.away.web.core.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 新增一个MyConfig类，扫描com.awise，以将awise-**模块中的所有组件纳入spring管理
 * @author
 */
@Configuration
@ComponentScan(basePackages = "com.awise")
public class AwiseConfig {
}
