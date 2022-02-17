package junit5Test;

import listeners.Listener;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(Listener.class)
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
        List<String> expectedValue = Arrays.asList("First Value","Second Value","Third Value");
        List<String> actualValue = Arrays.asList("First Value","Second Value","Third Value");
        Assertions.assertAll(
                ()-> Assertions.assertEquals("FirstString","SecondString","The String value were not equals"),
                ()-> Assertions.assertTrue(6>5 , "This boolean condition did not evaluate to true"),
                ()-> Assertions.assertFalse(9>6, "This boolean condition did not evaluate to false"),
                ()-> Assertions.assertEquals(expectedValue,actualValue, "The List value were not equals"));
    }


     /********junit + hamcrest**********/

     @Test
    void assertForMapTest(){
         Map<String, Integer> theMap = new HashMap<>();
         theMap.put("FirstKey", 1);
         theMap.put("SecondKey", 2);
         theMap.put("ThirdKey", 3);
         assertThat(theMap, Matchers.hasKey("SecondKey"));
         assertThat(theMap, Matchers.hasValue(2));
     }

    @Test
    void assertForList(){
        //check if the element is in the list or not
        List<String> theList = Arrays.asList("First Value","Second Value","Third Value");
        assertThat(theList, Matchers.hasItem("First Value"));
    }

    @Test
    void assertForAnyOf(){
        List<String> theList = Arrays.asList("First Value","Second Value","Third Value");
        assertThat(theList, Matchers.anyOf(Matchers.hasItem("First Value"), Matchers.hasItem("String")));
    }

    @Test
    void assertForAllOf(){
        List<String> theList = Arrays.asList("First Value","Second Value","Third Value");
        assertThat(theList, Matchers.allOf(Matchers.hasItem("First Value"), Matchers.hasItem("String")));
    }

    @Test
    void assertForContainAnyOrder(){
        List<String> theList = Arrays.asList("First Value","Second Value","Third Value");
        assertThat(theList, Matchers.containsInAnyOrder("First Value","Second Value","Third Value"));
    }
}
