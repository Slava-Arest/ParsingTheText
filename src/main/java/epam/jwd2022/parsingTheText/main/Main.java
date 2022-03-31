package epam.jwd2022.parsingTheText.main;

import epam.jwd2022.parsingTheText.entity.TextPart;
import epam.jwd2022.parsingTheText.parser.ParagraphParser;
import epam.jwd2022.parsingTheText.parser.SentenceParser;
import epam.jwd2022.parsingTheText.parser.WordParser;
import epam.jwd2022.parsingTheText.reader.TextReader;
import epam.jwd2022.parsingTheText.special_task.TaskNine;
import epam.jwd2022.parsingTheText.special_task.TaskOne;
import epam.jwd2022.parsingTheText.special_task.TaskThree;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        TextReader textReader = new TextReader();
        TextPart wholeText = new TextPart();

        String taskText = textReader.readText();
        ParagraphParser paragraphParser = new ParagraphParser();
        TextPart wholeParagraph = paragraphParser.parseToParagraph(wholeText, taskText);
        System.out.println(wholeParagraph);

        SentenceParser sentenceParser = new SentenceParser();
        TextPart wholeSentence = sentenceParser.parseToSentense(wholeText, taskText);
        System.out.println(wholeSentence);

        WordParser wordParser = new WordParser();
        TextPart wholeWord = wordParser.parseToWord(wholeText, taskText);
        System.out.println(wholeWord);

//        it's a task nine
        String s = "";
        String[] words = s.split(" ");
        Arrays.sort(words, new TaskNine.ByLetterMeetings('o'));
        for ( String w : words )
            System.out.println(w);

        TaskOne taskOne = new TaskOne();
        System.out.println(taskOne.task1());

        TaskThree taskThree = new TaskThree();
        System.out.println(taskThree.task3());
    }
}
