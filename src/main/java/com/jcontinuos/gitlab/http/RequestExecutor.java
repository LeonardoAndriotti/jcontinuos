package com.jcontinuos.gitlab.http;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Component
public class RequestExecutor {

    private RestTemplate restTemplate = new RestTemplate();


    public <T> ResponseEntity<T> get(String url, Map<String, String> urlParams, Class<T> responseType) throws HttpClientErrorException, URISyntaxException {
        return execute(HttpMethod.GET, url, null, urlParams, responseType);
    }

    public <T> ResponseEntity<T> post(String url, Object value, Map<String, String> urlParams, Class<T> responseType) throws HttpClientErrorException, URISyntaxException {
        return execute(HttpMethod.POST, url, value, urlParams, responseType);
    }

    public <T> ResponseEntity<T> put(String url, Object value, Map<String, String> urlParams, Class<T> responseType) throws HttpClientErrorException, URISyntaxException {
        return execute(HttpMethod.PUT, url, value, urlParams, responseType);
    }

    private <T> ResponseEntity<T> execute(HttpMethod method, String url, Object value, Map<String, String> urlParams, Class<T> responseType) throws HttpClientErrorException, URISyntaxException {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(url);

        //HttpHeaders headers = new HttpHeaders();
        //headers.add("Authorization", "Basic " + b2WConfiguration.getEncryptedKey());

        URI uri = new URI(urlBuilder.toString());

        RequestEntity<Object> request = new RequestEntity<>(value, null, method, uri);

        return this.restTemplate.exchange(request, responseType);
    }
}
