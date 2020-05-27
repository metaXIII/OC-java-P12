package com.blog.article.proxy;

import com.blog.article.model.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "blog-gateway", url = "http://localhost:8080")
public interface GatewayProxy {
    @GetMapping("api/user/exist/{name}")
    ResponseEntity<Boolean> userExist(@PathVariable("name") String name);

    @PostMapping("api/mail/send")
    ResponseEntity sendEmail(@RequestBody Article article);
}
