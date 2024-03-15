import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Is Perfect
        // args = "Spring 150g Square, 250g Oval, 50g Rectangle, 100g Triangle, 50g Circle, 50g Circle, 200g Rectangle".split(" ");

        // Have Weight Variety
        args = "Spring 50g Circle, 50g Square, 100g Square, 100g Square, 150g Square, 200g Square, 250g Square".split(" ");

        // Have Shape Variety
        // args = "Spring 50g Square, 150g Square, 150g Circle, 150g Circle, 150g Rectangle, 150g Triangle, 150g Oval".split(" ");

        // Have Perfect Pairing
        // args = "Spring 50 Circle, 50g Square, 50g Square, 200g Circle, 200g Circle, 200g Square, 200g Circle".split(" ");

        // Have Shape Pairing
        // args = "Spring 100g Oval, 150g Square, 50g Square, 50g Circle, 100g Triangle, 200g Circle, 200g Circle".split(" ");

        // Is Discount Basket
        // args = "Spring 50 Circle, 50g Square, 50g Square, 200g Circle, 200g Circle, 200g Square, 200g Square".split(" ");

        String seasons = args[0].equals("Spring")
                || args[0].equals("Summer")
                || args[0].equals("Autumn")
                || args[0].equals("Winter")
                ? args[0] : "Spring";

        args = Arrays.copyOfRange(args, 1, args.length);

        new Main(args, seasons);
    }

    public Main(String[] items, String season) {
        System.out.println("Season: " + season);

        List<Gift> result = checkPairings(items, season);

        for (Gift gift : result) {
            gift.print();
        }
    }

    public List<Gift> checkPairings(String[] items, String season) {
        List<Gift> result;
        Gift[] gifts = formatIntoGiftArray(items);

        if (season.equals("Spring")) {
            List<Gift> perfectVariety = checkForPerfectVariety(gifts);
            if (!perfectVariety.isEmpty()) {
                return perfectVariety;
            }

            List<Gift> shapeVariety = checkForShapeVariety(gifts);
            if (!shapeVariety.isEmpty()) {
                return shapeVariety;
            }

            List<Gift> discountBasket = Arrays.stream(gifts).toList();
            return discountBasket;

        } else if (season.equals("Summer")) {
            List<Gift> perfectVariety = checkForPerfectVariety(gifts);
            if (!perfectVariety.isEmpty()) {
                return perfectVariety;
            }

            List<Gift> weightVariety = checkForWeightVariety(gifts);
            if (!weightVariety.isEmpty()) {
                return weightVariety;
            }

            List<Gift> shapeVariety = checkForShapeVariety(gifts);
            if (!shapeVariety.isEmpty()) {
                return shapeVariety;
            }

            List<Gift> perfectPairing = checkForPerfectPairing(gifts);
            if (!perfectPairing.isEmpty()) {
                return perfectPairing;
            }

            List<Gift> shapePairing = checkForShapePairing(gifts);
            if (!shapePairing.isEmpty()) {
                return shapePairing;
            }

            List<Gift> discountBasket = Arrays.stream(gifts).toList();
            return discountBasket;


        } else if (season.equals("Autumn")) {
            List<Gift> perfectVariety = checkForPerfectVariety(gifts);
            if (!perfectVariety.isEmpty()) {
                return perfectVariety;
            }

            List<Gift> weightVariety = checkForWeightVariety(gifts);
            if (!weightVariety.isEmpty()) {
                return weightVariety;
            }

            List<Gift> shapeVariety = checkForShapeVariety(gifts);
            if (!shapeVariety.isEmpty()) {
                return shapeVariety;
            }

            List<Gift> discountBasket = Arrays.stream(gifts).toList();
            return discountBasket;

        } else if (season.equals("Winter")) {
            List<Gift> perfectVariety = checkForPerfectVariety(gifts);
            if (!perfectVariety.isEmpty()) {
                return perfectVariety;
            }

            List<Gift> perfectPairing = checkForPerfectPairing(gifts);
            if (!perfectPairing.isEmpty()) {
                return perfectPairing;
            }

            List<Gift> discountBasket = Arrays.stream(gifts).toList();
            return discountBasket;
        }


        return null;
    }

    public Gift[] formatIntoGiftArray(String[] input) {
        Gift[] gifts = new Gift[input.length / 2];

        for (int i = 0; i < input.length; i = i + 2) {
            int size =  Integer.parseInt(input[i].substring(0, input[i].length() - 1));
            String shape = input[i+1].replaceAll(",", "");
            gifts[i/2] = new Gift(size, shape);
        }

        return gifts;
    }

    public List<Gift> checkForPerfectVariety(Gift[] gifts) {
        List<Gift> matchedItems = new LinkedList<Gift>();

        for (Gift gift : gifts) {
            for (Gift matched : matchedItems) {
                if (matched.haveSameParams(gift)) {
                    continue;
                }
            }
            matchedItems.add(gift);
            if (matchedItems.size() == 5) {
                break;
            }
        }

        if (matchedItems.size() < 5) {
            matchedItems.clear();
        }

        return matchedItems;
    }

    public List<Gift> checkForWeightVariety(Gift[] gifts) {
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

    public List<Gift> checkForShapeVariety(Gift[] gifts) {
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


    public List<Gift> checkForPairing(Gift[] gifts, String TypeFlag) {
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
                    if (gifts[i].haveSameParams(gifts[j])) {
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

    public List<Gift> checkForPerfectPairing(Gift[] gifts) {
        return checkForPairing(gifts, "PerfectPairing");
    }

    public List<Gift> checkForShapePairing(Gift[] gifts) {
        return checkForPairing(gifts, "ShapePairing");
    }

}
