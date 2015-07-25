package com.oxyence.orientational.core;

import org.junit.Before;
import org.junit.Test;

import java.util.Vector;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class RecordingTest {

    private Recorder rec;

    @Before
    public void setUp() {
        rec = new Recorder();
    }

    @Test
    public void getEmptySeries() {
        Vector vec = rec.getSeries();

        assertEquals(vec, null);
    }

    @Test
    public void getOneSampleInSeries() {
        rec.start();
        Sample smpl = new Sample(1,2,3);
        rec.onSample(smpl);
        rec.stop();
        Vector vec = rec.getSeries();

        assertEquals(vec.get(0), smpl);
        assertEquals(vec.size(), 1);
    }

    @Test
    public void isRecordingWhenStarted() {
        rec.start();

        assertTrue(rec.isRecording());
    }

    @Test
    public void isNotRecordingWhenStopped() {
        rec.start();
        rec.stop();

        assertFalse(rec.isRecording());
    }

    @Test
    public void getOneSeriesById() {
        int id = rec.start();
        Sample smpl = new Sample(1,2,3);
        rec.stop();
        rec.getSeries(id);
    }

    @Test
    public void createAndGetSecondSeriesById() {
        Sample smpl1 = new Sample(1,2,3);
        Sample smpl2 = new Sample(2,3,4);

        rec.start();
        rec.onSample(smpl1);
        rec.stop();
        int id = rec.start();
        rec.onSample(smpl2);
        rec.onSample(smpl1);
        rec.stop();
        Vector vec = rec.getSeries(id);

        assertEquals(vec.get(0), smpl2);
        assertEquals(vec.get(1), smpl1);
        assertEquals(vec.size(), 2);
    }
}

