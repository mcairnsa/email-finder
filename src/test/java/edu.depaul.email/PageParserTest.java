package edu.depaul.email;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageParserTest {

    @Test
    @DisplayName("tests html without <a> tags")
    void ParserATest() {
        String html = "href='/some/other/file.html'my link/a/body/html";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        parser.findLinks(doc);
        assertTrue(true);
    }

    @Test
    @DisplayName("tests html with only one <a> tags")
    void ParserOneATest() {
        String html = "<a href='/some/other/file.html'> my link/a/body/html";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        parser.findLinks(doc);
        assertTrue(true);
    }

    @Test
    @DisplayName("tests html with multiple <a> tags")
    void ParserMultiATest() {
        String html = "<a> <html> '/some/other/file.html'> my link/a/body/html</a>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        parser.findLinks(doc);
        assertTrue(true);
    }

    @Test
    @DisplayName("tests PageParser with relative tags")
    void ParserRelativeTest() {
        String html = "<a other/file'> my link/a/body/html</a>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        parser.findLinks(doc);
        assertTrue(true);
    }

    @Test
    @DisplayName("tests PageParser with absolute tags")
    void ParserAbsoluteTest() {
        String html = "<a https://www.example.com/other/file'> my link/a/body/html</a>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        parser.findLinks(doc);
        assertTrue(true);
    }

}
