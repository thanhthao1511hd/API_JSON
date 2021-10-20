package com.example.api_json.model;

import com.google.gson.annotations.SerializedName;

public class Quotes {
    @SerializedName("USDVND")
    private  float usaVnd;

    public Quotes(float usaVnd) {
        this.usaVnd = usaVnd;
    }

    public float getUsaVnd() {
        return usaVnd;
    }

    public void setUsaVnd(float usaVnd) {
        this.usaVnd = usaVnd;
    }
}
