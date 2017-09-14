public class Competition {
    public static int findAverage(String arr) {
        String[] inputArray = arr.split(",");
        int i;
        Integer sum = new Integer(0);
        for(i = 0; i < inputArray.length; i++) {
            sum += sum.parseInt(inputArray[i]);
        }
        int average = sum / i;
        if(sum%i != 0) {
            return average+1;
        } else {
            return average;
        }
    }

    public static int[][] infectedComputers(int[][] matrix) {
        while(true) {
            boolean changed = false;
            for(int row = 0; row < matrix.length; row++) {
                for(int column = 0; column < matrix[0].length; column++) {

                }
            }
            if(!changed) {
                return matrix;
            }
        }
    }

    public static int[][] transposeMatrix(int[] arr, int rows, int columns) {
        int[][] resultMatrix = new int[columns][rows];
        for(int i = 0; i < columns; i++) {
            int index = i;
            for(int j = 0; j < rows; j++) {
                resultMatrix[j][i] = arr[index];
                index += columns;
            }
        }
        return resultMatrix;
    }

    public static int[][] rotateMatrix(int[][] matrix, int n) {
        for(int layer = 0; layer <= n/2; layer++) {
            int start = layer;
            int end = n - 1 - layer;
            int j = end;
            for(int i = start; i < end; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[j][start];
                matrix[j][start] = matrix[end][j];
                matrix[end][j] = matrix[i][end];
                matrix[i][end] = temp;
                j--;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(findAverage("1,2,3,4"));
    }
}