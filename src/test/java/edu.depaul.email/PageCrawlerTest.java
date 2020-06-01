package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageCrawlerTest {

    @ParameterizedTest(name = "test Email PageCrawler")
    @MethodSource("EmailParamInput")
    @DisplayName("Tests the different outcomes for emails in PageCrawler")
    void compareEmailCrawlerTest(int max, String url) {
        PageCrawler x = new PageCrawler(new StorageService(), max);
        x.crawl(url);
        assertEquals(x.getEmails().size(), max);

    }

    private static Stream<Arguments> EmailParamInput() {
        return Stream.of (
            Arguments.of(1, "http://cdm.depaul.edu"),   // max of 17 emails for this URL
            Arguments.of(5, "http://cdm.depaul.edu"),   // 5 and 15 fail since emails in Parser adds all the new emails before checking and
            Arguments.of(15, "http://cdm.depaul.edu")   // comparing to max email again.  It works with 1 since it checks it for the first email
        );                                              // but anything more is just not properly compared before new emails get added.
    }

    @ParameterizedTest(name = "test GoodLinks in PageCrawler")
    @MethodSource("goodLinkInput")
    @DisplayName("Tests the functionality of getGoodLinks in PageCrawler")
    void compareGoodLinksCrawlerTest(int num, String url) {
        PageCrawler x = new PageCrawler(new StorageService());
        x.crawl(url);
        assertEquals(x.getGoodLinks().size(), num);
    }

    private static Stream<Arguments> goodLinkInput() {
        return Stream.of (
             Arguments.of(1, "EmailFindDoc.txt"),
             Arguments.of(14, "http://cdm.depaul.edu")
        );
    }

    @ParameterizedTest(name = "test BadLinks in PageCrawler")
    @MethodSource("badLinkInput")
    @DisplayName("Tests the functionality of getBadLinks in PageCrawler")
    void compareBadLinkCrawlwerTest(int num, String url) {
        PageCrawler x = new PageCrawler(new StorageService());
        x.crawl(url);
        assertEquals(x.getBadLinks().size(), num);
    }

    private static Stream<Arguments> badLinkInput() {
        return Stream.of (
            Arguments.of(5, "http://cdm.depaul.edu"),
            Arguments.of(329, "http://depaul.edu")
        );
    }

}
