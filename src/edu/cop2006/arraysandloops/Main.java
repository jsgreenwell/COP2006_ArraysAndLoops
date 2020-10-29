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
    List<List<Integer>> results = new ArrayList<>();

    FileReader reader = new FileReader("src/edu/cop2006/arraysandloops/results.txt");

    try(BufferedReader resultReader = new BufferedReader(reader)) {
      String line; // remember we're reading from a "text" file so we have to convert

      while ((line = resultReader.readLine()) != null) {
        List<Integer> numbers = new ArrayList<>(); // remember strings cause textfile
        for (String number : line.split(",")) {
          numbers.add(Integer.parseInt(number));
          // you can also use (int) but this less error prone
        }
        results.add(numbers);
      }
    } catch (IOException fileEx) {
      System.out.println("Could not load file\n" + fileEx);
    }

    int total = 0;
    for (List<Integer> nums : results) {
      /* First version prints out just the totals like our first version 
      for(int num : nums) {
        System.out.println("Number is : " + num);
        total += num;
      } */

      int subtotal = 0;
      for(int i=0; i<nums.size(); i++) {
        System.out.printf("The %d number is %d. ",
            i+1, nums.get(i));
        subtotal += nums.get(i);
      }
      System.out.printf("The total for this group was %d%n", subtotal);
    }

    System.out.println("total is: " + total);
  }
}