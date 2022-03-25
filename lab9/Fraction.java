package lab9;

public class Fraction {

    private int n, d;

    public Fraction(int n, int d) {
        int gcd = gcd(n, d);
        this.n = n / gcd;
        this.d = d / gcd;
    }

    public int getNum() {
        return this.n;
    }

    public int getDenom() {
        return this.d;
    }

    public void setNum(int n) {
        int gcd = gcd(n, this.d);
        this.n = n / gcd;
    }

    public void setDenom(int d) {
        int gcd = gcd(this.n, d);
        this.d = d / gcd;
    }

    public Fraction add(Fraction a) {
        return(new Fraction(this.n*a.d+this.d*a.n, this.d*a.d));
    }

    public boolean equals(Fraction a) {
        return (this.n == a.n && this.d == a.d) ? true : false;
    }

    public String toString() {
        return String.format("%d/%d", this.n, this.d);
    }

    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}