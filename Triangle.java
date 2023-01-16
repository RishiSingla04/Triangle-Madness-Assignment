import java.util.Scanner;

public class Triangle {
  private double side_a, side_b, side_c; // sides a, b, and c
  private int angle_A, angle_B, angle_C; // angles A, B, and C

  // Constructors

  // Default constructor which sets sides equal to 1 and all angles to 60 degrees
  public Triangle() { 
    //Completed By: Rishi
    side_a = 1;
    side_b = 1;
    side_c = 1;
    angle_A = 60;
    angle_B = 60;
    angle_C = 60;
  }

  //constructor recieves one side (double a), two angles (int A, int B) and three variables of type int (s1, a1, a2) which tell us which side/angle of the triangle the side and angles belong to (1=side/angle a, 2=side/angle b, 3=side/angle c)
  //sets the correct side/angle to the correct value and calculates the rest of the missing values in the triangle 
  public Triangle(double a, int A, int B, int s1, int a1, int a2) {
    //Completed By: Thushan
    switch (a1) {
      case 1:
        angle_A = A;
        break;
      case 2:
        angle_B = A;
        break;
      case 3:
        angle_C = A;
        break;
      // no default case needed since we ran exception handling when inputting option
      // from user
    }
    switch (a2) {
      case 1:
        angle_A = B;
        break;
      case 2:
        angle_B = B;
        break;
      case 3:
        angle_C = B;
        break;
      // no default case needed since we ran exception handling when inputting option
      // from user
    }

    switch (s1) {
      case 1:
        side_a = a;
        if (((a1 == 1) && (a2 == 2)) || ((a1 == 2) && (a2 == 1))) {
          angle_C = subtract(angle_A, angle_B);
        } else if (((a1 == 1) && (a2 == 3)) || ((a1 == 3) && (a2 == 1))) {
          angle_B = subtract(angle_A, angle_C);
        } else if (((a1 == 2) && (a2 == 3)) || ((a1 == 3) && (a2 == 2))) {
          angle_A = subtract(angle_B, angle_C);
        }
        side_b = sineLaw(angle_A, angle_B, side_a);
        side_c = sineLaw(angle_A, angle_C, side_a);
        break;
      case 2:
        side_b = a;
        if (((a1 == 1) && (a2 == 2)) || ((a1 == 2) && (a2 == 1))) {
          angle_C = subtract(angle_A, angle_B);
        } else if (((a1 == 1) && (a2 == 3)) || ((a1 == 3) && (a2 == 1))) {
          angle_B = subtract(angle_A, angle_C);
        } else if (((a1 == 2) && (a2 == 3)) || ((a1 == 3) && (a2 == 2))) {
          angle_A = subtract(angle_B, angle_C);
        }
        side_a = sineLaw(angle_B, angle_A, side_b);
        side_c = sineLaw(angle_B, angle_C, side_b);
        break;
      case 3:
        side_c = a;
        if (((a1 == 1) && (a2 == 2)) || ((a1 == 2) && (a2 == 1))) {
          angle_C = subtract(angle_A, angle_B);
        } else if (((a1 == 1) && (a2 == 3)) || ((a1 == 3) && (a2 == 1))) {
          angle_B = subtract(angle_A, angle_C);
        } else if (((a1 == 2) && (a2 == 3)) || ((a1 == 3) && (a2 == 2))) {
          angle_A = subtract(angle_B, angle_C);
        }
        side_a = sineLaw(angle_C, angle_A, side_c);
        side_b = sineLaw(angle_C, angle_B, side_c);
        break;
      // no default case needed since we ran exception handling when inputting option
      // from user
    }
  }

