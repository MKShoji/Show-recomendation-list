package com.shoji.my_friends_show_list.infra.persistence.repository;

import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepositoryJpa extends JpaRepository<RecommendationListEntity, Long> {
}
