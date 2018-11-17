package model;

public enum PlantTypes {
    SUNFLOWER("Sunflower"),
    PEASHOOTER("Peashooter");

    private String type;

    PlantTypes(String type) {
        this.type = type;
    }

    public String getName() {
        return type;
    }

    public char getType() {
        return type.charAt(0);
    }
}