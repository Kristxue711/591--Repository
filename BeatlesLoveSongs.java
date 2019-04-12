import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BeatlesLoveSongs {

	ArrayList<String> songTitleList = new ArrayList<String>();

	private String test2FindSubstringBewteenFirstTwoLocations(String s, String c) {
		int index1 = s.indexOf(c);
		String remainString = s.substring(index1 + 1);
		if (remainString.indexOf(c) == -1){
			return null;
		}
		else{
			return remainString.substring(0, remainString.indexOf(c));
		}
	}

	public BeatlesLoveSongs(String songTitleName) {
		File f = new File(songTitleName);
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String row = s.nextLine();

				String songTitle = findSubstringBewteenFirstTwoLocations(row, "\"\"\"");
				if(songTitle != null){
					songTitleList.add(songTitle);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean contains(String keyword, String[] array){
		for(int i = 0; i < array.length; i++){
			if(array[i].equalsIgnoreCase(keyword)){
				return true;
			}
		}return false;
	}

	public static void main(String[] args) {
		BeatlesLoveSongs bs = new BeatlesLoveSongs("beatles.csv");
		int count = 0;
		int sum = 0;
		for(String songTitles: bs.songTitleList){
			if(bs.contains("love", songTitles.split(" "))){
				count++;
				
			}
			sum++;
		}
		System.out.println(count);
		System.out.println(sum);
		System.out.println("The percentage of Beatles songs that have the word \"love\" is " + ((double)count/sum)*100 + "%");
		
		
		
		
	}

}
