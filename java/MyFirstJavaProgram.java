public class MyFirstJavaProgram {
    public MyFirstJavaProgram(String name) {
        System.out.println("Puppy's name is: " + name);
    }

    public static void main(String []args) {
        MyFirstJavaProgram myPuppy = new MyFirstJavaProgram( "Scruffy" );
    }
}