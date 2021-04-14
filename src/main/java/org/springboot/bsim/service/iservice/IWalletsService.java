package org.springboot.bsim.service.iservice;

import org.springboot.bsim.shared.dto.WalletsDTO;

import java.util.List;

public interface IWalletsService {
    List<WalletsDTO> getAllWalletsData(String userID);
    long getTotalBalance(String userID);
    WalletsDTO addNewWalletData(String userID, WalletsDTO walletsDTO);
    WalletsDTO updateWalletData(String userID, String walletID, WalletsDTO walletsDTO);
}
