package com.example.demo;

import com.example.demo.dao.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

    WordService wordService;

    public SentenceServiceImpl(WordService wordService) {
        this.wordService = wordService;
    }

    @Override
    public String buildSentence() {
        String sentence = "There was a problem assembling the sentence!";
        sentence =
                String.format("%s %s %s %s %s.",
//                String.format("%s %s.",
                        wordService.getSubject().getString(),
                        wordService.getVerb().getString()
                        ,
                        wordService.getAdjective().getString(),
                        wordService.getArticle().getString(),
                        wordService.getNoun().getString()
                );
        return sentence;
    }


}
