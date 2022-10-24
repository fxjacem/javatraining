package lambda.tree;

public class Sapling {

    private final String species;

    private int height;

    public Sapling(String species, int height) {
        this.species = species;
        this.height = height;
    }

    public void cut(int maxHeight) {
        setHeight(Math.min(height, maxHeight));
    }

    public String getSpecies() {
        return species;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
