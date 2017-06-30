public class Main {
    public static void main(String[] args) {
        printMax(34.2, 3, 7.8, 39.43);
    }

    public static void printMax(double... numbers) {
        if(numbers.length == 0) {
            System.out.println("No arguments passed");
            return;
        }
        double result = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println("Max number is: " + result);
    }
}