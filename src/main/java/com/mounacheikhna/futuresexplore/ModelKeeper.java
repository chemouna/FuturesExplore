package com.mounacheikhna.futuresexplore;

import java.util.Arrays;

// <=> BiboModel (specialy like BiboModel<Campaign>)
public class ModelKeeper {

    private DownloadedData downloadedData;

    ModelKeeper() {
        downloadedData = new DownloadedData(new MainModel(
                Arrays.asList(new MainElement("element1"), new MainElement("element2"))));
    }

    public void applyModel(ModelApplier<MainModel> modelApplier) {
        // this is slow too so let imitate that
        //Thread.sleep(10000);
        Misc.sleepWithProgress("Applying the model ");
        modelApplier.with(downloadedData.model);
    }

    class DownloadedData {
        MainModel model;

        public DownloadedData(MainModel m) {
            this.model = m;
        }
    }

}
