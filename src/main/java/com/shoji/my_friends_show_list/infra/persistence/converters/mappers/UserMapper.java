package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.user.User;
import com.shoji.my_friends_show_list.infra.persistence.entities.UserEntity;

public interface UserMapper {
    User toDomain(UserEntity entity);
    UserEntity toEntity(User user);
}
