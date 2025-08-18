package priv.bocayouth.common.core.utils.http;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import priv.bocayouth.common.core.utils.SpringUtils;
import priv.bocayouth.common.core.utils.jackson.JsonUtils;

/**
 * @author Olsond
 * @date 2025/8/18 04:39
 * @description
 */
public class RestClientUtils {

    private static final RestTemplate restTemplate = SpringUtils.getBean("restTemplate");

    /**
     * get调用
     *
     * @param url           url
     * @param typeReference 返回参数泛型类型
     * @param urlVariables  url参数
     * @return
     */
    public static <T> T getForObject(String url, TypeReference<T> typeReference, Object... urlVariables) {
        HttpEntity<String> entity = new HttpEntity<String>(getHttpHeaders());
        String json = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, urlVariables).getBody();
        return JsonUtils.parseObject(json, typeReference);
    }

    /**
     * @param url
     * @param httpHeaders
     * @param typeReference
     * @param urlVariables
     * @param <T>
     * @return
     */
    public static <T> T getForObject(String url, HttpHeaders httpHeaders, TypeReference<T> typeReference, Object... urlVariables) {
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
        String json = restTemplate.exchange(url, HttpMethod.GET, entity,
                String.class, urlVariables).getBody();
        return JsonUtils.parseObject(json, typeReference);
    }

    /**
     * POST 请求
     *
     * @param url           url
     * @param request       请求参数对象
     * @param typeReference 返回Object 类型
     * @param urlVariables  url参数
     * @return
     */
    public static <T> T postForObject(String url, Object request, TypeReference<T> typeReference, Object... urlVariables) {
        String requestJson = request == null ? "" : JsonUtils.toJsonString(request);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, getHttpHeaders());
        String json = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, urlVariables).getBody();
        return JsonUtils.parseObject(json, typeReference);
    }

    /**
     * @param url
     * @param request
     * @param httpHeaders
     * @param typeReference
     * @param urlVariables
     * @param <T>
     * @return
     */
    public static <T> T postForObject(String url, Object request, HttpHeaders httpHeaders, TypeReference<T> typeReference,
                               Object... urlVariables) {
        String requestJson = request == null ? "" : JsonUtils.toJsonString(request);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,
                httpHeaders);
        String json = restTemplate.exchange(url, HttpMethod.POST, entity,
                String.class, urlVariables).getBody();
        return JsonUtils.parseObject(json, typeReference);
    }

    /**
     * POST 请求
     *
     * @param url           url
     * @param request       请求参数对象
     * @param typeReference 返回Object 类型
     * @param urlVariables  url参数
     * @return
     */
    public static <T> T exchangeForObject(HttpMethod httpMethod, String url, Object request, TypeReference<T> typeReference,
                                   Object... urlVariables) {
        String requestJson = request == null ? "" : JsonUtils.toJsonString(request);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, getHttpHeaders());
        String json = restTemplate.exchange(url, httpMethod, entity, String.class, urlVariables).getBody();
        return JsonUtils.parseObject(json, typeReference);
    }

    /**
     * @param url
     * @param request
     * @param httpHeaders
     * @param typeReference
     * @param urlVariables
     * @param <T>
     * @return
     */
    public static <T> T exchangeForObject(HttpMethod httpMethod, String url, Object request, HttpHeaders httpHeaders,
                                   TypeReference<T> typeReference, Object... urlVariables) {
        String requestJson = request == null ? "" : JsonUtils.toJsonString(request);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,
                httpHeaders);
        String json = restTemplate.exchange(url, httpMethod, entity, String.class, urlVariables).getBody();
        return JsonUtils.parseObject(json, typeReference);
    }


    /**
     * 设置通用的头信息
     *
     * @return
     */
    public static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=UTF-8");
        headers.set("Accept", "application/json");
        return headers;
    }
}
