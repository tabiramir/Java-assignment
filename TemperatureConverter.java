import java.util.*;

public class TemperatureConverter {
    public static double cToF(double c) {
        return (c * 9 / 5) + 32;
    }
    public static double cToK(double c) {
        return c + 273.15;
    }
    public static double fToC(double f) {
        return (f - 32) * 5 / 9;
    }
    public static double fToK(double f) {
        return fToC(f) + 273.15;
    }
    public static double kToC(double k) {
        return k - 273.15;
    }
    public static double kToF(double k) {
        return cToF(kToC(k));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the temperature value: ");
            double temperature = scanner.nextDouble();
            System.out.println("Select the scale of the input temperature:");
            System.out.println("1) Celsius\n2) Fahrenheit\n3) Kelvin");
            int scale = scanner.nextInt();
            switch (scale) {
                case 1: 
                    System.out.println("Celsius: " + temperature);
                    System.out.println("Fahrenheit: " + cToF(temperature));
                    System.out.println("Kelvin: " + cToK(temperature));
                    break;

                case 2:
                    System.out.println("Celsius: " + fToC(temperature));
                    System.out.println("Fahrenheit: " + temperature);
                    System.out.println("Kelvin: " + fToK(temperature));
                    break;

                case 3:
                    if (temperature < 0) {
                        System.out.println("Invalid input: Kelvin cannot be negative.");
                    } else {
                        System.out.println("Celsius: " + kToC(temperature));
                        System.out.println("Fahrenheit: " + kToF(temperature));
                        System.out.println("Kelvin: " + temperature);
                    }
                    break;
                default:
                    System.out.println("Invalid scale selected.");
            }
            System.out.println("----------------------------");
        }
        scanner.close();
    }
}
