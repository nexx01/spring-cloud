package com.example.demo;

import com.example.demo.dao.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class SentenceServiceImpl implements SentenceService {

    WordService wordService;

    public SentenceServiceImpl(WordService wordService) {
        this.wordService = wordService;
    }

    @Override
    public String buildSentence() {
//        String sentence = "There was a problem assembling the sentence!";

        final Sentence sentence = new Sentence();

        List<Observable<Word>> observables = createObservables();

        CountDownLatch latch = new CountDownLatch(observables.size());

        Observable.merge(observables)
                .subscribe(
                        (word) -> {
                            sentence.add(word);
                            latch.countDown();
                        });

        waitForAll(latch);


        return sentence.toString();
    }

    private void waitForAll(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This code launches calls to all 5 child services,
     * using Observables to monitor the completion:
     */
    private List<Observable<Word>> createObservables(){
        List<Observable<Word>> observables = new ArrayList<>();
        observables.add(wordService.getSubject());
        observables.add(wordService.getVerb());
        observables.add(wordService.getArticle());
        observables.add(wordService.getAdjective());
        observables.add(wordService.getNoun());
        return observables;
    }


}
