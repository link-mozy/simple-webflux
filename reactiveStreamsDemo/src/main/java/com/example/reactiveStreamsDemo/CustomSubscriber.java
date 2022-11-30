package com.example.reactiveStreamsDemo;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// 데이터를 소모하는 역할
public class CustomSubscriber implements Subscriber<Integer> {

    @Override
    public void onSubscribe(Subscription s) {
        // 1. 받을수 이쓴ㄴ 모든 데이터를 요청
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext : " + integer);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError : " + t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
