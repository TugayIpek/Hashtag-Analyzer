package com.example.analytag.ui.notifications;

import org.junit.Test;

import java.util.List;


class NotificationsFragmentTest {

    private NotificationsFragment testObj;
    @Test
    void hashtagHistory() {
        List test;
        test = testObj.hashtagHistory("twitter");
    }

    @Test
    void hashtagFavorite() {
        List test;
        test = testObj.hashtagFavorite("twitter");
    }
}