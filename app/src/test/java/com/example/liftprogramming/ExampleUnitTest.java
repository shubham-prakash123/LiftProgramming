package com.example.liftprogramming;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void sequence_isCorrectFirstCase() {

        // Button Press Order  4 ⬇ , 3⬆  , 2 ⬇

        List<String> floorSequence = new ArrayList<>();
        floorSequence.add("4");
        floorSequence.add("3");
        floorSequence.add("2");

        List<String> directionSequence = new ArrayList<>();
        directionSequence.add("DOWN");
        directionSequence.add("UP");
        directionSequence.add("DOWN");

        SequenceUnitTest sequenceUnitTest = new SequenceUnitTest();

        List<Integer> seq = sequenceUnitTest.getSequence(floorSequence,directionSequence);

        assertEquals(3, seq.get(0).intValue());
        assertEquals(4, seq.get(1).intValue());
        assertEquals(2, seq.get(2).intValue());
    }

    @Test
    public void sequence_isCorrectSecondCase() {

        // Button Press Order  2⬆ , 2⬇  , 5⬆ , 4⬇

        List<String> floorSequence = new ArrayList<>();
        floorSequence.add("2");
        floorSequence.add("2");
        floorSequence.add("5");
        floorSequence.add("4");

        List<String> directionSequence = new ArrayList<>();
        directionSequence.add("UP");
        directionSequence.add("DOWN");
        directionSequence.add("UP");
        directionSequence.add("DOWN");

        SequenceUnitTest sequenceUnitTest = new SequenceUnitTest();

        List<Integer> seq = sequenceUnitTest.getSequence(floorSequence,directionSequence);

        assertEquals(2, seq.get(0).intValue());
        assertEquals(5, seq.get(1).intValue());
        assertEquals(4, seq.get(2).intValue());
        assertEquals(2, seq.get(3).intValue());
    }

    @Test
    public void sequence_isCorrectThirdCase() {

        // Button Press Order  3⬆ , 2⬇  , 5⬆ , 6⬆

        List<String> floorSequence = new ArrayList<>();
        floorSequence.add("3");
        floorSequence.add("2");
        floorSequence.add("5");
        floorSequence.add("6");

        List<String> directionSequence = new ArrayList<>();
        directionSequence.add("UP");
        directionSequence.add("DOWN");
        directionSequence.add("UP");
        directionSequence.add("UP");

        SequenceUnitTest sequenceUnitTest = new SequenceUnitTest();

        List<Integer> seq = sequenceUnitTest.getSequence(floorSequence,directionSequence);

        assertEquals(3, seq.get(0).intValue());
        assertEquals(5, seq.get(1).intValue());
        assertEquals(6, seq.get(2).intValue());
        assertEquals(2, seq.get(3).intValue());
    }

    @Test
    public void sequence_isCorrectFourCase() {

        // Button Press Order  3⬆ , 2⬆  , 5⬆ , 6⬆ , 1⬇, 4⬇

        List<String> floorSequence = new ArrayList<>();
        floorSequence.add("3");
        floorSequence.add("2");
        floorSequence.add("5");
        floorSequence.add("6");
        floorSequence.add("1");
        floorSequence.add("4");

        List<String> directionSequence = new ArrayList<>();
        directionSequence.add("UP");
        directionSequence.add("UP");
        directionSequence.add("UP");
        directionSequence.add("UP");
        directionSequence.add("DOWN");
        directionSequence.add("DOWN");

        SequenceUnitTest sequenceUnitTest = new SequenceUnitTest();

        List<Integer> seq = sequenceUnitTest.getSequence(floorSequence,directionSequence);

        assertEquals(2, seq.get(0).intValue());
        assertEquals(3, seq.get(1).intValue());
        assertEquals(5, seq.get(2).intValue());
        assertEquals(6, seq.get(3).intValue());
        assertEquals(4, seq.get(4).intValue());
        assertEquals(1, seq.get(5).intValue());
    }
}