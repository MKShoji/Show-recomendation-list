package com.shoji.my_friends_show_list.infra.persistence.repository;

import com.shoji.my_friends_show_list.infra.persistence.entities.MediaItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaItemJpa extends JpaRepository<MediaItemEntity, Long> {
}
