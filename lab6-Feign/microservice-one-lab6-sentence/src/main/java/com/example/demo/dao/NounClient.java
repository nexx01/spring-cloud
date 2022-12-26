package com.example.demo.dao;

import com.example.demo.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Noun")
public interface NounClient {

    @GetMapping("/")
    public Word getWord();

}
