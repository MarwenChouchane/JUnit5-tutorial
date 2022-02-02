package junit5Test;

import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTest {

    @org.junit.jupiter.params.ParameterizedTest(name = "Run : {index} - value = {arguments}")
    @ValueSource(ints = {1,6,11}) // on peut passer qu'une seul parametre (int)
    void intValue (int theParams){
        System.out.println("theParams = " + theParams);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run : {index} - value = {arguments}")
    @NullAndEmptySource  //Doesn't work with int, float and booleen
    @ValueSource(strings = {"FirstString","SecondString"})
    void stringValue(String theParam){
        System.out.println("theParam = " + theParam);
    }

}
