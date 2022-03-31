package epam.jwd2022.parsingTheText.entity;

public interface TextElement {

    void addElement(TextElement addTextElement);

    void removeElement(TextElement removeTextElement);

    TextElement getElement(int index);

    public void parse();
}
