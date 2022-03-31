package epam.jwd2022.parsingTheText.special_task;

import epam.jwd2022.parsingTheText.writer.TextWriter;

import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author - Viachaslau Arestau
 * task description: Sort all the words of the text in ascending order of the number of the given letter in the word. Arrange words with the same number of letters in alphabetical order.**/

public class TaskNine {

    public static class ByLetterMeetings implements Comparator<String> {
        TextWriter textWriter = new TextWriter();

        public ByLetterMeetings(char o) {

        }

        int matchesCount(String a) throws IOException {
            int found = 0;

            String letter = "";
            for ( String c : textWriter.textWrite())
                if (Objects.equals(letter, c))
                    ++found;

            return found;
        }

        public int compare(String a, String b) {
            int diff = 0;
            try {
                diff = matchesCount(a) - matchesCount(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ( diff != 0 ) ? diff : a.compareTo(b);
        }
    }

//    public Comparator<? super String> comparator() {
//        return new Comparator<String>() {
//            String letter = "d";
//
//            int count(String s) throws IOException {
//                TextReader textReader = new TextReader();
//                int count = 0;
//                for (int i = 0; i < textReader.readText().length(); i++) {
//                    if (letter.indexOf(textReader.readText().charAt(i)) >= 0) {
//                        count++;
//                    }
//                }
//                return count;
//            }
//
//
//            public int compare(String s1, String s2) {
//                try {
//                    return count(s1) - count(s2);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return 0;
//            }
//        };
//    }
//
//    private static List<String> fillList(String[] args) {
//        return Arrays.asList("gfdd", "yytjkd", "qwddffd", "reyhf");
//    }
}
