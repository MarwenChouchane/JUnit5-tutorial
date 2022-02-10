package junit5Test;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

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
    @CsvSource (value = {"Steve,Roger" , "Captain,Marvel" , "Bucky,Barnes"}) //on peut passer plus qu'une seul parametre
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

    //on peut passer un fichier contenant les parametres
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
    @MethodSource(value = "sourceString") //on peut passer une methode contenant les paramet soit List soit Stream
    void methodeSource_String(String param1){
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString (){
        return Arrays.asList("Tomato", "Carrot", "Cabbage");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodesourceStringAsStream(String param1){
        System.out.println("param1 = " + param1);
    }

    Stream<String> sourceStringAsStream(){
        return Stream.of("Orange", "Pear", "Apple");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource(value = "sourceListe_StringDouble")
    void methodesourceListe_StringDouble(String param1 , double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<Arguments> sourceListe_StringDouble(){
        return Arrays.asList(Arguments.arguments("Tomato",4), Arguments.arguments("cabbage",5.5), Arguments.arguments("Carrot", 10.3
        ));
    }

    //Stream from another class
    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource(value = {"junit5Test.ParamProvider#sourceStream_StringDouble" , "sourceListe_StringDouble"})
    void methodesourceStream_StringDouble(String param1 , double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


}
