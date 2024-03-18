package service.pairings;

import model.Gift;

import java.util.LinkedList;
import java.util.List;

public class WeightVariety implements MatcherInterface {
    public List<Gift> match(Gift[] gifts) {
        List<Gift> matchedItems = new LinkedList<Gift>();
        List<Integer> sizesFound = new LinkedList<Integer>();

        for (int i = 0; i < 3; i++) {
            Gift currenctGift = gifts[i];

            sizesFound.clear();
            matchedItems.clear();

            String baseVariety = currenctGift.shape;

            sizesFound.add(currenctGift.size);
            matchedItems.add(currenctGift);

            for (int j = 0; j < gifts.length; j++) {
                if (i == j) {
                    continue;
                }
                if (gifts[j].shape.equals(baseVariety) && !sizesFound.contains(gifts[j].size)) {
                    sizesFound.add(gifts[j].size);
                    matchedItems.add(gifts[j]);
                }
            }

            if (sizesFound.size() >= 5) {
                break;
            }
        }

        if (sizesFound.size() < 5) {
            matchedItems.clear();
        }

        return matchedItems;
    }

}
