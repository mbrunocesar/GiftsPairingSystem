package service.pairings;

import model.Gift;

import java.util.LinkedList;
import java.util.List;

public class PerfectVariety implements MatcherInterface {
    public List<Gift> match(Gift[] gifts) {
        List<String> matchedTypes = new LinkedList<String>();
        List<Integer> matchedSizes = new LinkedList<Integer>();

        List<Gift> matchedItems = new LinkedList<Gift>();

        for (Gift gift : gifts) {
            boolean skip = false;
            for (Gift matched : matchedItems) {
                if (matched.hasSameValues(gift)) {
                    skip = true;
                }
            }
            if (skip) {
                continue;
            }

            if (!matchedTypes.contains(gift.shape) && !matchedSizes.contains(gift.size)) {
                matchedTypes.add(gift.shape);
                matchedSizes.add(gift.size);
                matchedItems.add(gift);
            }

            if (matchedItems.size() == 5) {
                break;
            }
        }

        if (matchedItems.size() < 5) {
            matchedItems.clear();
        }

        return matchedItems;
    }

}
