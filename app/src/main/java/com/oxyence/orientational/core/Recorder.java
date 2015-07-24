package com.oxyence.orientational.core;

import java.util.Vector;

public class Recorder {

    private Vector<Sample> series;
    private boolean recording;

    Recorder () {
        series = new Vector<>();
        recording = false;
    }

    public void start() {
        recording = true;
    }

    public Vector getSeries() {
        return series;
    }

    public void onSample(Sample smpl) {
        series.add(smpl);
    }

    public boolean isRecording() {
        return recording;
    }
}
