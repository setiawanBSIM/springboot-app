package org.springboot.bsim.ui.model.request;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionsRequest {

    private long walletId;
    private LocalDateTime tanggal;
    private long amount;
    private String name;

    public TransactionsRequest() {
    }

    public TransactionsRequest(long walletId, LocalDateTime tanggal, long amount, String name) {
        this.walletId = walletId;
        this.tanggal = tanggal;
        this.amount = amount;
        this.name = name;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionsRequest that = (TransactionsRequest) o;
        return walletId == that.walletId && amount == that.amount && Objects.equals(tanggal, that.tanggal) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletId, tanggal, amount, name);
    }

    @Override
    public String toString() {
        return "TransactionsRequest{" +
                "walletId=" + walletId +
                ", tanggal=" + tanggal +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
