package com.mounacheikhna.futuresexplore;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

// ToolbarCampaignIconProviderImpl
class Provider {

    private final ListeningExecutorService mExecutor;
    private Supplier<ModelKeeper> modelKeeperSupplier;
    //private MainModel mCurrentModel;

    public Provider(Supplier<ModelKeeper> modelKeeperSupplier) {
        this.modelKeeperSupplier = modelKeeperSupplier;
        mExecutor = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
    }

    public Thing getActiveThing() {
        ListenableFuture<ModelKeeper> future = mExecutor.submit(() -> modelKeeperSupplier.get());
        ListenableFuture<Thing> thingListenableFuture = Futures.transformAsync(future, new AsyncFunction<ModelKeeper, Thing>() {

            public MainModel mModel;

            @Override
            public ListenableFuture<Thing> apply(ModelKeeper modelKeeper) throws Exception {

                return mExecutor.submit(() -> {
                    modelKeeper.applyModel(model -> mModel = model);
                    return findActiveThing(mModel);
                });
            }
        }, mExecutor);

        /*
        ModelKeeper modelKeeper = modelKeeperSupplier.get();
        // what can we do ?
        modelKeeper.applyModel(new ModelApplier<MainModel>() {
            @Override
            public void with(MainModel model) {
                mModel = model;
            }
        });*/

        //return findActiveThing(mModel);

        try {
            return thingListenableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
        }

        // temp
        return null;
    }

    private Thing findActiveThing(MainModel model) {
        System.out.println("Start finding the active thing");
        String thingParam = "";
        List<MainElement> elements = model.getElements();
        for (MainElement element : elements) {
            thingParam += element.getName();
        }
        return new Thing(thingParam);
    }
}
