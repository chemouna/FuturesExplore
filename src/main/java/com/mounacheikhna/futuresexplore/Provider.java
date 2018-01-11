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

        // what can we do ?
        modelKeeper.applyModel(new ModelApplier<MainModel>() {
            @Override
            public void with(MainModel model) {
                mModel = model;
            }
        });

        System.out.println("Done getting and applying the model");
        return findActiveThing();
    }

    private Thing findActiveThing() {
        System.out.println("Start finding the active thing");
        String thingParam = "";
        List<MainElement> elements = mModel.getElements();
        for (MainElement element : elements) {
            thingParam += element.getName();
        }
        return new Thing(thingParam);
    }
}
