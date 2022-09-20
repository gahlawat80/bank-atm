package org.luv2code.bank.atm.app.model;

public class Registration {
    private int id;
    private String name;
    private int age;
    private String accountId;
    private int pin;
    private int confPin;

    public Registration(){}

    public Registration(String name, int age, String accountId, int pin, int confPin) {
        this.name = name;
        this.age = age;
        this.accountId = accountId;
        this.pin = pin;
        this.confPin = confPin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getConfPin() {
        return confPin;
    }

    public void setConfPin(int confPin) {
        this.confPin = confPin;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", accountId='" + accountId + '\'' +
                ", pin=" + pin +
                ", confPin=" + confPin +
                '}';
    }
}
