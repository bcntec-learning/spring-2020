package bcntec.spring.templates.rest;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;


@Component
public class MyTemplate {

    public static final String apiUrl = "http://localhost:8080/";
    public static final String apiToken = "MyToken";
    private static final Logger log = LoggerFactory.getLogger(MyTemplate.class);

    @Getter
    private final RestTemplate restTemplate = new RestTemplate();

    @Nullable
    static Charset getCharset(ClientHttpResponse response) {
        HttpHeaders headers = response.getHeaders();
        MediaType contentType = headers.getContentType();
        return (contentType != null ? contentType.getCharset() : null);
    }

    public static ResponseErrorHandler errorHandler() {
        return new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse httpResponse)
                    throws IOException {
                HttpStatus status = httpResponse.getStatusCode();

                return ( httpResponse.getHeaders().get("Error")!=null ||
                        status.series() == CLIENT_ERROR
                                || status.series() == SERVER_ERROR);
            }

            @Override
            public void handleError(ClientHttpResponse httpResponse) throws IOException {
                try {
                    String errorText = StreamUtils.copyToString(httpResponse.getBody(), (getCharset(httpResponse) == null ? Charset.forName("UTF-8") : getCharset(httpResponse)));
                    log.error(httpResponse.getStatusCode() + "/" + errorText);
                    switch (httpResponse.getStatusCode()) {
                        case NOT_FOUND:
                            throw new MyNotFoundException();
                    }

                } catch (IOException e) {
                    log.error("code error:" + httpResponse.getStatusCode());
                }
            }
        };
    }

    @PostConstruct
    public void init() {

        restTemplate.setErrorHandler(errorHandler());
    }

    public <T> T get(String endpoint, Class<T> entityType) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl + endpoint);
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(headers()), entityType).getBody();
    }

    public <T> ResponseEntity<T> get(String endpoint, MultiValueMap<String, String> params, Class<T> t) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl + endpoint).queryParams(params);
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(headers()), t);
    }

    public <T, B> ResponseEntity<T> post(String endpoint, B body, Class<T> t) {
        return exchange(endpoint, HttpMethod.POST, body, t, false);
    }

    public <T, B> ResponseEntity<T> post(String endpoint, B body, Class<T> t, boolean isToken) {
        return exchange(endpoint, HttpMethod.POST, body, t, isToken);
    }

    public <T, B> ResponseEntity<T> put(String endpoint, B body, Class<T> t) {
        return exchange(endpoint, HttpMethod.PUT, body, t, false);
    }

    public <T, B> ResponseEntity<T> delete(String endpoint, B body, Class<T> t) {
        return exchange(apiUrl + endpoint, HttpMethod.DELETE, body, t, false);
    }

    private <T, B> ResponseEntity<T> exchange(String endpoint, HttpMethod method, B body, Class<T> t, boolean isToken) {
        HttpEntity<B> entity = new HttpEntity<>(body, headers());
        return restTemplate.exchange(((isToken ? StringUtils.replace(apiUrl, "v1/", "") : apiUrl) + endpoint), method, entity, t);
    }

    protected HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer " + apiToken);
        headers.set("ALLIANZ-SUBSIDIARY", "ES");
        return headers;
    }


}
