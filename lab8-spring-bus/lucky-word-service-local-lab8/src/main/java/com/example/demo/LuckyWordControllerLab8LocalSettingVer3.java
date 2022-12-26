package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LuckyWordControllerLab8LocalSettingVer3 {

    @Value("${word-local-config.luckyWord}")
    String luckyWord;
    @Value("${word-local-config.preamble}")
    String preamble;

    @GetMapping("/lucky-word3")
    public String showLuckyWorld() {
        return preamble+": "+luckyWord;
    }

    public String getLuckyWord() {
        return luckyWord;
    }

    public void setLuckyWord(String luckyWord) {
        this.luckyWord = luckyWord;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }
}
