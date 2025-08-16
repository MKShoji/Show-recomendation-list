package com.shoji.my_friends_show_list.infra.config;

import com.shoji.my_friends_show_list.application.gateways.MediaGateway;
import com.shoji.my_friends_show_list.application.usecases.media.GetMidiaByExternalId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediaConfig {

    @Bean
    GetMidiaByExternalId getMidiaByExternalId(MediaGateway mediaGateway) {return new GetMidiaByExternalId(mediaGateway);}

}
