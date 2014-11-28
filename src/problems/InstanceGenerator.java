package problems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public abstract class InstanceGenerator {
	
	int dimension;
	int maxTime;
	String name;
	
	public InstanceGenerator(int dimension, int maxTime){
		
		this.dimension = dimension;
		this.maxTime = maxTime;
		this.name = "instance";
		
	}
	
	protected InstanceGenerator(int dimension, int maxTime, String name){
		
		this.dimension = dimension;
		this.maxTime = maxTime;
		this.name = name;
	}
	
	abstract protected String stringfy();
	
	public void printOnFile(String outputFile)
	{
	
		
		File instanceFile;

		try{
			instanceFile = new File(outputFile +this.name + ".dat");
			
			if(instanceFile.exists()) instanceFile.delete();
			instanceFile.getParentFile().mkdirs();
			instanceFile.createNewFile();
			
			String data = this.stringfy();
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(instanceFile.getName(), true)));
			out.println(data);
			out.close();

		}catch(Exception e){ e.printStackTrace();
		}

	}

}
