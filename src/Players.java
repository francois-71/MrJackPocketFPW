public enum Players {
    DETECTIVE("Detective"), MrJACK("MrJack");
    private String name;

    Players(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