  // constructor recieves two sides (a and b), one angle (A) and the locations of
  // the sides and angles (s1,s2,a1)
  // calculates the missing angles (A, B and C)
  public Triangle(double a, double b, int A, int s1, int s2, int a1) {
    //Completed By: Jashan
    switch (s1) {
      case 1:
        side_a = a;
        break;
      case 2:
        side_b = a;
        break;
      case 3:
        side_c = a;
        break;
      // no default case needed since we ran exception handling when inputting option
      // from user
    }
    switch (s2) {
      case 1:
        side_a = b;
        break;
      case 2:
        side_b = b;
        break;
      case 3:
        side_c = b;
        break;
      // no default case needed since we ran exception handling when inputting option
      // from user
    }
    switch (a1) {
      case 1:
        angle_A = A;
        if (((s1 == 1) && (s2 == 2)) || ((s1 == 2) && (s2 == 1))) {
          angle_B = sineLaw(side_a, side_b, angle_A);
          angle_C = subtract(angle_A, angle_B);
          side_c = sineLaw(angle_A, angle_C, side_a);
        } else if (((s1 == 1) && (s2 == 3)) || ((s1 == 3) && (s2 == 1))) {
          angle_C = sineLaw(side_a, side_c, angle_A);
          angle_B = subtract(angle_A, angle_C);
          side_b = sineLaw(angle_A, angle_B, side_a);
        } else if (((s1 == 2) && (s2 == 3)) || ((s1 == 3) && (s2 == 2))) {
          side_a = cosineLaw(side_b, side_c, angle_A);
          angle_B = cosineLaw(side_b, side_a, side_c);
          angle_C = subtract(angle_A, angle_B);
        }
        break;
      case 2:
        angle_B = A;
        if (((s1 == 1) && (s2 == 2)) || ((s1 == 2) && (s2 == 1))) {
          angle_A = sineLaw(side_b, side_a, angle_B);
          angle_C = subtract(angle_A, angle_B);
          side_c = sineLaw(angle_B, angle_C, side_b);
        } else if (((s1 == 1) && (s2 == 3)) || ((s1 == 3) && (s2 == 1))) {
          side_b = cosineLaw(side_a, side_c, angle_B);
          angle_A = cosineLaw(side_a, side_b, side_c);
          angle_C = subtract(angle_A, angle_B);
        } else if (((s1 == 2) && (s2 == 3)) || ((s1 == 3) && (s2 == 2))) {
          angle_C = sineLaw(side_b, side_c, angle_B);
          angle_A = subtract(angle_B, angle_C);
          side_a = sineLaw(angle_B, angle_A, side_b);
        }
        break;
      case 3:
        angle_C = A;
        if (((s1 == 1) && (s2 == 2)) || ((s1 == 2) && (s2 == 1))) {
          side_c = cosineLaw(side_a, side_b, angle_C);
          angle_A = cosineLaw(side_a, side_b, side_c);
          angle_B = subtract(angle_A, angle_C);
        } else if (((s1 == 1) && (s2 == 3)) || ((s1 == 3) && (s2 == 1))) {
          angle_A = sineLaw(side_c, side_a, angle_C);
          angle_B = subtract(angle_A, angle_C);
          side_b = sineLaw(angle_C, angle_B, side_c);
        } else if (((s1 == 2) && (s2 == 3)) || ((s1 == 3) && (s2 == 2))) {
          angle_B = sineLaw(side_c, side_b, angle_C);
          angle_A = subtract(angle_B, angle_C);
          side_a = sineLaw(angle_C, angle_A, side_c);
        }
        break;
      // no default case needed since we ran exception handling when inputting option
      // from user
    }
  }

  // constructor recieves three sides (a, b and c)
  // calculates the missing angles (A, B and C)
  public Triangle(double a, double b, double c) {
    //Completed By: Manveer
    side_a = a;
    side_b = b;
    side_c = c;
    angle_A = cosineLaw(side_a, side_b, side_c);
    angle_B = sineLaw(side_a, side_b, angle_A);
    angle_C = subtract(angle_A, angle_B);
  }

  // Mutators
  public void putSide_a(double a) {
    //Completed By: Rishi
    side_a = a;
  }

  public void putSide_b(double b) {
    //Completed By: Jashan
    side_b = b;
  }

  public void putSide_c(double c) {
    //Completed By: Manveer
    side_c = c;
  }

  public void putAngle_a(int a) {
    //Completed By: Thushan
    angle_A = a;
  }

  public void putAngle_b(int b) {
    //Completed By: Jashan
    angle_B = b;
  }

  public void putAngle_c(int c) {
    //Completed By: Rishi
    angle_C = c;
  }

  // Accessors
  public double getSide_a() { //returns side a
    //Completed By: Rishi
    return side_a;
  }

  public double getSide_b() { //returns side b
    //Completed By: Jashan
    return side_b;
  }

  public double getSide_c() { //returns side c
    //Completed By: Manveer
    return side_c;
  }

  public int getAngle_a() { //returns angle A
    //Completed By: Thushan
    return angle_A;
  }

  public int getAngle_b() { //returns angle B
    //Completed By: Manveer
    return angle_B;
  }

  public int getAngle_c() { //returns angle C
    //Completed By: Rishi
    return angle_C;
  }

  // Instance Methods

