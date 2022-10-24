package lambda.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNursery {

    private final List<Sapling> saplings;

    public TreeNursery(List<Sapling> saplings) {
        this.saplings = saplings;
    }

    public void prune(int maxHeight) {
        saplings.forEach(sapling -> sapling.cut(maxHeight));
    }

    public void sell(String species, int minHeight) {
        saplings.removeIf(sapling -> sapling.getSpecies().equals(species) && sapling.getHeight() > minHeight);
    }

    public List<Sapling> getSaplings() {
        return new ArrayList<>(saplings);
    }
}
