package com.mounacheikhna.futuresexplore;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Executors;

public class Start {

    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Explosion> explosion = service.submit(() -> {
            Thread.sleep(10000);
            return pushBigRedButton();
        });

        Futures.addCallback(explosion, new FutureCallback<Explosion>() {
            // we want this handler to run immediately after we push the big red button!
            public void onSuccess(Explosion explosion) {
                walkAwayFrom(explosion);
            }
            public void onFailure(Throwable thrown) {
                battleArchNemesis(); // escaped the explosion!
            }
        }, Executors.newSingleThreadExecutor());
    }

    private static void battleArchNemesis() {
        System.out.println("battleArchNemesis");
    }

    private static Explosion pushBigRedButton() {
        return new Explosion("Big explosion");
    }

    private static void walkAwayFrom(Explosion explosion) {
        System.out.println("Walk away from " + explosion);
    }

    static class Explosion {
        String name;

        public Explosion(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Explosion{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
