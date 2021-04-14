package org.springboot.bsim.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springboot.bsim.io.entity.UserEntity;
import org.springboot.bsim.io.entity.WalletsEntity;
import org.springboot.bsim.io.repository.UserRepository;
import org.springboot.bsim.io.repository.WalletsRepository;
import org.springboot.bsim.service.iservice.IWalletsService;
import org.springboot.bsim.shared.dto.UserDTO;
import org.springboot.bsim.shared.dto.WalletsDTO;
import org.springboot.bsim.shared.utils.GenerateRandomPublicId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletsServiceImpl implements IWalletsService {
    @Autowired
    WalletsRepository walletsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public List<WalletsDTO> getAllWalletsData(String userID) {
        List<WalletsEntity> wallets = walletsRepository.findByUser(userRepository.findByUserid(userID));
        List<WalletsDTO> returnValue = new ModelMapper().map(wallets, new TypeToken<List<WalletsDTO>>(){}.getType());
        return returnValue;
    }

    @Override
    public long getTotalBalance(String userID) {
        List<WalletsEntity> wallets = walletsRepository.findByUser(userRepository.findByUserid(userID));
        if(wallets == null)
            return 0L;

        long totalBalance=0;
        for(WalletsEntity walletsEntity : wallets){
            totalBalance += walletsEntity.getBalance();
        }
        return totalBalance;
    }

    @Override
    public WalletsDTO addNewWalletData(String userID, WalletsDTO walletsDTO) {
        ModelMapper mapper = new ModelMapper();

        // Generate Public Wallets Id
        walletsDTO.setWalletID(generateRandomPublicId.generateUserId(30));

        UserEntity userData = userRepository.findByUserid(userID);

        walletsDTO.setUser(mapper.map(userData, UserDTO.class));
        WalletsEntity entity = mapper.map(walletsDTO, WalletsEntity.class);

        WalletsEntity storedData = walletsRepository.save(entity);

        WalletsDTO value = mapper.map(storedData, WalletsDTO.class);
        return value;
    }

    @Override
    public WalletsDTO updateWalletData(String userID, String walletID, WalletsDTO walletsDTO) {
        WalletsEntity entity = walletsRepository.findByWalletid(walletID);
        if(entity == null)
            return null;

        entity.setNohp(walletsDTO.getNoHP());
        entity.setBalance(walletsDTO.getBalance());

        WalletsEntity updateData = walletsRepository.save(entity);

        WalletsDTO value = new ModelMapper().map(updateData, WalletsDTO.class);
        return value;
    }
}
