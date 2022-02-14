package junit5Test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TagsTestClass {
/*
accessModifier returnType nameOfMethode(params)  :
accessModifier : private is not allowed in test and the access isn't obligatory
returnType : void for all test
*/
    @BeforeAll
    void beforeAll(){
        System.out.println("--This is the before all methode");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("----This is the before each methode");
    }

    @AfterAll
    void afterAll(){
        System.out.println("--This is the after all methode");
    }

    @AfterEach
    void afterEach(){
        System.out.println("----This is the after each methode");
    }

    @Test
    @Tag("sanity") //alphanumerique string : we could use  it later like a filter
    void firstMethode(){
        System.out.println("This is the first test methode");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("UC50 - TC10 - This method is the second one")
    void secondMethode(){
        System.out.println("This is the second test methode");
    }

    @Test
    @Tag("acceptance")
    void thirdMethode(){
        System.out.println("This is the third test methode");
    }

    @Tag("acceptance")
    @org.junit.jupiter.params.ParameterizedTest(name = "Run : {index} - value = {arguments}")
    @ValueSource(ints = {1,6,11}) // on peut passer qu'une seul parametre (int)
    void intValue (int theParams){
        System.out.println("theParams = " + theParams);
    }
}
