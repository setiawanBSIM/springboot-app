package org.springboot.bsim.service.impl;

import org.modelmapper.ModelMapper;
import org.springboot.bsim.io.entity.TransactionsEntity;
import org.springboot.bsim.io.entity.WalletsEntity;
import org.springboot.bsim.io.repository.TransactionsRepository;
import org.springboot.bsim.io.repository.WalletsRepository;
import org.springboot.bsim.service.iservice.ITransactionsService;
import org.springboot.bsim.shared.dto.TransactionsDTO;
import org.springboot.bsim.shared.dto.WalletsDTO;
import org.springboot.bsim.shared.utils.GenerateRandomPublicId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsServiceImpl implements ITransactionsService {

    private final TransactionsRepository transactionsRepository;
    private final GenerateRandomPublicId generateRandomPublicId;
    private final WalletsRepository walletsRepository;

    public TransactionsServiceImpl(TransactionsRepository transactionsRepository, GenerateRandomPublicId generateRandomPublicId, WalletsRepository walletsRepository) {
        this.transactionsRepository = transactionsRepository;
        this.generateRandomPublicId = generateRandomPublicId;
        this.walletsRepository = walletsRepository;
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
    public TransactionsDTO addTransactions(TransactionsDTO transactionsDTO, String walletId) {
        transactionsDTO.setTransactionsId(generateRandomPublicId.generateUserId(35));
        ModelMapper modelMapper = new ModelMapper();

        WalletsEntity walletsEntity = walletsRepository.findByWalletid(walletId);

        transactionsDTO.setWallet(modelMapper.map(walletsEntity, WalletsDTO.class));

        TransactionsEntity entity = modelMapper.map(transactionsDTO, TransactionsEntity.class);

        TransactionsEntity storedValue = transactionsRepository.save(entity);

        TransactionsDTO returnValue = modelMapper.map(storedValue, TransactionsDTO.class);

        return returnValue;
    }

    @Override
    public List<TransactionsDTO> getTransactionsByWalletId(String walletId) {
        WalletsEntity walletsEntity = walletsRepository.findByWalletid(walletId);

        List<TransactionsEntity> entities = transactionsRepository.findAllByWalletId(walletsEntity);

        ModelMapper modelMapper = new ModelMapper();

        List<TransactionsDTO> returnValue = new ArrayList<>();

        for (TransactionsEntity entity : entities) {
            returnValue.add(modelMapper.map(entity, TransactionsDTO.class));
        }

        return returnValue;
    }

    @Override
    public TransactionsDTO updateTransactions(TransactionsDTO transactionsDTO, String transactionsId, String walletId) {

        ModelMapper modelMapper = new ModelMapper();

        WalletsEntity walletsEntity = walletsRepository.findByWalletid(walletId);
        TransactionsEntity IdEntity = transactionsRepository.findIdByTransactionsId(transactionsId);

        TransactionsEntity entity = modelMapper.map(transactionsDTO, TransactionsEntity.class);
        entity.setTransactionsId(transactionsId);
        entity.setWalletId(walletsEntity);
        entity.setId(IdEntity.getId());

        TransactionsEntity updatedValue = transactionsRepository.save(entity);

        TransactionsDTO returnValue = modelMapper.map(updatedValue, TransactionsDTO.class);

        return returnValue;
    }

    @Override
    public TransactionsDTO deleteTransactions(String walletId, String transactionsId) {

        WalletsEntity walletsEntity = walletsRepository.findByWalletid(walletId);

        TransactionsEntity transactionsEntity = transactionsRepository.findIdByTransactionsId(transactionsId);
        transactionsEntity.setWalletId(walletsEntity);
        transactionsEntity.setDeleted(true);

        TransactionsEntity storeValue = transactionsRepository.save(transactionsEntity);

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(storeValue, TransactionsDTO.class);
    }


}
