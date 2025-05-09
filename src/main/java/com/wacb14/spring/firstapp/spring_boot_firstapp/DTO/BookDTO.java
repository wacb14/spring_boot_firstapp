package com.wacb14.spring.firstapp.spring_boot_firstapp.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO {

    private Integer id;
    private String title, editorial, genre;
    private BigDecimal price;
    private LocalDate dataEdition;
    private AuthorDTO authorDTO;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.editorial = book.getEditorial();
        this.genre = book.getGenre();
        this.price = book.getPrice();
        this.dataEdition = book.getDataEdition();
        this.authorDTO = new AuthorDTO(book.getAuthor());
    }

}
