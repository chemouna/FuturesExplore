package com.mounacheikhna.futuresexplore;

import java.io.IOException;

public final class Misc {

    public static void sleepWithProgress(String name) {
        String anim = "|/-\\";
        System.out.println(name + " : ");
        try {
            for (int x = 0; x < 10; x++) {
                String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
                System.out.write(data.getBytes());
                Thread.sleep(100);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}
