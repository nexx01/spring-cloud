package com.example.demo;

import com.example.demo.dao.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executor;

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

    @Autowired
    Executor executor;


    @Override
    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public Observable<Word> getSubject() {
        return
                Observable.fromCallable(() ->
                        new Word(subjectService.getWord().getWord(), Word.Role.subject)
                ).subscribeOn(Schedulers.from(executor));
    }

    public Word getFallbackSubject() {
        return
        new Word("someOne", Word.Role.subject);
    }

    @Override
    public Observable<Word> getVerb() {
        return Observable.fromCallable(

                () -> new Word(verbService.getWord().getWord(), Word.Role.verb)
        ).subscribeOn(Schedulers.from(executor));

    }

    @Override
    public Observable<Word> getArticle() {
        return

                Observable.fromCallable(() ->
                                new Word(articleService.getWord().getWord(), Word.Role.article))
                        .subscribeOn(Schedulers.from(executor));
    }

    @Override
    public Observable<Word> getAdjective() {
        return Observable.fromCallable(() ->
                        new Word(adjectiveService.getWord().getWord(), Word.Role.adjective))
                .subscribeOn(Schedulers.from(executor));
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackNoun")
    public Observable<Word> getNoun() {
        return
                Observable.fromCallable(() -> new Word(nounService.getWord().getWord(), Word.Role.noun))
                        .subscribeOn(Schedulers.from(executor));
    }

    public Word getFallBackNoun() {
        return new Word("someNoun", Word.Role.noun);
    }
}
