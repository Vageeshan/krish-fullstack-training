package com.innovation.ui.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:10 am Sunday
 **/

public class AccessToken {
    public static String extractAccessTokenFromContext() {
        OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) SecurityContextHolder
                .getContext()
                .getAuthentication().getDetails();
        return oAuth2AuthenticationDetails.getTokenType().concat(" ").concat(oAuth2AuthenticationDetails.getTokenValue());
    }
}
