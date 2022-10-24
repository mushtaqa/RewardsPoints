package com.mushtaq.reward.point.model.response;

import java.util.Objects;

public class Rewards {
    private long customerId;
    private long lastMonthRewardPoints;
    private long lastSecondMonthRewardPoints;
    private long lastThirdMonthRewardPoints;
    private long totalRewards;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getLastMonthRewardPoints() {
        return lastMonthRewardPoints;
    }

    public void setLastMonthRewardPoints(long lastMonthRewardPoints) {
        this.lastMonthRewardPoints = lastMonthRewardPoints;
    }

    public long getLastSecondMonthRewardPoints() {
        return lastSecondMonthRewardPoints;
    }

    public void setLastSecondMonthRewardPoints(long lastSecondMonthRewardPoints) {
        this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
    }

    public long getLastThirdMonthRewardPoints() {
        return lastThirdMonthRewardPoints;
    }

    public void setLastThirdMonthRewardPoints(long lastThirdMonthRewardPoints) {
        this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
    }

    public long getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(long totalRewards) {
        this.totalRewards = totalRewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return customerId == rewards.customerId && lastMonthRewardPoints == rewards.lastMonthRewardPoints && lastSecondMonthRewardPoints == rewards.lastSecondMonthRewardPoints && lastThirdMonthRewardPoints == rewards.lastThirdMonthRewardPoints && totalRewards == rewards.totalRewards;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, lastMonthRewardPoints, lastSecondMonthRewardPoints, lastThirdMonthRewardPoints, totalRewards);
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "customerId=" + customerId +
                ", lastMonthRewardPoints=" + lastMonthRewardPoints +
                ", lastSecondMonthRewardPoints=" + lastSecondMonthRewardPoints +
                ", lastThirdMonthRewardPoints=" + lastThirdMonthRewardPoints +
                ", totalRewards=" + totalRewards +
                '}';
    }
}
