package priv.bocayouth.common.core.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.*;
import org.springframework.web.client.RestClient;
import priv.bocayouth.common.core.config.properties.HttpToolProperties;
import priv.bocayouth.common.core.exception.base.BaseException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties(HttpToolProperties.class)
@AutoConfigureAfter(HttpClientAutoConfiguration.class)
public class HttpToolAutoConfig {

    @Bean
    public RestClient restClient(ObjectProvider<ClientHttpRequestFactory> factoryObjectProvider) {
        RestClient.Builder builder = RestClient.builder();
        if (factoryObjectProvider.getIfAvailable() != null) {
            builder.requestFactory(factoryObjectProvider.getIfAvailable());
        }
        // 添加通用拦截器
        builder.requestInterceptor(new LoggingInterceptor());
        // 添加错误处理器
        builder.defaultStatusHandler(
                HttpStatusCode::is5xxServerError,
                (request, response) -> new BaseException(response.getStatusText())
        );
        return builder.build();
    }

    @Bean
    @ConditionalOnMissingBean(ClientHttpRequestFactory.class)
    @ConditionalOnProperty(name = "http-client.enabled", havingValue = "true")
    public ClientHttpRequestFactory apacheClientHttpRequestFactory(HttpToolProperties properties) {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(properties.getMaxConnTotal());
        connectionManager.setDefaultMaxPerRoute(properties.getMaxConnPerRoute());
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectionRequestTimeout(properties.getConnectTimeout(), TimeUnit.MILLISECONDS)
                        .setResponseTimeout(properties.getReadTimeout(), TimeUnit.MILLISECONDS)
                        .build())
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Slf4j
    static class LoggingInterceptor implements ClientHttpRequestInterceptor {
        @NotNull
        @Override
        public ClientHttpResponse intercept(@NotNull HttpRequest request, @NotNull byte[] body,
                                            ClientHttpRequestExecution execution) throws IOException {
            requestLog(request, body);
            ClientHttpResponse response = execution.execute(request, body);
            responseLog(response);
            return response;
        }

        private void requestLog(HttpRequest request, byte[] body) {
            log.info("==================== request start ====================");
            log.info("Uri         :{}", request.getURI());
            log.info("Method      :{}", request.getMethod());
            log.info("Headers     :{}", request.getHeaders());
            log.info("Request Body:{}", new String(body, StandardCharsets.UTF_8));
            log.info("==================== request end ====================");
        }

        private void responseLog(ClientHttpResponse response) throws IOException {
            log.info("==================== response start ====================");
            log.info("Status Code  :{}", response.getStatusCode());
            log.info("Status Text  :{}", response.getStatusText());
            log.info("Headers      :{}", response.getHeaders());
            log.info("==================== response end ====================");
        }
    }


}