  // method recieves no parameters
  // prompts for which side length to change (a, b or c)
  // prompts for the new side length
  // changes the choosen side to the new side length
  // calculates the new angles of the triangle
  public void changeSide() {
    //Completed By: Jashan
    Scanner input = new Scanner(System.in);

    int side; // which side the user wants to change - 1=side a, 2=side b, 3=side c

    do {
      System.out.println("Which side do you want to change?");
      System.out.println("Enter 1 to change side a");
      System.out.println("Enter 2 to change side b");
      System.out.println("Enter 3 to change side c");
      side = input.nextInt();
    } while ((side < 1) || (side > 3));

    System.out.println("Enter new side length.");
    if (side == 1) {
      do {
        side_a = input.nextInt();
        if ((side_b <= side_a - side_c) || (side_b <= side_c - side_a) || (side_b >= side_a + side_c)
            || (side_a <= 0)) {
          System.out.println(
              "Error. b must be greater than (a-c) and (c-a) and less than (a+c). Also, new side cannot be less than 0. Enter a new value for side a.");
        }
      } while ((side_b <= side_a - side_c) || (side_b <= side_c - side_a) || (side_b >= side_a + side_c)
          || (side_a <= 0));
    } else if (side == 2) {
      do {
        side_b = input.nextInt();
        if ((side_b <= side_a - side_c) || (side_b <= side_c - side_a) || (side_b >= side_a + side_c)
            || (side_b <= 0)) {
          System.out.println(
              "Error. b must be greater than (a-c) and (c-a) and less than (a+c). Also, new side cannot be less than 0. Enter a new value for side b.");
        }
      } while ((side_b <= side_a - side_c) || (side_b <= side_c - side_a) || (side_b >= side_a + side_c)
          || (side_b <= 0));
    } else if (side == 3) {
      do {
        side_c = input.nextInt();
        if ((side_b <= side_a - side_c) || (side_b <= side_c - side_a) || (side_b >= side_a + side_c)
            || (side_c <= 0)) {
          System.out.println(
              "Error. b must be greater than (a-c) and (c-a) and less than (a+c). Also, new side cannot be less than 0. Enter a new value for side c.");
        }
      } while ((side_b <= side_a - side_c) || (side_b <= side_c - side_a) || (side_b >= side_a + side_c)
          || (side_c <= 0));
    }

    switch (side) {
      case 1:
        angle_A = cosineLaw(side_a, side_b, side_c);
        angle_B = sineLaw(side_a, side_b, angle_A);
        angle_C = subtract(angle_A, angle_B);
        break;
      case 2:
        angle_B = cosineLaw(side_b, side_a, side_c);
        angle_A = sineLaw(side_b, side_a, angle_B);
        angle_C = subtract(angle_A, angle_B);
        break;
      case 3:
        angle_C = cosineLaw(side_c, side_a, side_b);
        angle_A = sineLaw(side_b, side_a, angle_B);
        angle_B = subtract(angle_A, angle_C);
        break;
      // no default case needed since we ran exception handling when inputting option
      // from user
    }
  }

  // method recieves three sides (b, c and a)
  // method calculates and returns the angle opposite side a (angle A)
  public int cosineLaw(double a, double b, double c) {
    //Completed By: Thushan
    double x = (Math.acos(((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c))));
    x = Math.toDegrees(x);
    x = Math.round(x);
    int angle = (int) x;
    return angle;
  }

  // method recieves two sides (double b, double c) and one angle (int A)
  // method calculates and returns the side length opposite angle A (side a)
  public double cosineLaw(double b, double c, int A) {
    //Completed By: Jashan
    double doubleA = A;
    doubleA = Math.toRadians(doubleA);
    double a = (Math.sqrt((Math.pow(b, 2) + Math.pow(c, 2) - (2 * b * c * (Math.cos(doubleA))))));
    a = Math.round(a * 10.0) / 10.0;
    return a;
  }

  // method recieves two angles (A and B) and one side (a)
  // method calculates and returns the side length opposite angle B (side b)
  public double sineLaw(int A, int B, double a) {
    //Completed By: Rishi
    double doubleA = A;
    double doubleB = B;
    doubleA = Math.toRadians(doubleA);
    doubleB = Math.toRadians(doubleB);
    double b = (a * Math.sin(doubleB)) / Math.sin(doubleA);
    b = Math.round(b * 10.0) / 10.0;
    return b;
  }

