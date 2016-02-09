package com.pheonix.paymentTimingLogs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DirectoryToJson {
	
	public Directory convertDirToJsonFile(File file)
	{
		List<Directory> child_directories = new ArrayList<Directory>();
		Directory dir = new Directory();
		dir.setPath(file.getAbsolutePath());
		
		if(file.isDirectory())
		{
			File[] file_array = file.listFiles();
			if(file_array.length != 0)
			{
				for(File temp_file : file_array)
				{
					Directory temp_dir = convertDirToJsonFile(temp_file);
					child_directories.add(temp_dir);
				}
				dir.setNodes(child_directories);
			}
		}	
		return dir;
	}

	public void printDirectoryStructure(Directory my_dir, int level) {
		// TODO Auto-generated method stub
		System.out.println("Level: "+level+"Path: "+my_dir.getPath());
		
		if(my_dir.getNodes() != null)
		{
			for(Directory sub_dir : my_dir.getNodes())
			{
				printDirectoryStructure(sub_dir, level+1);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File root_dir = new File("/Users/shaileshpujari/paymentTimingLogs/20160212");
		DirectoryToJson djson = new DirectoryToJson();
		Directory my_dir = djson.convertDirToJsonFile(root_dir);
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		
		System.out.println(gson.toJson(my_dir));
		//djson.printDirectoryStructure(my_dir,0);

	}

}
