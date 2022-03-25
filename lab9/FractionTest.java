package lab9;

public class FractionTest {
    public static void main(String[] args) {
        Fraction frac = new Fraction(4, 16);
        System.out.println(frac.toString());
        System.out.println(frac.equals(new Fraction(1, 4)));
        frac.setNum(2);
        frac.setDenom(6);
        System.out.println(frac.add(new Fraction(7, 6)));
    }
}