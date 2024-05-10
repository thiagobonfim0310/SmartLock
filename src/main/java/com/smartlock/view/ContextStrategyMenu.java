package com.smartlock.view;

public class ContextStrategyMenu {
    private StrategyMenu strategy;

    public void setStrategy(StrategyMenu strategy) {
        this.strategy = strategy;
    }

    public void excuteStrategy() {
        strategy.execute();
    }
}
