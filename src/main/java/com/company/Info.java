package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Info {
    private String name;
    private Double quantity;
    private Double amount;
    private LocalDateTime date;

    public Info() {
        this.date = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStringDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
        return date.format(formatter);
    }

    @Override
    public String toString() {
        return name + " - " + quantity + " 💰" + amount + " so'm  📆" + getStringDate();
    }
}
