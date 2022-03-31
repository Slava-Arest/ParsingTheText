package epam.jwd2022.parsingTheText.parser;

import epam.jwd2022.parsingTheText.entity.TextPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";

    WordParser wordParser = new WordParser();

    public TextPart parseToSentense(TextPart paragraphList, String paragraph) {
        // parse to sentence
        TextPart sentenceList = new TextPart();
        Pattern pattertSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher m2 = pattertSentence.matcher(paragraph);
        String sentence = "";
        while (m2.find()) {
            sentence = m2.group();
            sentenceList = wordParser.parseToWord(sentenceList, sentence);
            paragraphList.addElement(sentenceList);
        }
        return paragraphList;
    }
}
