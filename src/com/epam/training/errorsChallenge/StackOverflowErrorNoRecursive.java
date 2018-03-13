public class StackOverflowErrorNoRecursive {

    static void thrower() {

        long[] hugeArray = new long[1_000_000_000];

    }
}
