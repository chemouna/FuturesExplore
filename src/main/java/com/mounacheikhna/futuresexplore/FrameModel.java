package com.mounacheikhna.futuresexplore;

public class FrameModel {

    public static void main(String[] args) {
        Provider provider = new Provider(() -> {
            // Im a slow supplier, so lets wait for a while
            //Thread.sleep(1000);
            Misc.sleepWithProgress("Supplier of ModelKeeper ");
            return new ModelKeeper();
        });

        provider.getActiveThing();

        // what do we want ? here

        // the options we have are to block or provide a callable thing ?
        System.out.println("Next action in FrameModel can now run (will determine whether getting active thing blocked us)");
    }

}
