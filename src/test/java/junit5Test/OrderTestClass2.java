package junit5Test;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Ordonner les methodes comme je veux
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTestClass2 {
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
    @Order(2)
    void firstMethode(){
        System.out.println("This is the first test methode");
    }

    @Test
    @Order(3)
    @DisplayName("UC50 - TC10 - This method is the second one")
    void secondMethode(){
        System.out.println("This is the second test methode");
    }

    @Test
    @Order(1)
    //@DisplayName("A Display name")
    void thirdMethode(){
        System.out.println("This is the third test methode");
    }
}
