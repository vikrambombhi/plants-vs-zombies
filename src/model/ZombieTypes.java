package model;

public enum ZombieTypes {
    ZOMBIE("Zombie"),
    TANK("Tank");

    private String type;

    ZombieTypes(String type) {
        this.type = type;
    }

    public String getName() {
        return type;
    }

    public char getType() {
        return type.charAt(0);
    }
}