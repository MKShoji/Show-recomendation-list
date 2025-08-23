package com.shoji.my_friends_show_list.domain.exceptions;

public class MediaNotFoundException extends RuntimeException {
    public MediaNotFoundException(String externalID) {
        super("Media with external ID " + externalID + "could not be found");
    }
}
