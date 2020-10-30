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

      while ((line = resultReader.readLine()) != null) {
        if (headers == 0) {
          for (String field: line.split(",")) {
            sampleTests.put(field, "");
          }
          headers++;
        } else {
          if (!line.startsWith("#")) {
            String[] field = line.split(",");
            for (int i=0; i<field.length;i++) {
              switch (i) {
                case 0:
                  sampleTests.put("id", field[i]);
                  break;
                case 1:
                  sampleTests.put("label", field[i]);
                  break;
                case 2:
                  sampleTests.put("x", field[i]);
                  break;
                case 3:
                  sampleTests.put("y", field[i]);
                  break;
                case 4:
                  sampleTests.put("weight", field[i]);
                  break;
                case 5:
                  sampleTests.put("cluster", field[i]);
                  break;
              }
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