package lab9;

public class Car {

    private String make, model;
    private int year;
    private double fuelCapacity, MPG, milesDriven, fuelRemaining;

    public Car(String carMake, String carModel, int carYear, double carFuelCapacity, double carMPG,
                double carMilesDriven, double carFuelRemaining) {
        this.make = carMake;
        this.model = carModel;
        this.year = carYear;
        this.fuelCapacity = carFuelCapacity;
        this.MPG = carMPG;
        this.milesDriven = carMilesDriven;
        this.fuelRemaining = carFuelRemaining;
    }

    public void fillTank(double g) {
        this.fuelRemaining = (g + fuelRemaining > this.fuelCapacity) ? this.fuelCapacity : this.fuelRemaining + g;
    }

    public void drive(double m) {
        double fuelNeeded = m / this.MPG;
        if (fuelNeeded <= this.fuelRemaining){
            this.milesDriven += m;
            this.fuelRemaining -= fuelNeeded;
        } else {
            System.out.println("You're out of gas!");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d %s %s:\n", this.year, this.make, this.model));
        sb.append(String.format("\tTank Size: %.1fg\n", this.fuelCapacity));
        sb.append(String.format("\tMPG: %.2fm/g\n", this.MPG));
        sb.append(String.format("\tOdometer: %.1fm\n", this.milesDriven));
        sb.append(String.format("\tFuel Remaining: %.2fg", this.fuelRemaining));
        return sb.toString();
    }

    public double getFuelRemaining() {
        return this.fuelRemaining;
    }

}