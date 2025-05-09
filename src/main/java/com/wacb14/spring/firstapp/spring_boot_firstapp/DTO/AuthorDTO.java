package com.wacb14.spring.firstapp.spring_boot_firstapp.DTO;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Author;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {
    private Integer id;
    private String name, lastName, phone;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.lastName = author.getLastName();
        this.phone = author.getPhone();
    }
}
