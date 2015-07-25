package com.oxyence.orientational.core;

import java.util.Vector;

public class Recorder {

    private Vector<Sample> series;
    private Vector<Vector<Sample>>seriesVec;
    private boolean recording;
    int lastId;

    Recorder () {
        seriesVec = new Vector<>();

        recording = false;
        lastId = 0;
    }

    public void stop() {
        recording = false;
        seriesVec.add(series);
    }

    public int start() {
        recording = true;
        series = new Vector<>();
        return lastId++;
    }

    public Vector getSeries() {
        if (!isRecording())
            return series;
        else
            return null;
    }

    public Vector getSeries(int id) {
        if (!isRecording())
            return seriesVec.get(id);
        else
            throw null;
    }

    public void onSample(Sample smpl) {
        series.add(smpl);
    }

    public boolean isRecording() {
        return recording;
    }
}
