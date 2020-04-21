package com.mobby.attendance.core.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.core.enums.ResultCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.net.MalformedURLException;
import java.util.Arrays;

/**
 * @author hulu
 * @ClassName ResultResponseHandler.java
 * @Description
 * @createTime 2020年04月11日 13:38:00
 */
@RestControllerAdvice
public class ResultResponseHandler implements ResponseBodyAdvice<Object> {

    private ThreadLocal<ObjectMapper> mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);

    private static final Class[] annos = {
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class,
            ExceptionHandler.class
    };

    private static final String[] ignores = new String[]{
            "/swagger-resources",
            "/v2/api-docs"
    };

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        AnnotatedElement element = returnType.getAnnotatedElement();
        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object out;
        ObjectMapper mapper = mapperThreadLocal.get();
        String url = null;
        try {
            url = request.getURI().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // 过滤swagger请求
        if (this.ignoring(request.getURI().toString())) {
            return body;
        }

        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if(body instanceof Result){
            out = body;
        }
        else if (body instanceof String){
            Result result = Result.success(body);
            try {
                out = mapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                out = Result.failure(ResultCode.JSON_PARSE_ERROR);
            }
        }
        else{
            out = Result.success(body);
        }
        return out;
    }

    /**
     * 判断url是否需要拦截
     * @param uri
     * @return
     */
    private boolean ignoring(String uri) {
        for (String string : ignores) {
            if (uri.contains(string)) {
                return true;
            }
        }
        return false;
    }
}
