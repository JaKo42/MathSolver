package core;

public class Calculation  {

    public static double divide(double dig1, double dig2){
        if(dig2==0.0) throw new ArithmeticException();
        double solution = dig1/dig2;
        return solution;
    }
    public static double multiply(double dig1, double dig2){
        double solution = dig1*dig2;
        return solution;
    }
    public static double subtract(double dig1, double dig2){
        double solution = dig1-dig2;
        return solution;
    }
    public static double add(double dig1, double dig2){
        double solution = dig1+dig2;
        return solution;
    }
}
