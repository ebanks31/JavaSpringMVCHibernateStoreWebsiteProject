package com.ebanks.springapp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:webSecurityConfig.xml" })
public class SecSecurityConfig {
   public SecSecurityConfig() {
      super();
   }
}