  // method recieves one angle (A) and two sides (a and b)
  // method calculates and returns the angle opposite side b (angle B)
  public int sineLaw(double a, double b, int A) {
    //Completed By: Manveer
    double doubleA = A;
    doubleA = Math.toRadians(doubleA);
    double x = (Math.asin(((b * Math.sin(doubleA)) / (a))));
    x = Math.toDegrees(x);
    x = Math.round(x);
    int B = (int) x;
    return B;
  }

  // method recieves two angles (A and B)
  // method calculates and returns the third, missing angle (C)
  public int subtract(int A, int B) {
    //Completed By: Manveer
    int C = 180 - A - B;
    return C;
  }

  // method recieves one angle (A) and one side (b)
  // method calculates and returns the height of the triangle (h)
  public double height(int A, double b) {
    //Completed By: Jashan
    double doubleA = A;
    doubleA = Math.toRadians(doubleA);
    double h = ((b) * (Math.sin(doubleA)));
    h = Math.round(h * 10.0) / 10.0;
    return h;
  }

  // Class Methods

  // method recieves a triangle
  // prints all specifications of the triangle (all sides and all angles)
  public static void specs(Triangle t) {
    //Completed By: Manveer
    System.out.println("Side a: " + t.side_a);
    System.out.println("Side b: " + t.side_b);
    System.out.println("Side c: " + t.side_c);
    System.out.println("Angle A: " + t.angle_A);
    System.out.println("Angle B: " + t.angle_B);
    System.out.println("Angle C: " + t.angle_C);
  }

  // method recieves a triangle
  // calculates and prints the perimeter of the triangle
  public static void perimeter(Triangle t) {
    //Completed By: Manveer
    double p = (t.side_a + t.side_b + t.side_c);
    System.out.println("Perimeter: " + p);
  }

  // method recieves an object "t" of type Triangle
  // calculates and prints the area of the triangle
  public static void area(Triangle t) {
    //Completed By: Thushan
    double height; // height of triangle
    height = t.height(t.angle_A, t.side_b);

    double area; // area of triangle
    area = (t.side_b * height) / 2;
    area = Math.round(area * 10.0) / 10.0;

    System.out.println("Area: " + area);
  }

  // method recieves no parameters
  // user will choose which side or angle to modify (S1, A1, A2)
  // if S1 = 1, user chooses to modify side a
  // if S1 = 2, user chooses to modify side b
  // if S1 = 3, user chooses to modify side c
  // if A1,A2 = 1, user chooses to modify angle A
  // if A1,A2 = 2, user chooses to modify angle B
  // if A1,A2 = 3, user chooses to modify angle C
  // method specifically prompts for the chosen side(1) and angles(2)
  // returns a new triangle consisting of the two angles, one side and the
  // location they need to be modified
  public static Triangle optionA() {
    //Completed By: Rishi
    Scanner input = new Scanner(System.in);

    int S1, A1, A2 = 0;
    double a;
    int A, B = 0;

    do {
      System.out.println("1. Side a\n2. Side b\n3. Side c");
      System.out.println("Enter the side you want to enter");
      S1 = input.nextInt();
    } while (S1 < 1 || S1 > 3);

    do {
      System.out.println("Enter the length");
      a = input.nextDouble();
    } while (a <= 0);

    do {
      System.out.println("1. Angle a\n2. Angle b\n3.Angle c");
      System.out.println("Enter the angle you want to enter");
      A1 = input.nextInt();
    } while (A1 < 1 || A1 > 3);

    do {
      System.out.println("Enter the angle");
      A = input.nextInt();
    } while (A <= 0 || A > 178);

    switch (A1) {
      case 1:
        do {
          System.out.println("1. Angle b\n2.Angle c");
          System.out.println("Enter the angle you want to enter");
          A2 = input.nextInt() + 1;
        } while (A2 < 2 || A2 > 3);

        do {
          System.out.println("Enter the angle");
          B = input.nextInt();
        } while (B <= 0 || B >= 180 - A);
        break;

      case 2:
        do {
          System.out.println("1. Angle a\n2. Angle c");
          System.out.println("Enter the angle you want to enter");
          A2 = input.nextInt();

          if (A2 == 1) {
            do {
              System.out.println("Enter the angle");
              B = input.nextInt();
            } while (B <= 0 || B >= 180 - A);
          }

          else if (A2 == 2) {
            A2 = 3;
            do {
              System.out.println("Enter the angle");
              B = input.nextInt();
            } while (B <= 0 || B >= 180 - A);
            break;
          }

        } while (A2 < 1 || A2 >= 3);
        break;

      case 3:
        do {
          System.out.println("1. Angle a\n2. Angle b");
          System.out.println("Enter the angle you want to enter");
          A2 = input.nextInt();
        } while (A2 < 1 || A2 > 2);

        do {
          System.out.println("Enter the angle");
          B = input.nextInt();
        } while (B <= 0 || B >= 180 - A);
        break;
    }

    Triangle t = new Triangle(a, A, B, S1, A1, A2);

    return t;
  }

