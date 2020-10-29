package edu.cop2006.arraysandloops;
import java.util.ArrayList;

class Main
{

  public static void main(String[] args) {
    // int[] intArray = [5, 25, 10]

    ArrayList<Integer> intList = new ArrayList<>();

    intList.add(5);
    intList.add(25);
    intList.add(10);

    int total = 0;
    for(int num : intList) {
      System.out.println("Number is : " + num);
      total += num;
    }

    System.out.println("total is: " + total);
  }
}