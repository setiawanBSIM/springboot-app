package org.springboot.bsim.io.entity;

import javax.persistence.*;

@Entity
@Table(name = "walletsTBL")
@SequenceGenerator(name="seqWALLETS", initialValue=100, allocationSize=50)
public class WalletsEntity {
    private static final long serialVersionUID = -6443015000729604312L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqWALLETS")
    private long id;

    @Column(nullable = false)
    private String walletid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long balance;

    @Column(nullable = false)
    private String nohp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWalletid() {
        return walletid;
    }

    public void setWalletid(String walletid) {
        this.walletid = walletid;
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

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletsEntity that = (WalletsEntity) o;

        if (id != that.id) return false;
        if (balance != that.balance) return false;
        if (!walletid.equals(that.walletid)) return false;
        if (!name.equals(that.name)) return false;
        if (!nohp.equals(that.nohp)) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + walletid.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        result = 31 * result + nohp.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
