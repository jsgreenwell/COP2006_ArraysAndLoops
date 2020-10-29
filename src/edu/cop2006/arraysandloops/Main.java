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

    int total = 0;
    for(List<Integer> nums : results) {
      for (int num : nums) {
        System.out.println("Number is : " + num);
        total += num;
      }
    }

    System.out.println("total is: " + total);
  }
}