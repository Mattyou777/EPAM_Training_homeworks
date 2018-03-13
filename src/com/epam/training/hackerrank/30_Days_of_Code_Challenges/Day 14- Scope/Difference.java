class Difference {
    public int maximumDifference;
    private int[] elements;

    Difference(int[] el) {
        elements = el;
    }

    void computeDifference() {
        int dif = 0;
        for (int i = 0; i < elements.length; i++) {
            int a = elements[i];
            for (int j = 1; j < elements.length; j++) {
                dif = Math.abs(a - elements[j]);
                if (dif > maximumDifference)
                    maximumDifference = dif;
            }
        }
    }
}
