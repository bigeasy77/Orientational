package com.oxyence.orientational.core;

import junit.framework.TestCase;
import java.util.Vector;

/**
 * Created by amw044 on 7/2/2015.
 */
public class RecorderTest extends TestCase {

    private Recorder rec;

    protected void setUp() {
        rec = new Recorder();
    }

    protected void tearDown() {
    }

    public void testStartRecording() {
        rec.start();
    }

    public void testGetEmptySeries() {
        Vector vec = rec.getSeries();
        assertTrue(vec.isEmpty());
    }

    public void testSensorChanged() {

    }
}