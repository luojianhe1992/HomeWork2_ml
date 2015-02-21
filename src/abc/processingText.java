package abc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class processingText {

	
	//initialize the inputFile
	static File inputFile = null;
	
	public static void main(String[] args) {

		inputFile = new File(//
				processingText.class.getClassLoader().getResource("/input.txt").getPath());
		// initialize the stop word set
		Set<String> stopWordsSet = initialStopwords();
		
		System.out.println(stopWordsSet);

		System.out.println(inputFile.getAbsolutePath());
		
		
		readCountRemove(stopWordsSet);

		
	}

	//initialize the stop words set
	public static Set<String> initialStopwords() {

		//use HashSet to store the stopWordArray
		Set<String> stopWordsSet = new HashSet<String>();

		//the default stopWordsArray
		String[] stopWordsArray = new String[] { "as", "the", "in", "over","on" };

		
		// adding the stop words to the hashset
		for (String stopWord : stopWordsArray) {
			stopWordsSet.add(stopWord);
		}

		return stopWordsSet;

	}

	//the whole process
	public static Map<String, Integer> readCountRemove(Set<String> stopWordsSet) {

		//use map
		final Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

		//use bufferedreader to read the file
		BufferedReader br = null;

		//read the file
		try {
			// use bufferedreader to read the file
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					inputFile), "utf8"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String line = null;

		try {

			while ((line = br.readLine()) != null) {
				
				//split
				String[] split = line.toLowerCase().split(" ");

				for (String str : split) {
					if (stopWordsSet.contains(str)) {
						continue;
					}

					// counting the frequency
					if (wordCountMap.containsKey(str)) {
						wordCountMap.put(str, wordCountMap.get(str) + 1);
					} else {
						wordCountMap.put(str, 1);
					}
				}

			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		//close the bufferedreader
		try {
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> wordList = new ArrayList<String>();
		wordList.addAll(wordCountMap.keySet());
		Collections.sort(wordList,
				Collections.reverseOrder(new Comparator<String>() {

					@Override
					public int compare(String arg0, String arg1) {
						// TODO Auto-generated method stub

						int result;

						//order according to the character
						result = arg1.compareTo(arg0);
						
						return result;
					}

				}));
		
		
		//use stringbuilder to print out the result
		StringBuilder sb = new StringBuilder();
		
		for(String str:wordList){
			sb.append(str).append(":").append(wordCountMap.get(str)).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
		
		
		return wordCountMap;

	}
	
	
	

}
