package edu.cop2006.arraysandloops;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main
{

  public static void main(String[] args) throws FileNotFoundException {
    List< List<Integer> > results = new ArrayList<>();
    FileReader reader = new FileReader("src/results.txt");

    try (BufferedReader resultReader = new BufferedReader(reader)) {
      String line; // holds current line

      while ((line = resultReader.readLine()) != null) {
        List<Integer> currentLine = new ArrayList<>();

        if (!line.startsWith("#")) {
          for (String field: line.split(",")) {
            currentLine.add(Integer.parseInt(field));
          }
          results.add(currentLine);
        }
        // if line does not start with # (comment) then:
        // add the line to a temporay List ( Integer)
        // Then add that list to our full results
      }
    } catch (IOException fileError) {
      System.out.println("File error: " + fileError.getStackTrace());
    }

    /*
    Will print out each set (list) of numbers and the total for that set
    Then calculate the full total of all numbers and print that
     */
    int allTotals = 0;
    for(List<Integer> nums : results) {

      int total = 0;
      for (int i=0; i<nums.size(); i++) {
        System.out.printf("The %d number is %d. ",
            i+1, nums.get(i));
        total += nums.get(i);
      }
      System.out.println("Total for this row is " + total);
      allTotals += total;
    }

    System.out.println("Everything totalled is: " + allTotals);
  }
}