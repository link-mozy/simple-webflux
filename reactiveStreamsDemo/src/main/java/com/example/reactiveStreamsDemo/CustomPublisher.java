package com.example.reactiveStreamsDemo;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 데이터를 제공하는 역할
public class CustomPublisher implements Publisher<Integer> {
    // 1. 1-10 까지의 데이터를 제공
    List<Integer> integers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        // 2. 나머지는 CustomSubscription 에서 구현
        s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                try {
                    integers
                            .stream()
                            .limit(n)
                            .forEach(i -> {
                                if (i > 11) {
                                    throw new IllegalArgumentException("integer must be under 11");
                                }
                                s.onNext(i);
                            });
                } catch (Exception e) {
                    s.onError(e);
                }

                s.onComplete();
            }

            @Override
            public void cancel() {
                System.out.println("cansel");
            }
        });
    }
}
