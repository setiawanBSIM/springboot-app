package org.springboot.bsim.io.repository;

import org.springboot.bsim.io.entity.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {
    List<TransactionsEntity> findAllByWalletId(long walletId);
}
