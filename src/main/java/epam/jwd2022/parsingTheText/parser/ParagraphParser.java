package epam.jwd2022.parsingTheText.parser;

import epam.jwd2022.parsingTheText.entity.LeafTextPart;
import epam.jwd2022.parsingTheText.entity.TextPart;
import epam.jwd2022.parsingTheText.reader.TextReader;
import epam.jwd2022.parsingTheText.writer.TextWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser {

    private static final String REGEX_LISTING = "\\s*([^\\t]+[\n{]+[\n}])";
    private static final String REGEX_PARAGRAPH_WITH_LISTING = "(\\s*(\n.+))([^(\\s*([^\\t]+)\\s)])|\\s*([^\\t]+)";

    TextReader textReader = new TextReader();
    CodeBlockParser codeBlockParser = new CodeBlockParser();

    public TextPart parse(String path) throws IOException {
        String text = initialize(path);
        TextPart wholeText = new TextPart();
        parseToParagraph(wholeText, text);
        return wholeText;
    }

    public String initialize(String path) throws IOException {
        String taskText = textReader.readText();
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            taskText = new String(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskText;
    }

    public TextPart parseToParagraph(TextPart wholeText, String text) {
        TextPart paragraphList = new TextPart();
        Pattern pattertParagraph = Pattern
                .compile(REGEX_PARAGRAPH_WITH_LISTING);
        LeafTextPart paragraphLeaf = null;
        String paragraph = "";
        Matcher matcher = pattertParagraph.matcher(text);
        while (matcher.find()) {
            paragraph = matcher.group();
            if (Pattern.matches(REGEX_LISTING, paragraph)) {
                paragraphLeaf = new LeafTextPart(paragraph);
                System.out.print(paragraphLeaf);
                paragraphList.addElement(paragraphLeaf);
            } else {
                System.out.print(paragraph);
                paragraphList = codeBlockParser.parseToCodeBlock(paragraphList, paragraph);
            }
            wholeText.addElement(paragraphList);
        }

        return wholeText;
    }
}
