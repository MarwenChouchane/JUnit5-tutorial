package junit5Test;

import org.junit.jupiter.api.*;

public class MiscTest {

    @Test
    @Timeout(5)
    void timeOut () throws InterruptedException {
        System.out.println("This is the test with the timeout");
        Thread.sleep(6000);
    }

    @Test
    @Timeout(90)
    @DisplayName("This is the nice methode")
    @Tag("theTag")
    void annotatedMethode1(){
        System.out.println("The is the annotated methode");
    }

    @MyAnnotation  // Voir l'interface crée sous le nom "MyAnnotation"
    void annotatedMethode2(){
        System.out.println("The is the custom annotated methode");
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class nestedTest{
        @BeforeAll
        void beforeAll(){
            System.out.println("Before all in nested test");
        }
        @Test
        void nestedTest(){
            System.out.println("This is the nestedtest methode");
        }
    }
}
