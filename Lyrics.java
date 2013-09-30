import java.util.*;
import java.io.*;

public class Lyrics {
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> words = new ArrayList<String>();
		List<String> lyricsWords = new ArrayList<String>();
		
		String[] inputArray;
		
		int numWords = Integer.parseInt(reader.readLine());
		
		while(numWords-->0) {
			words.add(reader.readLine());
		}
		int numLyrics = Integer.parseInt(reader.readLine());
		while(numLyrics-->0) { 
			inputArray = reader.readLine().split("-");
			for(String lyricWord : inputArray) {
				lyricsWords.add(lyricWord);
			}
		}
	
		for(String word : words) {
			int count = 0;
			for (String lyricWord : lyricsWords) {
				if(lyricWord.contains(word)) {
					count++;
				}
			}
			System.out.println(count);
		}
		System.out.println(words);
		System.out.println(lyricsWords);
	}
}
