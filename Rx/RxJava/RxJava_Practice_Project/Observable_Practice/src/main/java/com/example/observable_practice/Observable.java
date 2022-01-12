package com.example.observable_practice;

import java.util.Observer;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Observable {

    Observable<Integer> observableString =
            observable.create(new Observable.OnSubscribe<Integer>() {
                @Override
                public void call(Subscriber<? super Integer> observer) {
                    for (int i = 0; i < 5; i++) {
                        observer.onNext(i);
                    }

                    observer.onComplete();
                }
            });
    Subscription subscriptionPrint =
            observableString.subscribe(new Observer<Integer>() {
                @Override
                public void onCompleted() {
                    System.out.println("Observable completed");
                }
            });
}
