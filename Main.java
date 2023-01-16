//Rishi, Jashan, Manveer, Thushan
//Triangle Madness Assignment

import java.util.Scanner;

class Main { 
  public static void main(String[] args) {
    //Main Method Completed By: Thushan
    
    Scanner input = new Scanner(System.in);

    int o1; //option for first menu
    //1=option a, 2=option b, 3=option c
    int o2; //option for second menu
    //1=return specs, 2=perimeter, 3=area, 4=change side, 5=exit
    Triangle t = new Triangle(); 

    do {
      System.out.println("Enter an option:");
      System.out.println("1. Create a triangle using: 1 Side, 2 Angles");
      System.out.println("2. Create a triangle using: 2 Sides, 1 Angle");
      System.out.println("3. Create a triangle using: 3 Sides");
      o1 = input.nextInt();
    } while ((o1<1)||(o1>3));

    switch (o1) {
      case 1:
        t = Triangle.optionA(); //creates a Triangle with 1 side, 2 angles
        break;
      case 2:
        t = Triangle.optionB(); //creates a Triangle with 2 sides, 1 angle
        break;
      case 3:
        t = Triangle.optionC(); //creates a Triangle with 3 sides 
        break;
      //no default case needed since we ran exception handling when inputting option from user
    }

    do {
      System.out.println("Enter an option:");
      System.out.println("1. Return Specifications");
      System.out.println("2. Output Perimeter");
      System.out.println("3. Output Area");
      System.out.println("4. Change Side");
      System.out.println("5. Exit");
      System.out.println("An invalid option will exit the program.");
      o2 = input.nextInt();

      switch (o2) {
        case 1:
          Triangle.specs(t); //returns specifications of Triangle
          break;
        case 2:
          Triangle.perimeter(t); //outputs perimeter of Triangle
          break;
        case 3:
          Triangle.area(t); //outputs area of Triangle
          break;
        case 4:
          t.changeSide(); //changes side length in Triangle (and subsequently changes all angles in the Triangle as well)
          break;
        default:
        //case 5 and default both exit program, so group case 5 within default case
      }
    } while ((o2>=1)&&(o2<=4));

    System.out.println("Program has been exited.");
  }
}