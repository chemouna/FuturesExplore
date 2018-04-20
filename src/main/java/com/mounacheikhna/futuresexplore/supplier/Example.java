package com.mounacheikhna.futuresexplore.supplier;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 * Created by mounacheikhna on 20/04/2018.
 */

public class Example {

    private final Supplier<Dependency> mDependencySupplier;

    public Example(DependencyProvider provider) {
        mDependencySupplier = Suppliers.memoize(() -> provider.provideDependency());
    }

    public void printDependency() {
        mDependencySupplier.get().print();
    }
}
