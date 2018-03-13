class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        return a.score == b.score ? a.name.compareTo(b.name) : b.score - a.score;
    }
}
