package com.example.reactiveStreamsDemo;

import org.reactivestreams.Subscription;

// CustomPublisher 에게 데이터 수를 요청하고, cancel 요청을 하며, BackPressure 동작에 중요한 역할
public class CustomSubscription implements Subscription {
    @Override
    public void request(long n) {

    }

    @Override
    public void cancel() {

    }
}
