package raj.yash;

public class MathUtils {

    public int add(int a1, int a2) {
        return a1 + a2;
    }

    public int substract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public int divide(int a,int b){
        return a/b;
    }

    public double area(int radius) {
        //did multiply by 100 to round up to 2 decimal places
        return Math.round(Math.PI * radius * radius * 100.0) / 100.0;
    }
}