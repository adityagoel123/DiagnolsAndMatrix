package com.aditya.mlabs.matrix;
 
/*
 Input:
   {1,  2,  3,  4},
   {5,  6,  7,  8},
   {9,  10, 11, 12},
   {13, 14, 15, 16},
   {17, 18, 19, 20},
    
Output:
   1
   5   2
   9   6   3
   13  10  7  4 
   17  14  11 8
   18  15  12
   19  16
   20  
 */
 
public class JustPrintMatrixDiagonally {
 
 public static void main(String[] args) {
	 printMatrixDiagonally();
 }
 
 public JustPrintMatrixDiagonally() {
  int[][] matrix = {
   {1,  2,  3,  4},
   {5,  6,  7,  8},
   {9,  10, 11, 12},
   {13, 14, 15, 16},
   {17, 18, 19, 20}
  };
   
  
 }
 
	 public static void printMatrixDiagonally(){
	   
	  int rowCount = 9;
	  int columnCount = 9;
	  
	  for (int r = 1; r <= rowCount; r++) {
		  for (int row = r, col = 1; row >= 1 && col <= columnCount; row--, col++) {
			  System.out.print(row+":"+col + " "); 
		  }
		  System.out.println();
	  }
	   
	  for (int c = 2; c <= columnCount; c++) {
		  for (int row = rowCount, col = c; row >= 1 && col <= columnCount; row--, col++) {
			  System.out.print(row+":"+col + " "); 
		  }
		  System.out.println();
	  }

	  
	  for (int r = 1; r <= rowCount; r++) {
		  for (int row = r, col = columnCount; row >= 1 && col >= 1; row--, col--) {
			  System.out.print(row+":"+col + " "); 
		  }
		  System.out.println();
	  }
	   
	  for (int c = columnCount-1; c >=1 ; c--) {
		  for (int row = rowCount, col = c; row >= 1 && col >= 1; row--, col--) {
			  System.out.print(row+":"+col + " "); 
		  }
		  System.out.println();
	  }
	}
  
}