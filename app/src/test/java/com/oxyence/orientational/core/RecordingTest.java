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
        assertTrue(vec.isEmpty());
    }

    @Test
    public void getOneSample() {
        Sample smpl = new Sample(1,2,3);
        rec.onSample(smpl);
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
}

