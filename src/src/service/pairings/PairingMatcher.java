package service.pairings;

import model.Gift;

import java.util.LinkedList;
import java.util.List;

public class PairingMatcher {
    public List<Gift> match(Gift[] gifts, PairingEnum TypeFlag) {
        List<Gift> matchedItems = new LinkedList<Gift>();

        int currentSet = 0;

        List<Integer>[] sets = new List[3];
        sets[0] = new LinkedList<Integer>();
        sets[1] = new LinkedList<Integer>();
        sets[2] = new LinkedList<Integer>();

        for (int i = 0; i < gifts.length; i++) {
            if (!sets[0].isEmpty()) {
                currentSet = 1;
                if (!sets[1].isEmpty()) {
                    currentSet = 2;
                }
            }

            for (int j = i + 1; j < gifts.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((TypeFlag == PairingEnum.PERFECT_PAIRING && gifts[i].hasSameValues(gifts[j]))
                    || (TypeFlag == PairingEnum.SHAPE_PAIRING && gifts[i].shape.equals(gifts[j].shape))
                ) {
                    if (sets[currentSet].isEmpty()) {
                        sets[currentSet].add(i);
                        sets[currentSet].add(j);
                    } else {
                        sets[currentSet].add(j);
                    }
                }
            }
        }

        if (sets[0].size() >= 3 && sets[1].size() >= 2) {
            for (int i = 0; i < 3; i++) {
                matchedItems.add(gifts[sets[0].get(i)]);
            }
            for (int i = 0; i < 2; i++) {
                matchedItems.add(gifts[sets[1].get(i)]);
            }

        } else if (sets[1].size() >= 3) {
            matchedItems.add(gifts[sets[0].get(0)]);
            matchedItems.add(gifts[sets[0].get(1)]);
            for (int i = 0; i < 3; i++) {
                matchedItems.add(gifts[sets[1].get(i)]);
            }

        } else if (sets[2].size() >= 3) {
            matchedItems.add(gifts[sets[0].get(0)]);
            matchedItems.add(gifts[sets[0].get(1)]);
            for (int i = 0; i < 3; i++) {
                matchedItems.add(gifts[sets[2].get(i)]);
            }
        }

        return matchedItems;
    }
}
