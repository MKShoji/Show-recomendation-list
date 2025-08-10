package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.user.User;
import com.shoji.my_friends_show_list.infra.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImp implements UserMapper {

    @Override
    public User toDomain(UserEntity entity) {
        if (entity == null) return null;

        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getAlias(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCreatedDate(),
                entity.getPhone(),
                entity.getProfileUrl()
        );
    }

    @Override
    public UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.id());
        entity.setUsername(user.username());
        entity.setAlias(user.alias());
        entity.setEmail(user.email());
        entity.setPassword(user.password());
        entity.setCreatedDate(user.createdDate());
        entity.setPhone(user.phone());
        entity.setProfileUrl(user.profileUrl());

        return entity;
    }
}
