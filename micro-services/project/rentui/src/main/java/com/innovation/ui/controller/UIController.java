package com.innovation.ui.controller;

import com.innovation.rentcloud.model.customer.Customer;
import com.innovation.ui.config.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.Principal;
import java.util.Arrays;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 02:36 am Sunday
 **/

@Controller
public class UIController {

    private static final String CUSTOMER_URI = "http://localhost:8081/api/v1/customers";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClient;

    @GetMapping("/")
    public String loadUI() {
        return "home";
    }

    @GetMapping("/protect-me")
    public String getProtectedPage(Principal principal) {
        System.out.println("Credentials....... " + principal);
        return "protected";
    }

    @GetMapping("/customers")
    public String loadCustomers(Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.extractAccessTokenFromContext());
        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<Customer[]> responseEntity = restTemplate
                    .exchange(CUSTOMER_URI,
                            HttpMethod.GET,
                            customerHttpEntity, Customer[].class);
            System.out.println("Token is " + AccessToken.extractAccessTokenFromContext());
            System.out.println("Response is " + responseEntity);
            System.out.println("Response body is " + Arrays.toString(responseEntity.getBody()));
            System.out.println("Token Exact " + AccessToken.extractAccessTokenFromContext().substring(7));
            Customer[] cus = webClient.build().get()
                    .uri(CUSTOMER_URI)
                    .headers(httpHeaders1 -> httpHeaders1.setBearerAuth(AccessToken.extractAccessTokenFromContext().substring(7)))
                    .retrieve()
                    .bodyToMono(Customer[].class)
                    .block();

//            model.addAttribute("customers", responseEntity.getBody());
            model.addAttribute("customers", cus);
        } catch (HttpStatusCodeException httpStatusCodeException) {
            ResponseEntity<String> responseEntity = ResponseEntity.status(httpStatusCodeException.getRawStatusCode())
                    .headers(httpStatusCodeException.getResponseHeaders())
                    .body(httpStatusCodeException.getResponseBodyAsString());
            System.out.println("Exception " + responseEntity);
            model.addAttribute("errors", responseEntity);
        }
        return "protected";
    }
}
