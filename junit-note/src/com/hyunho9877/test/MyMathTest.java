package com.hyunho9877.test;

import com.hyunho9877.junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {

    private final MyMath myMath = new MyMath();

    @Test
    void calculateSum_ThreeMemberArray() {
        int[] numbers = {1, 2, 3};

        int result = myMath.calculateSum(numbers);

        assertEquals(6, result);
    }

    @Test
    void calculateSum_ZeroLengthArray() {
        int[] numbers = {};

        int result = myMath.calculateSum(numbers);

        assertEquals(0, result);
    }
}
