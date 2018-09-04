package com.ps.rxrelay.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.ReplayRelay;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    /*Relay<String> relay = BehaviorRelay.create();*/
    /*Emits
    subscribe,
    onSubscribe,
    onNext(3),
    4,
    onNext,
    5,
    onNext,
    6,
    onNext*/

    /*Relay<String> relay = PublishRelay.create();*/
    /*Emits
    subscribe,
    onSubscribe,
    4,
    onNext,
    5,
    onNext,
    6,
    onNext*/

    /*Relay<String> relay = ReplayRelay.create();*/
    /*Emits
    subscribe,
    onSubscribe,
    onNext,
    1,
    2,
    3,
    4,
    onNext,
    5,
    onNext,
    6,
    onNext*/

    Relay<String> relay = BehaviorRelay.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickMeFunction(View view) {
        relay.accept("one");
        relay.accept("two");
        relay.accept("three");
        relay.subscribe(getObservable());
        relay.accept("four");
        relay.accept("five");
        relay.accept("six");
    }

    Observer<String> getObservable() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String value) {
                System.out.println(value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
    }
}