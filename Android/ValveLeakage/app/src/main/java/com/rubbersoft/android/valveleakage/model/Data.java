package com.rubbersoft.android.valveleakage.model;

import java.util.GregorianCalendar;

/**
 * Created by Faiz on 26/12/2015.
 */
public class Data {
    private long timestamp;
    private float temperature,LPGConcentration;

    Data(){}

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getLPGConcentration() {
        return LPGConcentration;
    }

    public void setLPGConcentration(float LPGConcentration) {
        this.LPGConcentration = LPGConcentration;
    }
}