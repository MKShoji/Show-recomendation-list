package com.shoji.my_friends_show_list.infra.persistence.repository;

import com.shoji.my_friends_show_list.domain.models.media.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
