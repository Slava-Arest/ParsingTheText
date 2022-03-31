package epam.jwd2022.parsingTheText.writer;

import epam.jwd2022.parsingTheText.reader.TextReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextWriter {

    TextReader textReader = new TextReader();

    public List<String> textWrite() throws IOException {
        String line = "";
        List<String> textList = new ArrayList<>();
        while ((line = textReader.readText()) != null) {
            textList.add(line);
            break;
        }
        return textList;
    }
}
