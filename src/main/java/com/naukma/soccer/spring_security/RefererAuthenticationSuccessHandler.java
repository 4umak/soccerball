package com.naukma.soccer.spring_security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

class RefererAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    RefererAuthenticationSuccessHandler() {
        super();
        setDefaultTargetUrl("http://localhost:63342/soccer/frontend/index.html?_ijt=cacjv983ukbm910lbahvbefl78");
    }
}

