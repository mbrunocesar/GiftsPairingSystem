import model.Gift;
import service.SeasonService;
import service.seasons.SeasonsEnum;

import java.util.Arrays;
import java.util.List;

public class Main {

    SeasonService seasonService;

    public static void main(String[] args) {
        // Is Perfect
        args = "SUMMER 50g Square, 50g Circle, 100g Circle, 150g Oval, 150g Rectangle, 200g Triangle, 250g Oval".split(" ");

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

    public Main() {

    }

    public Main(String[] items, String season) {
        Gift[] gifts = Helper.formatIntoGiftArray(items);

        setSeason(season);
        List<Gift> result = createBasket(gifts);
        Helper.printResult(result);
    }

    public void setSeason(String season) {
        seasonService = new SeasonService(SeasonsEnum.valueOf(season));
    }

    public List<Gift> createBasket(String[] unparsedGifts) {
        Gift[] gifts = Helper.formatIntoGiftArray(unparsedGifts);

        return createBasket(gifts);
    }

    public List<Gift> createBasket(Gift[] gifts) {
        return seasonService.createBasket(gifts);
    }

}
