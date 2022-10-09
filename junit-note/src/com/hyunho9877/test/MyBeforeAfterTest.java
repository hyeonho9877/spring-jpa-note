package com.hyunho9877.test;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("MyBeforeAfterTest.beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("MyBeforeAfterTest.afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("MyBeforeAfterTest.beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("MyBeforeAfterTest.afterEach");
    }

    @Test
    void test() {
        System.out.println("MyBeforeAfterTest.test");
    }

    @Test
    void test2() {
        System.out.println("MyBeforeAfterTest.test2");
    }

    @Test
    void test3() {
        System.out.println("MyBeforeAfterTest.test3");
    }
}
