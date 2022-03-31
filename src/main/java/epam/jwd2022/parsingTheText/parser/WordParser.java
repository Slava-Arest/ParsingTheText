package epam.jwd2022.parsingTheText.parser;

import epam.jwd2022.parsingTheText.entity.LeafTextPart;
import epam.jwd2022.parsingTheText.entity.TextPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";

    public TextPart parseToWord(TextPart wordList, String word) {
        // parse to word
        Pattern pattern = Pattern.compile(REGEX_WORD);
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            word = matcher.group();
            wordList = new TextPart();
            // System.out.print(symbol);
        }
        return wordList;
    }
}
