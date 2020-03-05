package com.example.limitsservice;

public class LimitConfiguration {

    private int maximun;
    private int minimun;

    public LimitConfiguration() {
    }

    public LimitConfiguration(int maximun, int minimun) {
        this.maximun = maximun;
        this.minimun = minimun;
    }

    public int getMaximun() {
        return maximun;
    }

    public void setMaximun(int maximun) {
        this.maximun = maximun;
    }

    public int getMinimun() {
        return minimun;
    }

    public void setMinimun(int minimun) {
        this.minimun = minimun;
    }
}
