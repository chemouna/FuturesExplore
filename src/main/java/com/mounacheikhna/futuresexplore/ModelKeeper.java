package com.mounacheikhna.futuresexplore;

public class ModelKeeper {

    private DownloadedData downloadedData;

    ModelKeeper() {
        downloadedData = new DownloadedData(new MainModel());
    }

    public void applyModel(ModelApplier<MainModel> modelApplier) {
        modelApplier.with(downloadedData.model);
    }

    class DownloadedData {
        MainModel model;

        public DownloadedData(MainModel m) {
            this.model = m;
        }
    }

}
