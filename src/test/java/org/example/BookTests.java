package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
public class BookTests {

    @Autowired
    private Book actualBook;

    @Test
    @DisplayName("Fetch the book bean from the context")
    public void fetchBookBean() {
        Book expectedBook = new Book("One Hundred Years of Solitude");

        assertEquals(expectedBook, actualBook);
    }
}
