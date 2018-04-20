package com.mounacheikhna.futuresexplore;

import java.util.List;

// <=> CampaignDataModel
public class MainModel {

    private List<MainElement> elements;

    public MainModel(List<MainElement> elements) {
        this.elements = elements;
    }

    public List<MainElement> getElements() {
        return elements;
    }
}
