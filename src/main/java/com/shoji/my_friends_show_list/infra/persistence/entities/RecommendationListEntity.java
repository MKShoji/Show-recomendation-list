package com.shoji.my_friends_show_list.infra.persistence.entities;

import com.shoji.my_friends_show_list.domain.enums.ListVisibility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "RecommendationListEntity")
@Table(name = "recommendation_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;
    private String name;

    @OneToMany(mappedBy = "recommendationList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaItemEntity> mediasReferences;

    @Enumerated(EnumType.STRING)
    private ListVisibility visibility;
    private LocalDateTime createdAt;
}
