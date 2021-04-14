package org.springboot.bsim.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userTBL")
@SequenceGenerator(name="seqUSR", initialValue=100, allocationSize=50)
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1012644246865096079L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUSR")
    private long id;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WalletsEntity> walletsentity = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<WalletsEntity> getWalletsentity() {
        return walletsentity;
    }

    public void setWalletsentity(List<WalletsEntity> walletsentity) {
        this.walletsentity = walletsentity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (!userid.equals(that.userid)) return false;
        if (!username.equals(that.username)) return false;
        return walletsentity != null ? walletsentity.equals(that.walletsentity) : that.walletsentity == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + userid.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + (walletsentity != null ? walletsentity.hashCode() : 0);
        return result;
    }
}
