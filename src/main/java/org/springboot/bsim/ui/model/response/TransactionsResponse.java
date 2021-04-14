package org.springboot.bsim.ui.model.response;

import org.springboot.bsim.shared.dto.WalletsDTO;

import java.time.LocalDateTime;

public class TransactionsResponse {
    private WalletsDTO wallet;
    private String transactionsId;
    private String name;
    private Long amount;
    private LocalDateTime tanggal;
    private boolean isDeleted;

    public TransactionsResponse() {
    }

    public TransactionsResponse(WalletsDTO wallet, String transactionsId, String name, Long amount, LocalDateTime tanggal, boolean isDeleted) {
        this.wallet = wallet;
        this.transactionsId = transactionsId;
        this.name = name;
        this.amount = amount;
        this.tanggal = tanggal;
        this.isDeleted = isDeleted;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }
}
