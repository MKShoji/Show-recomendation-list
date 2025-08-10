package com.shoji.my_friends_show_list.infra.persistence.repository;

import com.shoji.my_friends_show_list.infra.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {


}
