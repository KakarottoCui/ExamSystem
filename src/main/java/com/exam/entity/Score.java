package com.exam.entity;

public class Score {
    private Integer scoreId;

    private String usersId;

    private Integer testpaperId;

    private Double fraction;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId == null ? null : usersId.trim();
    }

    public Integer getTestpaperId() {
        return testpaperId;
    }

    public void setTestpaperId(Integer testpaperId) {
        this.testpaperId = testpaperId;
    }

    public Double getFraction() {
        return fraction;
    }

    public void setFraction(Double fraction) {
        this.fraction = fraction;
    }

    
    
}