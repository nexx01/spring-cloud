package com.example.demo.dao;

import com.example.demo.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Subject")
public interface SubjectClient {

    @GetMapping("/")
    public Word getWord();

}
