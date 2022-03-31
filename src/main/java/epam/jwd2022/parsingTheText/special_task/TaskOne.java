package epam.jwd2022.parsingTheText.special_task;

import epam.jwd2022.parsingTheText.reader.TextReader;
import epam.jwd2022.parsingTheText.writer.TextWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author - Viachaslau Arestau
 * task description: Find the largest number of text sentences that have the same words.**/
public class TaskOne {

    TextWriter textWriter = new TextWriter();

    public List<String> task1() throws IOException {
        return
        textWriter.textWrite().stream()

                .map(line -> line.replaceAll("\\W+", " "))
                .sorted(Collections.reverseOrder(Comparator.comparingLong(x -> Arrays.stream(x.split(" "))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values()
                        .stream()
                        .max(Comparator.comparingLong(Long::longValue))
                        .get())))
                .collect(Collectors.toList());
    }
}
