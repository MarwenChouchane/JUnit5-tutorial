package junit5Test;

import org.junit.jupiter.params.provider.*;

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

    @org.junit.jupiter.params.ParameterizedTest (name = "Run : {index} - value = {arguments}")
    @CsvSource (value = {"Steve,Roger" , "Captain,Marvel" , "Bucky,Barnes"})
    void csvSource_StringString(String param1 , String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @org.junit.jupiter.params.ParameterizedTest (name = "Run : {index} - value = {arguments}")
    @CsvSource(value = {"Steve,32,true", "Captain,55,false","Bucky,5,true"})
    void csvSource_StringIntBoolean(String param1 , int param2 , boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
    @org.junit.jupiter.params.ParameterizedTest (name = "Run : {index} - value = {arguments}")
    @CsvSource(value = {"Captain America , 'Steve,Roger'", "Winter soldier ,'Bucky,Barnes'"})
    void csvSource_StringWithComa(String param1 , String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


}
