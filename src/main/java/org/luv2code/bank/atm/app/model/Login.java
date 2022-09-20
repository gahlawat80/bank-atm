package org.luv2code.bank.atm.app.model;

public class Login {
    private int id;
    private String accountId;
    private int pin;

    public Login(){}

    public Login(String accountId, int pin) {
        this.accountId = accountId;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", pin=" + pin +
                '}';
    }
}
