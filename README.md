# CurrencyConvertor
/*The Currency Converter project in Java is a user-friendly application designed to swiftly convert monetary values between various currencies.By encapsulating essential Java programming concepts, such as GUI development, API integration, data parsing, the Currency Converter project provides a valuable tool for users navigating  international travelling.*?
import java.util.*;
import java.text.DecimalFormat;

class CurrencyConverter {
    static DecimalFormat f = new DecimalFormat("##.###");
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int code;

        System.out.println("Currency Converter\n");
        displayCountryOptions();

        do {
            System.out.print("Enter the country code: ");
            code = sc.nextInt();
        } while (code < 1 || code > 2);

        double amount;
        switch (code) {
            case 1:
                amount = getAmount("Indian Rupees (INR)");
                convertFromINR(amount);
                break;
            case 2:
                amount = getAmount("US Dollars (USD)");
                convertFromUSD(amount);
                break;
        }
    }

    static double getAmount(String currencyName) {
        System.out.print("Enter amount in " + currencyName + ": ");
        return sc.nextDouble();
    }

    static void convertFromINR(double inr) {
        double usd = inr / 75;
        System.out.println("US Dollars (USD): $" + f.format(usd));
    }

    static void convertFromUSD(double usd) {
        double inr = usd * 75;
        System.out.println("Indian Rupees (INR): Rs " + f.format(inr));
    }

    static void displayCountryOptions() {
        System.out.println("Select countries for conversion:");
        System.out.println("1: Indian Rupees (INR) to US Dollars (USD)");
        System.out.println("2: US Dollars (USD) to Indian Rupees (INR)");
    }
}

