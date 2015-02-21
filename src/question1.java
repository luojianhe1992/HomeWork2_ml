
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class question1 {
	public static void main(String [] args){
	
		/*
		
		File inputFile = new File(//
				processingText.class.getClassLoader().getResource("input.txt")
						.getPath());
		
		*/
		
		
		File inputFile = new File(args[0]);
		
//		File directory = inputFile.getParentFile().getAbsoluteFile();
//		File[] listFiles = directory.listFiles();
//		for(File f : listFiles) {
//			System.out.println(f.getAbsolutePath());
//		}
		
		BufferedReader br = null;
		
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
		
		
		HashSet<String> result = new HashSet<String>();
		
		try {

			//read the line one by one
			while ((line = br.readLine()) != null) {
				
				//split
				String[] split = line.toLowerCase().split(" ");

				for (String str : split) {
					
					//add the string to the stringbuilder
					result.add(str);
					
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
		
		ArrayList<String> resultByOrder = new ArrayList<String>();
		
		for(String str:result){
			resultByOrder.add(str);
		}
		
		Comparator<String> comparatorByString = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		
		Collections.sort(resultByOrder, comparatorByString);
		
		StringBuilder sb = new StringBuilder();
		
		for(String str:resultByOrder){
			sb.append(str).append(",");
		}
		
		sb.deleteCharAt(sb.length() - 1);
		
		System.out.print(sb.toString());
		
	}
}
