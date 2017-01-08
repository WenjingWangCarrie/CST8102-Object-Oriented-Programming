import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;

public class Reverser {
	public static void main(String[] args) {

		ArrayList<String> words = new ArrayList<String>();
		Scanner sc = null;
		Formatter format = null;

		try {
			FileReader read = new FileReader("C:\\home\\Algonquin College\\Java_Code\\Level2_Lab8\\wordlist.txt");
			sc = new Scanner(read);

			while (sc.hasNext())
				words.add(sc.next());

			read.read();

			System.out.println("Reading in data");
			System.out.println("Loaded " + words.size() + " words from file");

			System.out.println("Reversing word list");
			System.out.println("Writing word list");

			System.out.println("wordlist.txt:");
			for (String list : words) {
				System.out.println(list);
			}
			sc.close();

			FileWriter write = new FileWriter("C:\\home\\Algonquin College\\Java_Code\\Level2_Lab8\\reverse.txt");
			format = new Formatter(write);

			Collections.reverse(words);
			System.out.println("reverse.txt:");
			for (String list : words) {
				System.out.println(list);
				write.write(list + " \n");
			}

			format.flush();
			format.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}