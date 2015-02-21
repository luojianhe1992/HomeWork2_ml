
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
import java.util.Map;

public class question2 {
	public static void main(String [] args){
		
		/*
		File inputFile = new File(//
				processingText.class.getClassLoader().getResource("input.txt")
						.getPath());
		*/
		
		File inputFile = new File(args[0]);
		
		
		BufferedReader br = null;
		
		Map<String, Integer> countingMap = new HashMap<String, Integer>();
		
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

			//read the line one by one
			while ((line = br.readLine()) != null) {
				
				//split
				String[] split = line.toLowerCase().split(" ");

				for (String str : split) {
					
					if (countingMap.containsKey(str)) {
						countingMap.put(str, countingMap.get(str) + 1);
					} else {
						countingMap.put(str, 1);
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
		
		ArrayList<String> orderList = new ArrayList<String>();
		
		for(String str: countingMap.keySet()){
			orderList.add(str);
		}
		
		Comparator<String> comparatorByString = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		
		
		Collections.sort(orderList, comparatorByString);
		
		StringBuilder sb = new StringBuilder();
		
		for(String str:orderList){
			sb.append(str).append(":").append(countingMap.get(str)).append(",");
		}
		
		sb.deleteCharAt(sb.length() - 1);
		
		System.out.print(sb.toString());
	}
}
