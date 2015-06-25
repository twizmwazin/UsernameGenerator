package me.electroid.nicknamer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Random;

public class GeneratorUtil {

    public static final int MIN_USERNAME_LENGTH = 4;
    public static final int[] OCN_PUNISHMENT_RANGE = {1000, 10000};
    public static final String OCN_PUNISHMENT_PAGE = "http://oc.tc/punishments?page=";

    /**
     * Get a banned user from Overcast Network's punishments page.
     * @return The banned username.
     */
    public static String getSeedFromOcn() {
        /** Backup username in the event of any errors. */
        String seed = "_creeperNoob";
        try {
            Document doc = Jsoup.connect(OCN_PUNISHMENT_PAGE + randomWithinRange(OCN_PUNISHMENT_RANGE[0], OCN_PUNISHMENT_RANGE[1])).get();
            seed = doc.select("tbody").first().select("td").get(1).select("a").attr("href");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return seed.substring(1, seed.length());
    }

    public static int random(int range) {
        if (range != 0)
            return new Random().nextInt(range);
        return 0;
    }

    public static int randomWithinRange(int start, int end) {
        return new Random().nextInt(end - start) + start;
    }

}
