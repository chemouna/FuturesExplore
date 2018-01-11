package com.mounacheikhna.futuresexplore;

public class FrameModel {

    public static void main(String[] args) {
        Provider provider = new Provider(() -> {
            // Im a slow supplier, so lets wait for a while
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            return new ModelKeeper();
        });

        provider.getActiveThing();
    }

}
