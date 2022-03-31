package epam.jwd2022.parsingTheText.special_task;

import epam.jwd2022.parsingTheText.reader.TextReader;
import epam.jwd2022.parsingTheText.writer.TextWriter;

import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author - Viachaslau Arestau
 * task description: Find a word in the first sentence that is not in any of the other sentences.**/

public class TaskThree {

    TextWriter textWriter = new TextWriter();
    TextReader textReader = new TextReader();

    public String task3() throws IOException {
        String line1 = textReader.readText();
        Function<String, Predicate<String>> function2 = f -> p -> !f.contains(p);
        Function<String, Stream<String>> mapper = s -> Stream.of(s.split(" "));
        textWriter.textWrite().stream()
                .flatMap(mapper)
                .filter(function2.apply(line1))
                .forEach(System.out::println);
        System.out.println("_______and_in_the_other_way!_________________________");
        Function<String[], Predicate<String>> function = f ->
                p -> !Stream.of(f)
                        .collect(Collectors.joining(" ")).contains(p);
        Stream.of(line1.split(" "))
                .filter(function.apply(textWriter.textWrite().toArray(new String[0])))
                .forEach(System.out::println);
        return line1;
    }

}
