package com.crm.clinicCrm.files;

import java.util.UUID;

public class FileInfoModel {


    private UUID clientId;
    private String name;
    private String url;

    public FileInfoModel(String name, String url ) {
        this.name = name;
        this.url = url;
    }

    public FileInfoModel(String name, String url, UUID clientId ) {
        this.clientId = clientId;
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}

