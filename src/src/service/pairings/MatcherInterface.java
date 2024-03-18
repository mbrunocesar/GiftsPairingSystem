package service.pairings;

import model.Gift;

import java.util.List;

public interface MatcherInterface {
    List<Gift> match(Gift[] gifts);
}
