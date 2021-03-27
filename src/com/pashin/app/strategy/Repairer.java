package com.pashin.app.strategy;

import com.pashin.app.strategy.impl.DOMAnalyzer;

import java.io.File;

public class Repairer {

    private AnalyzeStrategy analyzeStrategy;

    public Repairer() {
        analyzeStrategy = new DOMAnalyzer();
    }

    public void setAnalyzeStrategy(AnalyzeStrategy analyzeStrategy) {
        this.analyzeStrategy = analyzeStrategy;
    }

    public void repair(String fileName1, String fileName2) {
        analyzeStrategy.repair(new File("src/com/pashin/resources/" + fileName1), new File("src/com/pashin/resources/" + fileName2));
    }
}
