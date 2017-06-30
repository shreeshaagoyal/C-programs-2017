public class Main {
    public static void main(String []args) {
        double[] myList = {4.3, 6.78, 9.09, 3.5};
        
        // Print all array elements
        for(int i = 0; i < myList.length; i++) {
            System.out.println(myList[i]);
        }
        System.out.println("\n");

        // Summing all array elements
        double total = 0;
        for(int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Sum: " + total);

        // Finding the largest array element
        double largest = myList[0];
        for(int i = 1; i < myList.length; i++) {
            if(myList[i] > largest) {
                largest = myList[i];
            }
        }
        System.out.println("Largest element is: " + largest);

    }
}