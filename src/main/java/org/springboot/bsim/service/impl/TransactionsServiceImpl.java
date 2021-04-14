package org.springboot.bsim.service.impl;

import org.modelmapper.ModelMapper;
import org.springboot.bsim.io.entity.TransactionsEntity;
import org.springboot.bsim.io.repository.TransactionsRepository;
import org.springboot.bsim.service.iservice.ITransactionsService;
import org.springboot.bsim.shared.dto.TransactionsDTO;
import org.springboot.bsim.shared.utils.GenerateRandomPublicId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsServiceImpl implements ITransactionsService {

    private final TransactionsRepository transactionsRepository;
    private final GenerateRandomPublicId generateRandomPublicId;

    public TransactionsServiceImpl(TransactionsRepository transactionsRepository, GenerateRandomPublicId generateRandomPublicId) {
        this.transactionsRepository = transactionsRepository;
        this.generateRandomPublicId = generateRandomPublicId;
    }

    @Override
    public List<TransactionsDTO> getListTransactions() {
        List<TransactionsDTO> returnValue = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        List<TransactionsEntity> transactions = transactionsRepository.findAll();

        for (TransactionsEntity entity : transactions) {
            returnValue.add(modelMapper.map(entity, TransactionsDTO.class));
        }

        return returnValue;
    }

    @Override
    public TransactionsDTO addTransactions(TransactionsDTO transactionsDTO) {
        transactionsDTO.setTransactionsId(generateRandomPublicId.generateUserId(35));


        System.out.println(transactionsDTO.toString());

        ModelMapper modelMapper = new ModelMapper();

        TransactionsEntity entity = modelMapper.map(transactionsDTO, TransactionsEntity.class);
        System.out.println(entity.toString());

        TransactionsEntity storedValue = transactionsRepository.save(entity);

        TransactionsDTO returnValue = modelMapper.map(storedValue, TransactionsDTO.class);

        return returnValue;
    }

    @Override
    public List<TransactionsDTO> getTransactionsByWalletId(long walletId) {
        List<TransactionsEntity> entities = transactionsRepository.findAllByWalletId(walletId);

        ModelMapper modelMapper = new ModelMapper();

        List<TransactionsDTO> returnValue = new ArrayList<>();

        for (TransactionsEntity entity : entities) {
            returnValue.add(modelMapper.map(entity, TransactionsDTO.class));
        }

        return returnValue;
    }

    @Override
    public TransactionsDTO updateTransactions(TransactionsDTO transactionsDTO, String transactionsId) {

        ModelMapper modelMapper = new ModelMapper();

        TransactionsEntity entity = modelMapper.map(transactionsDTO, TransactionsEntity.class);
        entity.setTransactionsId(transactionsId);

        TransactionsEntity updatedValue = transactionsRepository.save(entity);

        TransactionsDTO returnValue = modelMapper.map(updatedValue, TransactionsDTO.class);

        return returnValue;
    }


}
