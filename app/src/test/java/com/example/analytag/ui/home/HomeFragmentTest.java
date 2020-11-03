package com.example.analytag.ui.home;

import com.example.analytag.ui.dashboard.DashboardFragment;

import org.junit.Test;

import java.util.List;


class HomeFragmentTest {

    private HomeFragment testObj;

    @Test
    void searchHashtag() {
        List test;
        test = testObj.searchHashtag("twitter");
    }

    @Test
    void analyzerHashtag() {
        List test;
        test = testObj.analyzerHashtag(testObj.getHashtagData());
    }

    @Test
    void relatedHashtag() {
        List test;
        test = testObj.relatedHashtag("twitter");
    }
}