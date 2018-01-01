package com.aditya.mlabs.matrix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.math.*;

public class FindPairsOnSameDiagnolOfMatrix {
	
	 static List<List<String>> listOfListofCoordinatesOfEacDiag = new ArrayList<List<String>>();		 
	 public static void populateDiagnolsDataAttributes(){
		 int rowCount = 9;
		  int columnCount = 9;
		  
		  for (int r = 1; r <= rowCount; r++) {
			  List<String> listOfCoordinates = new ArrayList<String>();
			  for (int row = r, col = 1; row >= 1 && col <= columnCount; row--, col++) {
				  //System.out.print(row+":"+col + " ");
				  listOfCoordinates.add(row+":"+col);
			  }
			  listOfListofCoordinatesOfEacDiag.add(listOfCoordinates);
			  //System.out.println();
		  }
		   
		  for (int c = 2; c <= columnCount; c++) {
			  List<String> listOfCoordinates = new ArrayList<String>();
			  for (int row = rowCount, col = c; row >= 1 && col <= columnCount; row--, col++) {
				  //System.out.print(row+":"+col + " ");
				  listOfCoordinates.add(row+":"+col);
			  }
			  listOfListofCoordinatesOfEacDiag.add(listOfCoordinates);
			  //System.out.println();
		  }

		  
		  for (int r = 1; r <= rowCount; r++) {
			  List<String> listOfCoordinates = new ArrayList<String>();
			  for (int row = r, col = columnCount; row >= 1 && col >= 1; row--, col--) {
				  listOfCoordinates.add(row+":"+col);
				  //System.out.print(row+":"+col + " "); 
			  }
			  listOfListofCoordinatesOfEacDiag.add(listOfCoordinates);
			  //System.out.println();
		  }
		   
		  for (int c = columnCount-1; c >=1 ; c--) {
			  List<String> listOfCoordinates = new ArrayList<String>();
			  for (int row = rowCount, col = c; row >= 1 && col >= 1; row--, col--) {
				  listOfCoordinates.add(row+":"+col);
				  //System.out.print(row+":"+col + " "); 
			  }
			  listOfListofCoordinatesOfEacDiag.add(listOfCoordinates);
			  //System.out.println();
		  }
	 }
			 
    public static void main(String args[] ) throws Exception {
    	populateDiagnolsDataAttributes();
    	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner s = new Scanner(System.in);
        int noOfTestCases = s.nextInt();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        Map<Integer,List<String>> testCaseNoToTruePointsPair = new LinkedHashMap<Integer, List<String>>();
        for(int i=0; i<noOfTestCases; i++){
        	s.nextLine(); // throw away the newline.
        	// Every Test Case :-
        	int noOfTruePointsForThisTestCase = s.nextInt();
        	List<String> coordinatesOfTruePoints = new ArrayList<String>();
        	for(int j = 0; j < noOfTruePointsForThisTestCase; j++){
        		s.nextLine(); // throw away the newline.
        		int xCoordinate = s.nextInt();
        		int yCoordinate = s.nextInt();
        		coordinatesOfTruePoints.add(String.valueOf(xCoordinate)+":"+String.valueOf(yCoordinate));
        	}
        	testCaseNoToTruePointsPair.put(i, coordinatesOfTruePoints);
        }
        
        for(Integer key : testCaseNoToTruePointsPair.keySet()){
        	//printTotalNoOfPairsWhichLiesInSameDiagnolEveryTestCaseWise(testCaseNoToTruePointsPair.get(key));
        	printTotalNoOfPtsThatLiesOnSameDiagnolForThisTestCase(testCaseNoToTruePointsPair.get(key));
        }
        
    }
    
	private static void printTotalNoOfPtsThatLiesOnSameDiagnolForThisTestCase(List<String> listOfPointsOfCurrentTestCase) {
		Map<Integer, Set<String>> diagnolNoToItsPoints = new HashMap<Integer, Set<String>>();
		for(int i=0; i<listOfListofCoordinatesOfEacDiag.size(); i++) {
			List<String> listOfPointsOfThisDiagnol = listOfListofCoordinatesOfEacDiag.get(i);
			
			Set<String> pointsThatLieOnThisDiagnol = new HashSet<String>();
			for(String point : listOfPointsOfCurrentTestCase) {
				if(listOfPointsOfThisDiagnol.contains(point)) {
					pointsThatLieOnThisDiagnol.add(point);
				}
			}
			if(null != pointsThatLieOnThisDiagnol && !pointsThatLieOnThisDiagnol.isEmpty()) {
				diagnolNoToItsPoints.put(i, pointsThatLieOnThisDiagnol);
			}
		}
		Set<String> finalSetOfPointsColloborate = new HashSet<String>();
		for(Integer diagnolNos : diagnolNoToItsPoints.keySet()){
			if(diagnolNoToItsPoints.get(diagnolNos).size()>1){
				finalSetOfPointsColloborate.addAll(diagnolNoToItsPoints.get(diagnolNos));
			}
		}
		System.out.println(finalSetOfPointsColloborate.size());
	}

	
	
	private static void printTotalNoOfPairsWhichLiesInSameDiagnolEveryTestCaseWise(
			List<String> list) {
		// 9:9, 3:5, 6:6, 2:8, 2:2, 1:3 
		
		// 9:9, 6:6, 2:2, 
		// 2:2, 1:3
		// 1:3, 3:5
		
		// Find difference wise, find all pairs possible. No DUplicates
		
		//Map<Integer, Set<String>> diagnolToPairsMap = new HashMap<Integer, Set<String>>();
		Set<String> pairsMap = new HashSet<String>();
		
		for(int i=0; i<list.size(); i++){
			for(int j=i+1; j<list.size(); j++){
				// Check If 2 points really lies on a diagnol. If yes, find their diagnol number and store.
				String point1st = list.get(i);
				String point2nd = list.get(j);
				
				String[] coordsOfPt1 = point1st.split(":");
				String[] coordsOfPt2 = point2nd.split(":");
				
				int xCoordOfPt1 = Integer.valueOf(coordsOfPt1[0]);
				int yCoordOfPt1 = Integer.valueOf(coordsOfPt1[1]);
				
				int xCoordOfPt2 = Integer.valueOf(coordsOfPt2[0]);
				int yCoordOfPt2 = Integer.valueOf(coordsOfPt2[1]);
				
				int diffOfXCoordinates = Math.abs(xCoordOfPt1 - xCoordOfPt2);
				int diffOfYCoordinates = Math.abs(yCoordOfPt1 - yCoordOfPt2);
				
				if(diffOfXCoordinates == diffOfYCoordinates){
					// Yes, These 2 points lies on a Diagnol.
					/*Set<String> alreadyExistingPairsOnThisDiagnol = diagnolToPairsMap.get(diffOfXCoordinates);
					if(null != alreadyExistingPairsOnThisDiagnol && !alreadyExistingPairsOnThisDiagnol.isEmpty()) {
						alreadyExistingPairsOnThisDiagnol.add(point1st);
						alreadyExistingPairsOnThisDiagnol.add(point2nd);
						diagnolToPairsMap.put(diffOfXCoordinates, alreadyExistingPairsOnThisDiagnol);
					} else {
						Set<String> pointsOnSameDiagnol = new HashSet<String>();
						pointsOnSameDiagnol.add(point1st);
						pointsOnSameDiagnol.add(point2nd);
						diagnolToPairsMap.put(diffOfXCoordinates, pointsOnSameDiagnol);
					}*/
					pairsMap.add(point1st);
					pairsMap.add(point2nd);
				}
			}
		}
		System.out.println(pairsMap.size());
	}
}