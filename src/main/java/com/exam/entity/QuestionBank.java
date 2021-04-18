package com.exam.entity;

public class QuestionBank {
    private Integer questionBankId;

    private String answer;

    private Integer testsType;

    private Integer state;

    private String stem;

    public Integer getQuestionBankId() {
        return questionBankId;
    }

    public void setQuestionBankId(Integer questionBankId) {
        this.questionBankId = questionBankId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getTestsType() {
        return testsType;
    }

    public void setTestsType(Integer testsType) {
        this.testsType = testsType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem == null ? null : stem.trim();
    }
}