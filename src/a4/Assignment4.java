package a4;

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Assignment4 {

	/**
	 *
	 * @param filename
	 * @return number of lines in a text file
	 * @throws Exception
	 */
	public static int getNoLines(String filename) throws Exception{
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
			return (int) fileStream.count();
		} 
	}

	/**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
	public static int[][] create2DArray(String filename) throws Exception {
		int arr[][];

		int numLines = getNoLines(filename);
		arr = new int[numLines][];

		int row =0;

		Scanner fsc = new Scanner(new File(filename));
		String line;
		while (fsc.hasNextLine() && row <numLines) {
			line = fsc.nextLine();
			String values[] = line.split(" ");
			//allocate row
			arr[row] = new int[values.length];
			for (int j = 0;j<values.length;j++)
				arr[row][j]= Integer.parseInt(values[j]);
			row++;
		}
		fsc.close();
		
        return arr;
	}
	/**
	 * 
	 * @param arr
	 * @return the index of the longest row in the array
	 */
	public static int findLongestRow(int [][]arr) throws Exception {
		int max = arr[0].length;
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
		   if (arr[i].length>max) {
			   max = arr[i].length;
			   index = i;
		   }
		   
		}
		return index;
	}
	/**
	 * 
	 * @param arr
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public static int findMaxInRow(int [][]arr, int index) throws Exception {
		int result = arr[index][arr[index].length-1];
		for (int i = arr[index].length-2; i >=0; i--) {
			if (arr[index][i] > result) {
				result = arr[index][i];
			}
		}
		return result;
	}
	/**
	 * 
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public static int findMax(int [][]arr) throws Exception {
		int max = arr[0][0];
		
		for (int i=0;i<arr.length;i++) {
			for (int j = 0; j<arr[i].length; j++)
				if (arr[i][j]>max)
					max = arr[i][j];
						}
		return max;
	}
	public static void main(String[] args) {
		String filename = null;
		if (args.length <1) {
			System.out.println("usage: Assignment4 inputFilename ");
			System.exit(0);
			
		}
		filename = args[0];
		int arr[][] = null;
		try {
			System.out.println("Number of lines in the file ="+ getNoLines(filename));
			arr = create2DArray(filename);
			int longestRow = findLongestRow(arr);
			System.out.println("Longest row in the file is: "+ (longestRow+1 )+" ,with length of: "
			                      +arr[longestRow].length);
			System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
			System.out.println("Max value in file = "+ findMax(arr));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
