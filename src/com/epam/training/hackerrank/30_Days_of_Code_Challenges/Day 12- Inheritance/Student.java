class Student extends Person {
    protected int[] scores;
    private int[] testScores;

    Student(String firestName, String lastName, int id, int[] scores) {
        super(firestName, lastName, id);
        this.scores = scores;
    }

    char calculate() {
        int n = scores.length;
        int sum = 0;
        for (int i : scores) {
            sum += i;
        }
        return sum / n < 40 ? 'T' :
                sum / n < 55 ? 'D' :
                        sum / n < 70 ? 'P' :
                                sum / n < 80 ? 'A' :
                                        sum / n < 90 ? 'E' : 'O';
    }
}
