package com.shoji.my_friends_show_list.domain.models.friendship;

public record Friendship (
        Long idUserSender,
        Long idUserReceiver,
        String status
) {

}
