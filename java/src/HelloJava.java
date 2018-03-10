class What {
    public int a;
}

class FuncShreeshaa implements Runnable {
    @Override
    public void run() {
        System.out.println("This is FuncShreeshaa");
    }
}

class FuncShivanshu implements Runnable {
    @Override
    public void run() {
        System.out.println("This is FuncShivanshu");
    }
}

public class HelloJava {
    public static void runFuncs(Runnable[] funcs) {
        for (Runnable func : funcs) {
            func.run();
        }
    }

    public static void main(String[] args) {
        System.out.println("Go to Hell");

        Runnable[] funcs = new Runnable[2];
        funcs[0] = new FuncShivanshu();
        funcs[1] = new FuncShreeshaa();

        runFuncs(funcs);
    }
}
