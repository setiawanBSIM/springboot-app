package org.springboot.bsim.shared.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 9067772810151137938L;
    private long id;
    private String userId;
    private String userName;
    private List<WalletsDTO> wallets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<WalletsDTO> getWallets() {
        return wallets;
    }

    public void setWallets(List<WalletsDTO> wallets) {
        this.wallets = wallets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (id != userDTO.id) return false;
        if (!userId.equals(userDTO.userId)) return false;
        if (!userName.equals(userDTO.userName)) return false;
        return wallets != null ? wallets.equals(userDTO.wallets) : userDTO.wallets == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + userId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + (wallets != null ? wallets.hashCode() : 0);
        return result;
    }
}
