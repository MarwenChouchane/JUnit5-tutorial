package junit5Test;

import org.junit.jupiter.params.provider.*;

import java.util.List;

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

    @org.junit.jupiter.params.ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppingList.csv" , "src/test/resources/params/shoppingList2.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, Double price, int quantity, String unit, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppingList3.csv"}, numLinesToSkip = 1, delimiterString = "++")
    void csvFileSource_StringDoubleIntStringStringPersonelazedDelemiter(String name, Double price, int quantity, String unit, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodeSource_String(String param1){

    }

    List<String> sourceString{

    }

}
