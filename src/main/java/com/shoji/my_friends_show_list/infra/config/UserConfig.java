package com.shoji.my_friends_show_list.infra.config;

import com.shoji.my_friends_show_list.application.gateways.UserGateway;
import com.shoji.my_friends_show_list.application.usecases.user.CreateUser;
import com.shoji.my_friends_show_list.application.usecases.user.GetAllUser;
import com.shoji.my_friends_show_list.application.usecases.user.GetUserById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(UserGateway userGateway) {
        return new CreateUser(userGateway);
    }

    @Bean
    GetAllUser getAllUser(UserGateway userGateway) {
        return new GetAllUser(userGateway);
    }

    @Bean
    GetUserById getUserById(UserGateway userGateway) {
        return new GetUserById(userGateway);
    }

}
