class Calculator {
    int power(int a, int b) throws Exception {
        if (a >= 0 && b >= 0)
            return (int) Math.pow(a, b);
        else
            throw new Exception("n and p should be non-negative");
    }
}
