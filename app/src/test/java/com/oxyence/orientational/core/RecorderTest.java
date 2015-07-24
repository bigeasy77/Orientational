package com.oxyence.orientational.core;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Vector;
import java.util.regex.Pattern;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecorderTest extends TestCase {

    private Recorder rec;

    @Override
    protected void setUp() {
        rec = new Recorder();
    }

    protected void tearDown() {
    }

    @Test
    public void testStartRecording() {
        rec.start();
    }

    @Test
    public void testGetEmptySeries() {
        Vector vec = rec.getSeries();
        assertTrue(vec.isEmpty());
    }

    @Test
    public void testSensorChanged() {

    }

}

