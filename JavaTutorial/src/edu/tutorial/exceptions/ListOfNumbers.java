package edu.tutorial.exceptions;
// Note: This class will not compile yet.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;
    private static String OUTPUT_FILENAME = "OutFile.txt";

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }
    public static File currentDir = new File(".");
    
    public static String getFilePath(String filename) throws IOException {
		return currentDir.getCanonicalPath()+ File.pathSeparator + filename;
    }

    public void writeList() {
    	System.out.println("Started ...");
        PrintWriter out = null;
		try {
			File file = new File(getFilePath(OUTPUT_FILENAME));
			out = new PrintWriter(new FileWriter(file));
	        for (int i = 0; i < 10; i++) {
	            out.println("Value at: " + i + " = " + list.get(i));
	        }
	        out.close();
		} catch (IOException | IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
        System.out.println("Completed ...");
    }
    
    public void readFile() throws FileNotFoundException, IOException {
    	Scanner fileReader = null;
    	try {
    		System.out.println("File output: ");
			fileReader = new Scanner(new File(getFilePath(OUTPUT_FILENAME)));
		      while (fileReader.hasNextLine()) {
		          String data = fileReader.nextLine();
		          System.out.println(data);
		        }
		} finally {
			
		}
    }
    
    public void readFile2() {
    	System.out.println("In read file...");
    	try(Scanner fileReader = new Scanner(new FileReader(getFilePath(OUTPUT_FILENAME)))) {
		      while (fileReader.hasNextLine()) {
		          String data = fileReader.nextLine();
		          System.out.println(data);
		        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void readFile3() throws FileNotFoundException, IOException {
    	System.out.println("In read file...");
    	try(Scanner fileReader = new Scanner(new FileReader(getFilePath(OUTPUT_FILENAME)))) {
		      while (fileReader.hasNextLine()) {
		          String data = fileReader.nextLine();
		          System.out.println(data);
		        }
		}
    }
    
    public void readFile1() throws IOException, IndexOutOfBoundsException {
    	throw new IOException();	  
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
		ListOfNumbers list = new ListOfNumbers();
		list.writeList();
		list.readFile();
	}
}