  // method recieves no parameters
  // user will choose which side or angle to modify (S1, S2, A1)
  // if S1,S2 = 1, user chooses to modify side a
  // if S1,S2 = 2, user chooses to modify side b
  // if S1,S2 = 3, user chooses to modify side c
  // if A1 = 1, user chooses to modify angle A
  // if A1 = 2, user chooses to modify angle B
  // if A1 = 3, user chooses to modify angle C
  // method specifically prompts for the chosen sides(2) and angle(1)
  // returns a new triangle consisting of the two sides, one angle and the
  // location they need to modified
  public static Triangle optionB() {
    //Completed By: Rishi
    Scanner input = new Scanner(System.in);

    int S1, S2 = 0, A1;
    double a, b = 0; // sides a and b
    int A; // angle A

    do {
      System.out.println("1. Side a\n2. Side b\n3. Side c");
      System.out.println("Enter the side you want to enter");
      S1 = input.nextInt();
    } while (S1 < 1 || S1 > 3);

    do {
      System.out.println("Enter the length");
      a = input.nextDouble();
    } while (a <= 0);

    switch (S1) {
      case 1:
        do {
          System.out.println("1. Side b\n2.Side c");
          System.out.println("Enter the side you want to enter");
          S2 = input.nextInt() + 1;
        } while (S2 < 2 || S2 > 3);

        do {
          System.out.println("Enter the length");
          b = input.nextInt();
        } while (b <= 0);
        break;

      case 2:
        do {
          System.out.println("1. Side a\n2. Side c");
          System.out.println("Enter the side you want to enter");
          S2 = input.nextInt();

          if (S2 == 1) {
            do {
              System.out.println("Enter the length");
              b = input.nextInt();
            } while (b <= 0);
          }

          else if (S2 == 2) {
            S2 = 3;
            do {
              System.out.println("Enter the length");
              b = input.nextInt();
            } while (b <= 0);
            break;
          }

        } while (S2 < 1 || S2 >= 3);
        break;

      case 3:
        do {
          System.out.println("1. Side a\n2. Side b");
          System.out.println("Enter the side you want to enter");
          S2 = input.nextInt();
        } while (S2 < 1 || S2 > 2);

        do {
          System.out.println("Enter the length");
          b = input.nextInt();
        } while (b <= 0);
        break;
    }

    do {
      System.out.println("1. Angle a\n2. Angle b\n3. Angle c");
      System.out.println("Enter the angle you want to enter");
      A1 = input.nextInt();
    } while (A1 < 1 || A1 > 3);

    do {
      System.out.println("Enter the degree");
      A = input.nextInt();
    } while (a <= 0 || a >= 178);

    Triangle t = new Triangle(a, b, A, S1, S2, A1);

    return t;
  }

  // method recieves no parameters
  // prompts for sides a, b and c
  // creates and returns a new Triangle consisting of the three sides
  // represents option C (creating a Triangle with 3 sides)
  public static Triangle optionC() {
    //Completed By: Thushan
    Scanner input = new Scanner(System.in);

    double a, b, c; // sides a, b, and c
    a = 0;
    b = 0;
    c = 0;

    
    while ((b <= a - c) || (b <= c - a) || (b >= a + c)) {
      //all of these conditions regarding side lengths are necessary for the cosine law to work
      //without these conditions, there will be some cases where the cosine law will not work (i.e. invalid or incorrect answer)
      do {
        System.out.println("Enter side a");
        a = input.nextDouble();
      } while (a <= 0);
      do {
        System.out.println("Enter side b");
        b = input.nextDouble();
      } while (b <= 0);
      do {
        System.out.println("Enter side c");
        c = input.nextDouble();
      } while (c <= 0);
      if ((b <= a - c) || (b <= c - a) || (b >= a + c)) {
        System.out.println("Error. b must be greater than (a-c) and (c-a) and less than (a+c). Enter new values.");
      }
    }

    Triangle t = new Triangle(a, b, c);

    return t;
  }
}