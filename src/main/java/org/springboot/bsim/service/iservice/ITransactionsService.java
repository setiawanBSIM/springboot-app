package org.springboot.bsim.service.iservice;

import org.springboot.bsim.shared.dto.TransactionsDTO;
import org.springboot.bsim.ui.model.request.TransactionsRequest;

import java.util.List;


public interface ITransactionsService {
    List<TransactionsDTO> getListTransactions();

    TransactionsDTO addTransactions(TransactionsDTO transactionsDTO);

    List<TransactionsDTO> getTransactionsByWalletId(long walletId);


    TransactionsDTO updateTransactions(TransactionsDTO transactionsDTO, String transactionsId);
}
