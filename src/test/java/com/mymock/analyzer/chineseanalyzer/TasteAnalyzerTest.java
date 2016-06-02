package com.mymock.analyzer.chineseanalyzer;

import java.io.IOException;

import org.junit.Test;

public class TasteAnalyzerTest {

    @Test
    public void t() throws IOException {
        TasteAnalyzer ta = new TasteAnalyzer();
        ta.taste();
    }
}
