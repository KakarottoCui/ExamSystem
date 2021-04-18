package com.exam.entity;

public class Times {
    private Integer timesId;

    private Integer testpaperId;

    private String userId;

    private Double dataMin;

    private Integer timesState;

    public Integer getTimesId() {
        return timesId;
    }

    public void setTimesId(Integer timesId) {
        this.timesId = timesId;
    }

    public Integer getTestpaperId() {
        return testpaperId;
    }

    public void setTestpaperId(Integer testpaperId) {
        this.testpaperId = testpaperId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Double getDataMin() {
        return dataMin;
    }

    public void setDataMin(Double dataMin) {
        this.dataMin = dataMin;
    }

    public Integer getTimesState() {
        return timesState;
    }

    public void setTimesState(Integer timesState) {
        this.timesState = timesState;
    }
}