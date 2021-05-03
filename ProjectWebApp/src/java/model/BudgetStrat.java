/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author bismuth
 */
public class BudgetStrat {
    private String stg_name;
    private double amount;
    private double percent;

    public String getStg_name() {
        return stg_name;
    }

    public void setStg_name(String stg_name) {
        this.stg_name = stg_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
