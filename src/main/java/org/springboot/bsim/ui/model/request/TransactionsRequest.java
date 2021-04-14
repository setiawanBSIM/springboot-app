package org.springboot.bsim.ui.model.request;

import java.time.LocalDateTime;

public class TransactionsRequest {

    private LocalDateTime tanggal;
    private long amount;
    private String name;
    private boolean isDeleted;

    public TransactionsRequest() {
    }

    public TransactionsRequest(LocalDateTime tanggal, long amount, String name, boolean isDeleted) {
        this.tanggal = tanggal;
        this.amount = amount;
        this.name = name;
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
