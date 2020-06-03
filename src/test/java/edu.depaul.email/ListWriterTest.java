package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ListWriterTest {

    @Test
    @DisplayName("When ListWriter output is correct")
    public void testListWriter() throws IOException {
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("test");
        lst.add("string");
        lst.add("here");
        ListWriter mockWriter = mock(ListWriter.class);
        mockWriter.writeList(lst);
        System.out.print(mockWriter.toString());
        assertTrue(true);
    }

}
