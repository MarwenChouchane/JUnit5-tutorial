package junit5Test;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {

    @RepeatedTest(5)
    void firstRepeatedMethode(){
        System.out.println("We are repeating this test for the first time!!");
    }
    @RepeatedTest(value = 3, name = "Running repetitions : {currentRepetition}." + "Total is : {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    void secondRepeatedMethode(){
        System.out.println("We are repeating this test for the second time!!");
    }

    @RepeatedTest(3)
    void thirdRepeatedMethode(RepetitionInfo repetitionInfo){
        System.out.println("This code will run at each repetition");
        int numberOfRepetition = repetitionInfo.getCurrentRepetition();
        Assumptions.assumingThat(numberOfRepetition == 3,
                ()-> System.out.println("This code only run for repetition " + "3"));
    }
}
