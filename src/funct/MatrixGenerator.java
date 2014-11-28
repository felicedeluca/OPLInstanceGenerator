package funct;


public class MatrixGenerator {

	
	public int[][] generateSymmetricMatrix(int dimension){
		
		int[][] matrix = new int[dimension][dimension];
		
		for(int row = 0; row<dimension; row++){
			
			for(int column=row; column<dimension; column++){
				
				int value = (row==column)? Integer.MAX_VALUE : (int) (Math.random() * (100-1));
				
				matrix[row][column] = value;
				matrix[column][row] = value;
				
			}	
		}
		
		return matrix;
	}
	
}
