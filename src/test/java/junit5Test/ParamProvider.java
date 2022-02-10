package junit5Test;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParamProvider {

    static Stream<Arguments> sourceStream_StringDouble(){
        return Stream.of(Arguments.arguments("Fraise",16), Arguments.arguments("banana",50.5), Arguments.arguments("poivron", 1.3
        ));
    }
}
