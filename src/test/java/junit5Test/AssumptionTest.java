package junit5Test;

import listeners.Listener;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(Listener.class)
public class AssumptionTest {

    @org.junit.jupiter.params.ParameterizedTest(name = "Run : {index} - value = {arguments}")
    @ValueSource(ints = {1,6,11}) // on peut passer qu'une seul parametre (int)
    void intValue (int theParams){
        Assumptions.assumeTrue(theParams > 5); //Si la parametre est superieur à 5 le test passe si non le test skipped
        System.out.println("theParams = " + theParams);
    }

    @org.junit.jupiter.params.ParameterizedTest (name = "Run : {index} - value = {arguments}")
    @CsvSource(value = {"Steve,Roger" , "Captain,Marvel" , "Bucky,Barnes"}) //on peut passer plus qu'une seul parametre
    void csvSource_StringString(String param1 , String param2){
        Assumptions.assumeFalse(param1.equals("Steve"), "The assumption failed for the following params2 : "+param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @org.junit.jupiter.params.ParameterizedTest (name = "Run : {index} - value = {arguments}")
    @CsvSource(value = {"Steve,32,true", "Captain,55,false","Bucky,5,true"})
    void csvSource_StringIntBoolean(String param1 , int param2 , boolean param3){
        Assumptions.assumingThat(param2 > 5, ()-> System.out.println("This code run")); //The assumption is independent = no test skipped
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

}
