package com.example.project;
public class LinearCalculator{
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    //4 INTEGER variables (name them: x1,x2,y1,y2) 


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        /* to convert a string that only contains number into integars
        https://www.freecodecamp.org/news/java-string-to-int-how-to-convert-a-string-to-an-integer/#:~:text=This%20leads%20us%20to%20the,a%20string%20to%20an%20integer.
        */
        this.x1 = Integer.parseInt(coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf(",")));
        this.y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 1, coord1.indexOf (")")));
        this.x2 = Integer.parseInt(coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf(",")));
        this.y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 1, coord2.indexOf (")")));
        /*this.x1 = Integar.parseInt();parseInt(coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf(",")));
        this.y1 = parseInt(coord1.substring(coord1.indexOf(",") + 1, coord1.indexOf (")")));
        this.x2 = parseInt(coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf(",")));
        this.y2 = parseInt(coord2.substring(coord2.indexOf(",") + 1, coord2.indexOf (")")));
        */
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int x1){this.x1 = x1;}
    public void setY1(int y1){this.y1 = y1;}
    public void setX2(int x2){this.x2 = x2;}
    public void setY2(int y2){this.y2 = y2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double verticalDis = y2-y1;
        double horizontalDis = x2-x1;
        double unroundedDis = Math.sqrt(Math.pow(verticalDis, 2) + Math.pow(horizontalDis, 2));
    /*
     * round method that helps round: https://stackoverflow.com/questions/8825209/rounding-decimal-points
     */
        return Math.round(unroundedDis * 100.0) / 100.0;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (x2-x1 == 0) {
            return -999.99;
        } else {
            double unroundedyInt = y1 - (slope() * x1);
            return roundedToHundredth(unroundedyInt);
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if (x2-x1 == 0) {
            return -999.99;
        } else {
            double ydiff = y2-y1;
            double xdiff = x2-x1;
            double unroundedSlope = ydiff/xdiff;
            return roundedToHundredth(unroundedSlope);
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope() == -999.99) {
            return "undefined";
        } if (slope() == 0) {
            return "y=" + yInt();
        } if (yInt() == 0) {
            return "y=" + slope() + "x";
        } if (yInt() < 0) {
            return "y=" + slope() + "x" + yInt();
        }else {
            return "y=" + slope() + "x+" + yInt();
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x * 100.00) / 100.0;
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (x1 == x2 * -1) {
            if (y1 == y2 * -1) {
                return "Symmetric about the origin";
            };
        } if (x1 == x2 * -1) {
            return "Symmetric about the y-axis";
        } if (y1 == y2 * -1) {
            return "Symmetric about the x-axis";
        } else{
            return "No symmetry";
        }
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double xmid = (x1 + x2) / 2;
        double ymid = (y1 + y2) / 2;
        return "The midpoint of this line is: (" + xmid + "," + ymid + ")";
    }
}



