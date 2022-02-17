package junit5Test;

import listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
public class DesablEnableTest {

    @Test
    @Disabled(value = "Disable for demo of @Disable") //Disable a test
    void firstTest(){
        System.out.println("This is the first test");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disable for demo of " +"@DisabledOnOs")
    void secondTest(){
        System.out.println("This is the second test");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "stagings", disabledReason = "Desabled for demo of @DisabledIfSystemProperty") //Voir configuration
    void thirdTest(){
        System.out.println("This is the third test");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Desabled for demo of @DisabledIf")
    void fourTest(){
        System.out.println("This is the four test");
    }
    @Test
    void fiveTest(){
        System.out.println("This is the five test");
    }

    boolean provider (){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

}
