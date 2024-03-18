package service.pairings;

import model.Gift;

import java.util.LinkedList;
import java.util.List;

public class ShapeVariety implements MatcherInterface {
    public List<Gift> match(Gift[] gifts) {
        List<Gift> matchedItems = new LinkedList<Gift>();
        List<String> shapesFound = new LinkedList<String>();

        for (int i = 0; i < 3; i++) {
            Gift currenctGift = gifts[i];

            shapesFound.clear();
            matchedItems.clear();

            int baseVariety = currenctGift.size;

            shapesFound.add(currenctGift.shape);
            matchedItems.add(currenctGift);

            for (int j = 0; j < gifts.length; j++) {
                if (i == j) {
                    continue;
                }
                if (gifts[j].size == baseVariety && !shapesFound.contains(gifts[j].shape)) {
                    shapesFound.add(gifts[j].shape);
                    matchedItems.add(gifts[j]);
                }
            }

            if (shapesFound.size() >= 5) {
                break;
            }
        }

        if (shapesFound.size() < 5) {
            matchedItems.clear();
        }

        return matchedItems;
    }
}
