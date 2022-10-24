package optional.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BucketList {

    private final List<Destination> destinations = new ArrayList<>();

    public Optional<Destination> getDestinationWithKeyword(String keyword) {
        return destinations.stream().filter(destination -> destination.getDescription().contains(keyword)).findFirst();
    }

    public Optional<Destination> getDestinationNearerThanGiven(int maxKm) {
        return destinations.stream().filter(destination -> destination.getKmFromHome() < maxKm).findFirst();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }
}
