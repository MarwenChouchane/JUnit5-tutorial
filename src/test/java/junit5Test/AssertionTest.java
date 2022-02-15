package junit5Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AssertionTest {

    @Test
    void assertEqualsStringTest(){
        // Compare two string >< to assertNotEquals
        Assertions.assertEquals("FirstString","SecondString","The String value were not equals");
    }

    @Test
    void assertEqualsListTest(){
        //Compare two list
        List<String> expectedValue = Arrays.asList("First Value","Second Value","Third Value");
        List<String> actualValue = Arrays.asList("First Value","Second Value","Third Value");
        Assertions.assertEquals(expectedValue,actualValue, "The List value were not equals");
    }

    @Test
    void assertArraysEqualsTest(){
        int[] expectedValue = {1,2,3,4};
        int[] actualValue = {1,2,3,4};
        Assertions.assertArrayEquals(expectedValue,actualValue, "The List value were not equals");
    }

    @Test
    void assertTrueTest(){
        Assertions.assertTrue(6>5 , "This boolean condition did not evaluate to true");
    }

    @Test
    void assertFalseTest(){
        Assertions.assertFalse(5>6, "This boolean condition did not evaluate to false");
    }

    @Test
    void assertThrowTest(){
        //Vérifier si l'exception est existante
        Assertions.assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest(){
        Assertions.assertAll(
                ()-> Assertions.assertEquals("FirstString","SecondString","The String value were not equals"),
                ()-> Assertions.assertTrue(6>5 , "This boolean condition did not evaluate to true"),
                ()-> Assertions.assertFalse(9>6, "This boolean condition did not evaluate to false"));
    }
}
