package org.springboot.bsim.shared.dto;

import java.io.Serializable;

public class WalletsDTO implements Serializable {
    private static final long serialVersionUID = 3107995444826958911L;
    private long id;
    private String walletID;
    private String name;
    private long balance;
    private String noHP;
    private UserDTO user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletsDTO that = (WalletsDTO) o;

        if (id != that.id) return false;
        if (balance != that.balance) return false;
        if (!walletID.equals(that.walletID)) return false;
        if (!name.equals(that.name)) return false;
        if (!noHP.equals(that.noHP)) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + walletID.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        result = 31 * result + noHP.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
