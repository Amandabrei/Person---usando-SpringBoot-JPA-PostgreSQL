package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArraysCompareTest {

    @Test
    void test() {
        int[] numbers = {25,8,21,32,3};
        int[] expectedArray = {3,8,21,25,32};
        
        Arrays.sort(numbers);
        
        assertArrayEquals(numbers, expectedArray);
    }

}
