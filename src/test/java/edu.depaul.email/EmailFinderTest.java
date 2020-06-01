package edu.depaul.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class EmailFinderTest {

    @Test
    @DisplayName("EmailFinder tests")
    void FinderTest() {
        EmailFinder x = new EmailFinder();
        String[] fileList = new String[] {"EmailFindDoc.txt"};
        String[] URLlst = new String[] {"http://cdm.depaul.edu"};
        assertAll( "EmailFinder assertions", () -> {
            System.out.println("trying EmailFinder with file");
            x.run(fileList);
            assertTrue(true);
            },
            () -> {
                System.out.println("trying EmailFinder with url");
                x.run(URLlst);
                assertTrue(true);
            },
            () -> {
                System.out.println("trying EmailFinder with null");
                assertThrows(NullPointerException.class, () -> new EmailFinder().run(null));
            },
            () -> {
                System.out.println("trying EmailFinder with empty string");
                x.run(new String[] {""});
                assertTrue(true);
             }

        );
    }

}
