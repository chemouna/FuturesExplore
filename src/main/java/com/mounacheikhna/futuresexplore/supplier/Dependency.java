package com.mounacheikhna.futuresexplore.supplier;

/**
 * Created by mounacheikhna on 20/04/2018.
 */

public class Dependency {

    private String mName;

    public Dependency(final String name) {
        mName = name;
    }

    public void print() {
        System.out.println(mName);
    }
}
