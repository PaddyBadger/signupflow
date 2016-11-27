package com.betterment.signupflow.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class SignupAttributes implements Serializable {
    private static final long serialVersionUID = 2182634875940935074L;

    private String email;
    private int userAge;
    private BigDecimal userIncome;
    private int userRetirementAge;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserIncome(BigDecimal userIncome) {
        this.userIncome = userIncome;
    }

    public void setUserRetirementAge(int userRetirementAge) {
        this.userRetirementAge = userRetirementAge;
    }
}
