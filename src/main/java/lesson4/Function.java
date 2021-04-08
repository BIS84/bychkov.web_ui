package lesson4;

public class Function {

    public static void main(String[] args) {
        double S = isHeronFormula(2, 3, 4);
        System.out.println(S);
    }

    public static double isHeronFormula(int a, int b, int c) {

        double p = ((double) (a + b + c)) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
