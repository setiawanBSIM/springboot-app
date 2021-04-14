package org.springboot.bsim.ui.model.response;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionsResponse {
    private Long WalletId;
    private String transactionsId;
    private String name;
    private Long amount;
    private LocalDateTime tanggal;

    public TransactionsResponse() {
    }

    public TransactionsResponse(Long walletId, String transactionsId, String name, Long amount, LocalDateTime tanggal) {
        WalletId = walletId;
        this.transactionsId = transactionsId;
        this.name = name;
        this.amount = amount;
        this.tanggal = tanggal;
    }

    public Long getWalletId() {
        return WalletId;
    }

    public void setWalletId(Long walletId) {
        WalletId = walletId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionsResponse that = (TransactionsResponse) o;
        if(!transactionsId.equals(that.transactionsId)) return false;
        return transactionsId == that.transactionsId && Objects.equals(WalletId, that.WalletId) && Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(tanggal, that.tanggal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(WalletId, transactionsId, name, amount, tanggal);
    }
}
