package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {
    @Autowired SentenceService sentenceService;


    /**
     * Display a small list of Sentences to the caller:
     */
    @GetMapping("/sentence")
    public @ResponseBody String getSentence() {
        long start = System.currentTimeMillis();

        String s = "<h3>Some Sentences</h3><br/>" +
                sentenceService.buildSentence() + "<br/><br/>" +
                sentenceService.buildSentence() + "<br/><br/>" +
                sentenceService.buildSentence() + "<br/><br/>" +
                sentenceService.buildSentence() + "<br/><br/>" +
                sentenceService.buildSentence() + "<br/><br/>";


        long end = System.currentTimeMillis();
        return s + "Elapsed time : " + (end - start);
    }
}
