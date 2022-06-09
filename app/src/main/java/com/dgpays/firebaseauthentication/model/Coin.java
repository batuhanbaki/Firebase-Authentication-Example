package com.dgpays.firebaseauthentication.model;

public class Coin {
    private String id;
    private String coin;
    private String name;
    private String type;
    private String algorithm;
    private Double network_hashrate;
    private double difficulty;
    private double reward;
    private String reward_unit;
    private double reward_block;
    private double price;
    private double volume;
    private int updated;

    public Coin(String id, String coin, String name, String type, String algorithm, Double network_hashrate, double difficulty, double reward, String reward_unit, double reward_block, double price, double volume, int updated) {
        this.id = id;
        this.coin = coin;
        this.name = name;
        this.type = type;
        this.algorithm = algorithm;
        this.network_hashrate = network_hashrate;
        this.difficulty = difficulty;
        this.reward = reward;
        this.reward_unit = reward_unit;
        this.reward_block = reward_block;
        this.price = price;
        this.volume = volume;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Double getNetwork_hashrate() {
        return network_hashrate;
    }

    public void setNetwork_hashrate(Double network_hashrate) {
        this.network_hashrate = network_hashrate;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public String getReward_unit() {
        return reward_unit;
    }

    public void setReward_unit(String reward_unit) {
        this.reward_unit = reward_unit;
    }

    public double getReward_block() {
        return reward_block;
    }

    public void setReward_block(double reward_block) {
        this.reward_block = reward_block;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }
}
