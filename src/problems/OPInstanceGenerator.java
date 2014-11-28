package problems;

import funct.MatrixGenerator;
import funct.WeightGenerator;



public class OPInstanceGenerator extends InstanceGenerator{

	int[] scores;
	int[][] distanceMatrix;
	
	public OPInstanceGenerator(int dimension, int maxTime){
		
		super(dimension, maxTime, "OP");
		
		MatrixGenerator matrixGen = new MatrixGenerator();
		WeightGenerator weightGen = new WeightGenerator();
		
		this.distanceMatrix = matrixGen.generateSymmetricMatrix(this.dimension);
		this.scores = weightGen.generateRandomWeightedArray(this.dimension);
		
	}
	
	protected String stringfy(){
	
		//n
		String nString = "n="+this.dimension+";\n";
		
		//tMax
		String tMaxString = "tMax="+this.maxTime+";\n";
		
		//Score
		String scoreString = "score=\n";
		scoreString += "[\n";
		for(int i = 0; i<this.scores.length; i ++){
			scoreString += scores[i]+",\n";
		}
		scoreString += "];\n";

		//timeDist
		String timeDistString = "timeDist=\n";
		timeDistString += "[\n";


		for(int row = 0; row<this.distanceMatrix.length; row ++){
			timeDistString += "[ ";
			
			for(int column = 0; column<this.distanceMatrix.length; column ++){
				
				timeDistString += this.distanceMatrix[row][column];
				
				if(column != this.distanceMatrix.length-1) timeDistString += ", ";
				
			}
			
			timeDistString += "],\n";
			
		}
		
		timeDistString += "];\n";
		
		System.out.println(nString + tMaxString + scoreString + timeDistString);
	
	return nString + tMaxString + scoreString + timeDistString;
	
	}

}




