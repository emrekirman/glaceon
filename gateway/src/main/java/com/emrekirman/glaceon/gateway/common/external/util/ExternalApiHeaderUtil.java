package com.emrekirman.glaceon.gateway.common.external.util;

import com.emrekirman.glaceon.gateway.security.SessionInformation;
import org.springframework.http.HttpHeaders;

public class ExternalApiHeaderUtil {


    /**
     * The class that performs the necessary transformation to carry the User information,
     * which we took from the Jwt token and moved into the SecurityContextHolder,
     * while sending requests to other microservices.
     */
    public static HttpHeaders getRequestHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", SessionInformation.getBase64());

        return headers;
    }
}
