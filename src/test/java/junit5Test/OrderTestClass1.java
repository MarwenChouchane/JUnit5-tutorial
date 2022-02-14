package junit5Test;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.MethodName.class) // Play the methode in the alphabet order (methode call)
@TestMethodOrder(MethodOrderer.DisplayName.class) // Play the methode in the alphabet order (methode display name)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTestClass1 {
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
    void firstMethode(){
        System.out.println("This is the first test methode");
    }

    @Test
    @DisplayName("UC50 - TC10 - This method is the second one") //Créee un nom à la test case
    void secondMethode(){
        System.out.println("This is the second test methode");
    }

    @Test
    @DisplayName("A Display name")
    void thirdMethode(){
        System.out.println("This is the third test methode");
    }
}
