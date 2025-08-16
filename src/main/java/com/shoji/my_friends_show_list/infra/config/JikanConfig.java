package com.shoji.my_friends_show_list.infra.config;

import net.sandrohc.jikan.Jikan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JikanConfig {

    @Bean
    public Jikan jikan() {
        return new Jikan.JikanBuilder().build();
    }
}
