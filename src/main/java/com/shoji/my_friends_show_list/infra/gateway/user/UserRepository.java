package com.shoji.my_friends_show_list.infra.gateway.user;

import com.shoji.my_friends_show_list.application.gateways.UserGateway;
import com.shoji.my_friends_show_list.domain.models.user.User;
import com.shoji.my_friends_show_list.infra.persistence.converters.mappers.UserMapper;
import com.shoji.my_friends_show_list.infra.persistence.entities.UserEntity;
import com.shoji.my_friends_show_list.infra.persistence.repository.UserRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class UserRepository implements UserGateway {

    private final UserRepositoryJpa jpaRepository;
    private final UserMapper userMapper;

    public UserRepository(UserRepositoryJpa jpaRepository, UserMapper userMapper) {
        this.jpaRepository = jpaRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity createdEntity = jpaRepository.save(userMapper.toEntity(user));

        return userMapper.toDomain(createdEntity);
    }

    @Override
    public List<User> getAllUsers() {
        return jpaRepository.findAll().stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return jpaRepository.findById(id).map(userMapper::toDomain);
    }


}
