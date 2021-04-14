package org.springboot.bsim.ui.model.request;

public class WalletRequest {
    private String name;
    private long balance;
    private String noHP;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletRequest that = (WalletRequest) o;

        if (balance != that.balance) return false;
        if (!name.equals(that.name)) return false;
        return noHP.equals(that.noHP);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        result = 31 * result + noHP.hashCode();
        return result;
    }
}
