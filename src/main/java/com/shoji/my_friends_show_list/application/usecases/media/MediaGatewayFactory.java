package com.shoji.my_friends_show_list.application.usecases.media;

import com.shoji.my_friends_show_list.application.gateways.MediaGatewayStrategy;
import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MediaGatewayFactory {

    private final List<MediaGatewayStrategy> strategies;

    public MediaGatewayFactory(List<MediaGatewayStrategy> strategies) {
        this.strategies = strategies;
    }

    public MediaGatewayStrategy exceute(MediaSource source) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(source))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No gateway found for type: " + source));
    }
}
