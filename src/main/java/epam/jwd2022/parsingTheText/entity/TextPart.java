package epam.jwd2022.parsingTheText.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextPart implements TextElement{
    private final List<TextElement> textElements = new ArrayList<TextElement>();

    @Override
    public void addElement(TextElement addTextElement) {
        textElements.add(addTextElement);
    }

    @Override
    public void removeElement(TextElement removeTextElement) {
        textElements.add(removeTextElement);
    }

    @Override
    public TextElement getElement(int index) {
        return textElements.get(index);
    }

    @Override
    public void parse() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextPart textPart = (TextPart) o;
        return Objects.equals(textElements, textPart.textElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textElements);
    }

    @Override
    public String toString() {
        return "TextPart{" +
                "textElements=" + textElements +
                '}';
    }
}
