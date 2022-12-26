package com.example.demo;

import com.example.demo.dao.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    VerbClient verbService;
    @Autowired
    SubjectClient subjectService;
    @Autowired
    ArticleClient articleService;
    @Autowired
    AdjectiveClient adjectiveService;
    @Autowired
    NounClient nounService;


    @Override
    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public Word getSubject() {
        return subjectService.getWord();
    }

    public Word getFallbackSubject() {
        return
        new Word("someOne");
    }

    @Override
    public Word getVerb() {
        return verbService.getWord();
    }

    @Override
    public Word getArticle() {
        return articleService.getWord();
    }

    @Override
    public Word getAdjective() {
        return adjectiveService.getWord();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackNoun")
    public Word getNoun() {
        return nounService.getWord();
    }

    public Word getFallBackNoun() {
        return new Word("someNoun");
    }
}
