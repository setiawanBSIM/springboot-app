package org.springboot.bsim.service.iservice;

import org.springboot.bsim.shared.dto.TransactionsDTO;

import java.util.List;


public interface ITransactionsService {
    List<TransactionsDTO> getListTransactions();

    TransactionsDTO addTransactions(TransactionsDTO transactionsDTO, String walletId);

    List<TransactionsDTO> getTransactionsByWalletId(String walletId);


    TransactionsDTO updateTransactions(TransactionsDTO transactionsDTO, String transactionsId, String walletId);

    TransactionsDTO deleteTransactions(String walletId, String transactionsId);
}
