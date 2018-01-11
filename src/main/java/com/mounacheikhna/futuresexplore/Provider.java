package com.mounacheikhna.futuresexplore;

import com.google.common.base.Supplier;

import java.util.List;

class Provider {

    private Supplier<ModelKeeper> modelKeeperSupplier;
    private MainModel mModel;

    public Provider(Supplier<ModelKeeper> modelKeeperSupplier) {
        this.modelKeeperSupplier = modelKeeperSupplier;
    }

    public Thing getActiveThing() {
        ModelKeeper modelKeeper = modelKeeperSupplier.get();
        modelKeeper.applyModel(new ModelApplier<MainModel>() {
            @Override
            public void with(MainModel model) {
                mModel = model;
            }
        });

        return findActiveThing();
    }

    private Thing findActiveThing() {
        String thingParam = "";
        List<MainElement> elements = mModel.getElements();
        for (MainElement element : elements) {
            thingParam += element.getName();
        }
        return new Thing(thingParam);
    }
}
