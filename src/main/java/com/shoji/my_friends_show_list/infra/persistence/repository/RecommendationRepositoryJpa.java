package com.shoji.my_friends_show_list.infra.persistence.repository;

import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepositoryJpa extends JpaRepository<RecommendationListEntity, Long> {

    List<RecommendationListEntity> findByOwner_Id(Long ownerId);

}
