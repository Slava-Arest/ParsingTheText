package epam.jwd2022.parsingTheText.entity;

public class LeafTextPart implements TextElement{

    private String str;

    public LeafTextPart(String str) {
        this.str = str;
    }

    @Override
    public void addElement(TextElement addTextElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(TextElement removeTextElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextElement getElement(int index) {
        return this;
    }

    @Override
    public void parse() {

    }
}
