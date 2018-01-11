package com.mounacheikhna.futuresexplore;

public class FrameModel {

    public static void main(String[] args) {
        Provider provider = new Provider(() -> {
            // Im a slow supplier, so lets wait for a while
            //Thread.sleep(1000);
            Misc.sleepWithProgress("Supplier of ModelKeeper ");
            return new ModelKeeper();
        });

        System.out.println("First ");
        provider.getActiveThing();
        System.out.println("Next action after First in FrameModel can now run");

        System.out.println("Second ");
        provider.getActiveThing();
        System.out.println("Next action after Second in FrameModel can now run");

        System.out.println("Third ");
        provider.getActiveThing();
        System.out.println("Next action after Third in FrameModel can now run");

        // what do we want ? here
        // the options we have are to block or provide a callable thing ?
    }

}
