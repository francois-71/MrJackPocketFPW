public enum Players {
    DETECTIVE("Detective"), MRJACK("MrJack",);
    int jeton;
    private String name;

    Players(String name) {
        this.name = name;
        this.jeton = 0;
    }
    public void addJeton(){
        ++this.jeton;
    }

    public String getName() {
        return name;
    }
}

