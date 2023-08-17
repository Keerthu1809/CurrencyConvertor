import java.util.*;
import java.text.DecimalFormat;

class CurrencyConverter {
    static DecimalFormat f = new DecimalFormat("##.###");
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int fromCode, toCode;

        System.out.println("Currency Converter\n");
        displayCurrencyCodes();

        do {
            System.out.print("Enter the currency code to convert from: ");
            fromCode = sc.nextInt();
        } while (fromCode < 1 || fromCode > 5);

        do {
            System.out.print("Enter the currency code to convert to: ");
            toCode = sc.nextInt();
        } while (toCode < 1 || toCode > 5);

        double amount = getAmount();
        convertCurrency(amount, fromCode, toCode);
    }

    static double getAmount() {
        System.out.print("Enter the amount: ");
        return sc.nextDouble();
    }

    static void convertCurrency(double amount, int fromCode, int toCode) {
        double fromRate = 1.0;
        double toRate = 1.0;

        switch (fromCode) {
            case 1: // Rupees
                fromRate = 75;
                break;
            case 2: // Dollars
                fromRate = 1 / 75.0;
                break;
            case 3: // Pounds
                fromRate = 101;
                break;
            case 4: // Euros
                fromRate = 84;
                break;
            case 5: // Kuwaiti Dinars
                fromRate = 250;
                break;
        }

        switch (toCode) {
            case 1: // Rupees
                toRate = 75;
                break;
            case 2: // Dollars
                toRate = 1 / 75.0;
                break;
            case 3: // Pounds
                toRate = 101;
                break;
            case 4: // Euros
                toRate = 84;
                break;
            case 5: // Kuwaiti Dinars
                toRate = 250;
                break;
        }

        double convertedAmount = amount * (fromRate / toRate);

        String fromCurrency = getCurrencyName(fromCode);
        String toCurrency = getCurrencyName(toCode);

        System.out.println(f.format(amount) + " " + fromCurrency + " is equivalent to " +
                           f.format(convertedAmount) + " " + toCurrency);
    }

    static String getCurrencyName(int code) {
        switch (code) {
            case 1:
                return "Rupees";
            case 2:
                return "Dollars";
            case 3:
                return "Pounds";
            case 4:
                return "Euros";
            case 5:
                return "Kuwaiti Dinars";
            default:
                return "Unknown Currency";
        }
    }

    static void displayCurrencyCodes() {
        System.out.println("Select a currency:");
        System.out.println("1: Indian Rupees");
        System.out.println("2: US Dollars");
        System.out.println("3: British Pounds");
        System.out.println("4: European Euros");
        System.out.println("5: Kuwaiti Dinars");
    }
}
