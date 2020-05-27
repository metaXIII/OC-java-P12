package com.blog.article.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "blog-gateway", url = "http://localhost:8080")
public interface GatewayProxy {
    @GetMapping("api/user/exist/{name}")
    ResponseEntity<Boolean> userExist(@PathVariable("name") String name);
}
