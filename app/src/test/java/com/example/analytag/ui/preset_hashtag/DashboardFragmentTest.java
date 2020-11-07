package com.example.analytag.ui.preset_hashtag;

import org.junit.Test;

import java.util.List;


class DashboardFragmentTest {

    private PresetFragment testObj;

    @Test
    void popularHashtag() {
        List test;
        test = testObj.popularHashtag();
    }

    @Test
    void hastagCategories() {
        List test;
        test = testObj.hastagCategories(testObj.getHashtagCategories());
    }
}