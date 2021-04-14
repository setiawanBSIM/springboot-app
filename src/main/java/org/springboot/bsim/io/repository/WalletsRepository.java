package org.springboot.bsim.io.repository;

import org.springboot.bsim.io.entity.UserEntity;
import org.springboot.bsim.io.entity.WalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface WalletsRepository extends JpaRepository<WalletsEntity, Long> {
    WalletsEntity findByWalletid(String Walletid);
    List<WalletsEntity> findByUser(UserEntity userEntity);
}
