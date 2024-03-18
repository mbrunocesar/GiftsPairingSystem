import model.Gift;

import java.util.List;

public class Helper {
    public static Gift[] formatIntoGiftArray(String[] input) {
        Gift[] gifts = new Gift[input.length / 2];
        if (input[0].contains("g")) {
            for (int i = 0; i < input.length; i = i + 2) {
                int size = Integer.parseInt(input[i].substring(0, input[i].length() - 1));
                String shape = input[i + 1].replaceAll(",", "");
                gifts[i / 2] = new Gift(size, shape);
            }
        } else {
            for (int i = 0; i < input.length; i = i + 2) {
                int size = Integer.parseInt(input[i]);
                String shape = input[i + 1];
                gifts[i / 2] = new Gift(size, shape);
            }
        }

        return gifts;
    }

    public static void printResult(List<Gift> result) {
        for (Gift gift : result) {
            gift.print();
        }
    }
}
