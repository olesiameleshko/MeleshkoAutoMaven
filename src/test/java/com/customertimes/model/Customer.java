package com.customertimes.model;

public class Customer {
    private String email;
    private String password;
    private String twoFA;
    private String answerReg;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getTwoFA() {

        return twoFA;
    }

    public void setTwoFA(String twoFA) {

        this.twoFA = twoFA;
    }

    public String getAnswerReg() {

        return answerReg;
    }

    public void setAnswerReg(String answerReg) {

        this.answerReg = answerReg;
    }

    public static Builder newBuilder() {

        return new Builder();
    }

    public Customer() {
    }

    private Customer(final Builder builder) {
        email = builder.email;
        password = builder.password;
        twoFA = builder.twoFA;
        answerReg = builder.answerReg;
    }

    public static final class Builder {
        private String email;
        private String password;
        private String twoFA;
        private String answerReg;

        private Builder() {
        }

        public Builder withName(final String val) {
            email = val;
            return this;
        }

        public Builder withPassword(final String val) {
            password = val;
            return this;
        }

        public Builder withTwoFA(final String val) {
            twoFA = val;
            return this;
        }

        public Builder withAnswerReg(final String val) {
            answerReg = val;
            return this;
        }

        public Customer build() {

            return new Customer(this);
        }
    }
}
