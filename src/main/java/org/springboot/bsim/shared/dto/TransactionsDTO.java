package org.springboot.bsim.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TransactionsDTO implements Serializable {
    private static final long serialVersionUID = 9067772810151137938L;
    private WalletsDTO wallet;
    private String transactionsId;
    private LocalDateTime tanggal;
    private long amount;
    private String name;
    private long id;
    private boolean isDeleted;

    public TransactionsDTO() {
    }

    public TransactionsDTO(WalletsDTO wallet, String transactionsId, LocalDateTime tanggal, long amount, String name, long id, boolean isDeleted) {
        this.wallet = wallet;
        this.transactionsId = transactionsId;
        this.tanggal = tanggal;
        this.amount = amount;
        this.name = name;
        this.id = id;
        this.isDeleted = isDeleted;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public WalletsDTO getWallet() {
        return wallet;
    }

    public void setWallet(WalletsDTO wallet) {
        this.wallet = wallet;
    }

    public String getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(String transactionsId) {
        this.transactionsId = transactionsId;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

