/**
 * 
 */
package com.spring.core;

import com.spring.core.properties.SecurityProperties1;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhailiang
 *
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties1.class)
public class SecurityCoreConfig {

}
