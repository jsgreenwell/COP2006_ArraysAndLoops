package edu.cop2006.arraysandloops;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main
{

  public static void main(String[] args) throws FileNotFoundException {
    List<Map<String, String>> results = new ArrayList<>();
    FileReader reader = new FileReader("src/results.csv");

    try (BufferedReader resultReader = new BufferedReader(reader)) {
      String line; // holds current line
      int headers = 0;
      Map<String, String> sampleTests = new HashMap<>();
      String[] keys = new String[0];

      while ((line = resultReader.readLine()) != null) {
        if (headers == 0) {
          // Note this will change the size because it will re-assign it completely
          keys = line.split(",");
          headers++;
        } else {
          if (!line.startsWith("#")) {
            String[] field = line.split(",");
            for (int i=0; i<field.length;i++) {
              sampleTests.put(keys[i], field[i]);
            }
            results.add(sampleTests);
          }
        }
        // if line does not start with # (comment) then:
        // add the line to a our sample test data table
        // Then add that map to our full results for later processing/printing
      }
    } catch (IOException fileError) {
      System.out.println("File error: " + fileError.getStackTrace());
    }

    System.out.println("The first result set was: ");
    for (Map<String, String> r : results) {
      for (String k : r.keySet()) {
        System.out.printf("The %s is %s%n",
            k, r.get(k));
      }
      System.out.println("\nThe next result set was: ");
      // Leave further prettyifying of this output to reader
    }
  }
}