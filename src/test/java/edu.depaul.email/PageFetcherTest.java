package edu.depaul.email;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PageFetcherTest {

    @Test
    @DisplayName("tests PageFetcher throws an exception if the url is not valid")
    void PageFetcherInvalidTest() {
        PageFetcher x = new PageFetcher();
        assertThrows(edu.depaul.email.EmailFinderException.class, () -> new PageFetcher().get("notvalidurl"));
    }

    @Test
    @DisplayName("tests PageFetcher get function")
    void PageFetcherGetTest() {
        PageFetcher x = new PageFetcher();
        Document y = x.get("http://cdm.depaul.edu");
        assertEquals(y.title(), "CDM | DePaul CDM");
    }

    @Test
    @DisplayName("tests PageFetcher getString fucntion")
    void PageFetcherGetStringTest() {
        PageFetcher x = new PageFetcher();
        String y = x.getString("http://cdm.depaul.edu");
        assertEquals(y.length(), 81643);
    }

}
