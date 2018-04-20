package com.mounacheikhna.futuresexplore.supplier;

import com.google.common.base.Suppliers;

/**
 * Created by mounacheikhna on 20/04/2018.
 */

public class DependencyProvider {

    public DependencyProvider() {
    }

    public Dependency provideDependency() {
        return new Dependency("Test1");
    }

}
