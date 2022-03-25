package lab9;

public class CarTest{
    public static void main(String[] args) {
        Car sportsCar = new Car("Porsche", "918 Spyder", 2015, 18.5, 67.0, 125.0, 18.5);
        sportsCar.drive(113);
        System.out.println(sportsCar.getFuelRemaining());
        sportsCar.fillTank(5);
        sportsCar.drive(25);
        System.out.println(sportsCar.toString());
    }
}