package com.shoji.my_friends_show_list.infra.persistence.entities;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "MediaItemEntity")
@Table(name = "media_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recommendation_list_id", nullable = false)
    private RecommendationListEntity recommendationList;

    @NotBlank
    private String externalId;

    @Enumerated(EnumType.STRING)
    private MediaSource source;

}
