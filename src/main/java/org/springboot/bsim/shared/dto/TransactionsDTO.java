package org.springboot.bsim.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionsDTO implements Serializable {
    private static final long serialVersionUID = 9067772810151137938L;
    private long WalletId;
    private String transactionsId;
    private LocalDateTime tanggal;
    private long amount;
    private String name;
    private long id;

    public TransactionsDTO() {
    }

    public TransactionsDTO(long walletId, String transactionsId, LocalDateTime tanggal, long amount, String name, long id) {
        WalletId = walletId;
        this.transactionsId = transactionsId;
        this.tanggal = tanggal;
        this.amount = amount;
        this.name = name;
        this.id = id;
    }

    public long getWalletId() {
        return WalletId;
    }

    public void setWalletId(long walletId) {
        WalletId = walletId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionsDTO that = (TransactionsDTO) o;
        return WalletId == that.WalletId && amount == that.amount && id == that.id && Objects.equals(transactionsId, that.transactionsId) && Objects.equals(tanggal, that.tanggal) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(WalletId, transactionsId, tanggal, amount, name, id);
    }

    @Override
    public String toString() {
        return "TransactionsDTO{" +
                "WalletId=" + WalletId +
                ", transactionsId='" + transactionsId + '\'' +
                ", tanggal=" + tanggal +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
