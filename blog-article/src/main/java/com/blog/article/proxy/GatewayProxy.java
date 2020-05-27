package com.blog.article.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "blog-article", url = "http://localhost:8080")
public interface GatewayProxy {
}
