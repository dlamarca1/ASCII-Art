import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class AscArtIIReader {

    static final char FIRST_CHAR = 'a';
    static final char LAST_CHAR = 'z';
    static final char QU_MARK = LAST_CHAR + 1;

    public static void printChar(int line, char character, String[] wholeAlphabet, int width) {
        int begin = (character - FIRST_CHAR) * width;
        int end = begin + width;
        System.out.print(wholeAlphabet[line].substring(begin, end));
    }

    private static FileReader getSource(String s) throws FileNotFoundException {
        return new FileReader(s);
    }

    public static void main(String[] args) throws FileNotFoundException { //more files can be read by modifying x to the new amount of files being read in: Scanner[x]
        Scanner[] sc = new Scanner[2];
        sc[0] = new Scanner(getSource("src\\main\\java\\ASCIIArt1.txt"));
        sc[1] = new Scanner(getSource("src\\main\\java\\ASCIIArt2.txt"));
        //if you want to read more files at the same time, please create an instance of sc[] for each file

        for (int n = 0; n < 2; n++) { //where 2 is the number of input files, if more files are being read please change 2 to the current amount of files being read

            //System.out.println("\n" + "ASCII Art from file: " + (n+1) + "\n"); //informs the user from which file the AscII Art is coming from

            //width and height of one ASCII-art character
            int width = sc[n].nextInt();
            int height = sc[n].nextInt();

            //text to convert
            sc[n].nextLine();
            String text = sc[n].nextLine().toLowerCase();

            //whole alphabet + ? in ASCII Art
            String[] rows = new String[height];
            for (int i = 0; i < height; i++)
                rows[i] = sc[n].nextLine();

            //prints the result line by line and character
            for (int l = 0; l < height; l++) {
                for (char c : text.toCharArray())
                    if (FIRST_CHAR <= c && c <= LAST_CHAR)
                        printChar(l, c, rows, width);
                    else
                        printChar(l, QU_MARK, rows, width);
                System.out.print("\n");
            }
        }
    }
}