package org.springboot.bsim.io.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class TransactionsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String transactionsId;

    private String name;

    @Column(name = "wallet_id")
    private long walletId;

    private long amount;

    private LocalDateTime tanggal;

    public TransactionsEntity() {
    }

    public TransactionsEntity(long id, String transactionsId, String name, long walletId, long amount, LocalDateTime tanggal) {
        this.id = id;
        this.transactionsId = transactionsId;
        this.name = name;
        this.walletId = walletId;
        this.amount = amount;
        this.tanggal = tanggal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
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
        TransactionsEntity entity = (TransactionsEntity) o;
        if (id != entity.id) return false;
        if (!transactionsId.equals(entity.transactionsId)) return false;
        return id == entity.id && walletId == entity.walletId && amount == entity.amount && Objects.equals(transactionsId, entity.transactionsId) && Objects.equals(name, entity.name) && Objects.equals(tanggal, entity.tanggal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionsId, name, walletId, amount, tanggal);
    }

    @Override
    public String toString() {
        return "TransactionsEntity{" +
                "id=" + id +
                ", transactionsId='" + transactionsId + '\'' +
                ", name='" + name + '\'' +
                ", walletId=" + walletId +
                ", amount=" + amount +
                ", tanggal=" + tanggal +
                '}';
    }
}
