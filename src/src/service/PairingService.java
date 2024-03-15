package service;

import model.Gift;

import java.util.LinkedList;
import java.util.List;

public class PairingService {

    public List<Gift> matchByPerfectVariety(Gift[] gifts) {
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

    public List<Gift> matchByWeightVariety(Gift[] gifts) {
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

    public List<Gift> matchByShapeVariety(Gift[] gifts) {
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


    protected List<Gift> matchByPairing(Gift[] gifts, String TypeFlag) {
        List<Gift> matchedItems = new LinkedList<Gift>();

        List<String> shapesFound = new LinkedList<String>();
        boolean hasVariety = false;
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
                if (TypeFlag.equals("PerfectPairing")) {
                    if (gifts[i].hasSameValues(gifts[j])) {
                        if (sets[currentSet].isEmpty()) {
                            sets[currentSet].add(i);
                            sets[currentSet].add(j);
                        } else {
                            sets[currentSet].add(j);
                        }
                    }
                } else {
                    if (gifts[i].shape.equals(gifts[j].shape)) {
                        if (sets[currentSet].isEmpty()) {
                            sets[currentSet].add(i);
                            sets[currentSet].add(j);
                        } else {
                            sets[currentSet].add(j);
                        }
                    }
                }
            }
        }

        if (sets[0].size() >= 3 && sets[1].size() >= 2) {
            matchedItems.add(gifts[sets[0].get(0)]);
            matchedItems.add(gifts[sets[0].get(1)]);
            matchedItems.add(gifts[sets[0].get(2)]);
            matchedItems.add(gifts[sets[1].get(1)]);
            matchedItems.add(gifts[sets[1].get(2)]);

        } else if (sets[1].size() >= 3) {
            matchedItems.add(gifts[sets[0].get(0)]);
            matchedItems.add(gifts[sets[0].get(1)]);
            matchedItems.add(gifts[sets[1].get(0)]);
            matchedItems.add(gifts[sets[1].get(1)]);
            matchedItems.add(gifts[sets[1].get(2)]);

        } else if (sets[2].size() >= 3) {
            matchedItems.add(gifts[sets[0].get(0)]);
            matchedItems.add(gifts[sets[0].get(1)]);
            matchedItems.add(gifts[sets[2].get(0)]);
            matchedItems.add(gifts[sets[2].get(1)]);
            matchedItems.add(gifts[sets[2].get(2)]);
        }

        return matchedItems;
    }

    public List<Gift> matchByPerfectPairing(Gift[] gifts) {
        return matchByPairing(gifts, "PerfectPairing");
    }

    public List<Gift> matchByShapePairing(Gift[] gifts) {
        return matchByPairing(gifts, "ShapePairing");
    }

}
