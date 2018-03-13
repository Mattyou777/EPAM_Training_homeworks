public class OutOfMemoryErrorThrower2 {


    static void thrower() {
        while (true)
            new B();

    }

}

class B {

    @Override
    protected void finalize() throws Throwable {
        while (true)
            Thread.yield();
    }
}
