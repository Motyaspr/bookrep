package com.motyaspr.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(of = {"isbn", "uuid"}, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private Integer uuid;
    private String name;
    private @NotBlank String isbn;
    private @NotBlank String author;
    private @NotNull LocalDate releaseDate;
}
