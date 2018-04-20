package com.mounacheikhna.futuresexplore.supplier;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 * Created by mounacheikhna on 20/04/2018.
 */

public class Example {

    private final State mState;

    public Example(DependencyProvider provider) {
        mState = new State(Suppliers.memoize(() -> provider.provideDependency()));
    }

    public void printDependency() {
        mState.getDependency().print();
    }

    static class State {
        private Supplier<Dependency> mDependencySupplier;

        public State(Supplier<Dependency> mDependencySupplier) {
            this.mDependencySupplier = mDependencySupplier;
        }

        public Dependency getDependency() {
            return mDependencySupplier.get();
        }
    }
}
