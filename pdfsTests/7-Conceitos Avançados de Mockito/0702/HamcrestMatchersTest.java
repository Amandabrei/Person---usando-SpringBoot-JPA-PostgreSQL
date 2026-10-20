package br.com.erudio.mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Test Hamcrest Matchers")
    @Test
    void testHamcrestMatchers() {
        // Given / Arrange
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);
        
        // When / Act & Then / Assert
        assertThat(scores, hasSize(4));
        // assertThat(scores, hasItems(23, 99, 100));
        assertThat(scores, hasItems(99, 100));
        assertThat(scores, everyItem(greaterThan(90)));
        
        // Check Strings
        assertThat("", is(emptyString()));
        assertThat(null, is(emptyOrNullString()));
        
        // Arrays
        Integer[] myArray = {1, 2, 3};
        
        assertThat(myArray, arrayWithSize(3));
        assertThat(myArray, arrayContaining(1, 2, 3));
        assertThat(myArray, arrayContainingInAnyOrder(3, 2, 1));
    }
}
