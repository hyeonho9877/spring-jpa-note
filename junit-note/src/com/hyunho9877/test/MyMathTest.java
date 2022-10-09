package com.hyunho9877.test;

import com.hyunho9877.junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {

    @Test
    void test() {
        int[] numbers = {1, 2, 3};

        MyMath myMath = new MyMath();
        int result = myMath.calculateSum(numbers);

        assertEquals(6, result);
    }
}
