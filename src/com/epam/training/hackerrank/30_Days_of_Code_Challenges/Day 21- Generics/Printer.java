class Printer<T> {
    <T> void printArray(T[] a) {
        for (T t : a)
            System.out.println(t);
    }
}
