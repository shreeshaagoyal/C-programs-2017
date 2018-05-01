class What {
    public int a;
}

class FuncA implements Runnable {
    @Override
    public void run() {
    }
}

class FuncB implements Runnable {
    @Override
    public void run() {
    }
}

public class HelloJava {

    public static void runFuncs(Runnable[] funcs) {
        for (Runnable func : funcs) {
            func.run();
        }
    }

    public static void main(String[] args) {

        Runnable[] funcs = new Runnable[2];
        funcs[0] = new FuncA();
        funcs[1] = new FuncB();

        runFuncs(funcs);

        String str = "N100-W1-71-56";
        String[] numAndName = str.split("-", 2);

        for (String s : numAndName) {
            System.out.println(s);
        }
    }
}
