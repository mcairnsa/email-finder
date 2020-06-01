package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorageServiceTest {

    @Test
    @DisplayName("tests that addLocation() and storeList() work properly, sent to email.txt")
    void StorageServiceLocationTest() {
       StorageService x = new StorageService();
       ArrayList<String> lst = new ArrayList<String>();
       lst.add("HelloWorld@gmail.com");
       lst.add("testTEST@msn.com");
       lst.add("HiThere@aol.com");
       lst.add("_-o_o-_@yahoo.com");
       x.addLocation(StorageService.StorageType.EMAIL ,"email.txt");
       x.storeList(StorageService.StorageType.EMAIL, lst);
       assertTrue(true);
    }

    @Test
    @DisplayName("tests that addLocation() and storeList() send error messages when path isn't valid")
    void StorageServiceFailTest() {
        StorageService x = new StorageService();
        ArrayList<String> lst = new ArrayList<String>();
        lst.add(":(.email.com");
        lst.add("D:.notarealemail.com");
        x.addLocation(StorageService.StorageType.EMAIL ,"email-finder/falsePath");
        assertThrows(edu.depaul.email.EmailFinderException.class, () -> new StorageService().storeList(StorageService.StorageType.EMAIL, lst));
    }

}
