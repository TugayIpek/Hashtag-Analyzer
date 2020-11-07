package com.example.analytag.ui.search;

import org.junit.Test;

import java.util.List;


class SearchFragmentTest {

    private SearchFragment testObj;

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