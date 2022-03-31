package epam.jwd2022.parsingTheText.reader;

import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    public String readText() throws IOException {
        try(FileReader reader = new FileReader("\\D:task_text_1.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return "";
    }
}
