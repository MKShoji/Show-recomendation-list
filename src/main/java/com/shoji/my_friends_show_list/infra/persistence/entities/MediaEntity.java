package com.shoji.my_friends_show_list.infra.persistence.entities;

import com.shoji.my_friends_show_list.domain.enums.MediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date releaseDate;
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;
}
