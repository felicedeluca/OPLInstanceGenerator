package funct;

public class WeightGenerator {
	
	public int[] generateRandomWeightedArray(int dimension){
		
		int [] weightedArray = new int[dimension];
		
		for (int i = 0; i<dimension; i++){
			
			int weight = (int) (Math.random() * (10-1));
			
			weightedArray[i] = weight;
			
		}
		
		return weightedArray;
		
	}

}
