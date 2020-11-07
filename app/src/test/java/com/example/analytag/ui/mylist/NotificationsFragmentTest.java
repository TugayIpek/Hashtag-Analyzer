package com.example.analytag.ui.mylist;

import org.junit.Test;

import java.util.List;


class mylistFragmentTest {

    private mylistFragment testObj;
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