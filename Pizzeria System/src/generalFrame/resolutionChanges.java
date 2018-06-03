package generalFrame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class resolutionChanges {
	public static void changes(){
//		File folder = new File("/images/generalButtons/");
//		File[] listOfFiles = folder.listFiles();
//		    for (int i = 0; i < listOfFiles.length; i++) {
//		      if (listOfFiles[i].isFile()) {
//		        System.out.println("File " + listOfFiles[i].getName());
//		      } else if (listOfFiles[i].isDirectory()) {
//		        System.out.println("Directory " + listOfFiles[i].getName());
//		      }
//		    }
		List<String> results = new ArrayList<String>();


		File[] files = new File("images/generalButtons").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 

		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
	}
}
