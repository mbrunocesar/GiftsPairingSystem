import model.Gift;
import service.PairingService;
import service.SeasonService;
import service.seasons.Season;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    SeasonService seasonService;

    public static void main(String[] args) {
        // Is Perfect
        args = "SUMMER 50g Square, 100g Circle, 150g Rectangle, 200g Triangle, 250g Oval".split(" ");

        // Have Weight Variety
        // args = "SUMMER 50g Circle, 50g Square, 100g Square, 100g Square, 150g Square, 200g Square, 250g Square".split(" ");

        // Have Shape Variety
        // args = "SUMMER 50g Square, 150g Square, 150g Circle, 150g Circle, 150g Rectangle, 150g Triangle, 150g Oval".split(" ");

        // Have Perfect Pairing
        // args = "SUMMER 50 Circle, 50g Square, 50g Square, 200g Circle, 200g Circle, 200g Square, 200g Circle".split(" ");

        // Have Shape Pairing
        // args = "SUMMER 100g Oval, 150g Square, 50g Square, 50g Circle, 100g Triangle, 200g Circle, 200g Circle".split(" ");

        // Is Discount Basket
        // args = "SUMMER 50 Circle, 50g Square, 50g Square, 200g Circle, 200g Circle, 200g Square, 200g Square".split(" ");

        String seasons = args[0].equals("SPRING")
                || args[0].equals("SUMMER")
                || args[0].equals("AUTUMN")
                || args[0].equals("WINTER")
                ? args[0] : "SPRING";

        // removes the season from the args list
        args = Arrays.copyOfRange(args, 1, args.length);

        new Main(args, seasons);
    }

    public Main(String[] items, String season) {
        System.out.println("Season: " + season);

        Gift[] gifts = formatIntoGiftArray(items);

        seasonService = new SeasonService(Season.valueOf(season));

        List<Gift> result = seasonService.createBasket(gifts);

        for (Gift gift : result) {
            gift.print();
        }
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



}
