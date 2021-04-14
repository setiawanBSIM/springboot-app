package org.springboot.bsim.ui.contoller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springboot.bsim.service.iservice.IWalletsService;
import org.springboot.bsim.shared.dto.UserDTO;
import org.springboot.bsim.shared.dto.WalletsDTO;
import org.springboot.bsim.ui.model.request.WalletRequest;
import org.springboot.bsim.ui.model.response.UserResponse;
import org.springboot.bsim.ui.model.response.WalletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletsController {
    @Autowired
    IWalletsService walletsService;

    @GetMapping(path = "/{userID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<WalletResponse> getAllWallets(@PathVariable String userID) {
        List<WalletsDTO> wallets = walletsService.getAllWalletsData(userID);
        List<WalletResponse> val = new ModelMapper().map(wallets, new TypeToken<List<WalletResponse>>(){}.getType());
        return val;
    }

    @GetMapping(path = "/{userID}/balance", produces = {MediaType.APPLICATION_JSON_VALUE})
    public long getTotalBalance(@PathVariable  String userID){
        long balance = walletsService.getTotalBalance(userID);
        return balance;
    }

    @PostMapping(path = "/{userID}", consumes = {MediaType.APPLICATION_JSON_VALUE} ,produces = {MediaType.APPLICATION_JSON_VALUE})
    public WalletResponse addNewWallet(@PathVariable String userID, @RequestBody WalletRequest walletRequest) {
        ModelMapper mapper = new ModelMapper();

        WalletsDTO walletsDTO = mapper.map(walletRequest, WalletsDTO.class);
        WalletsDTO createdWallet = walletsService.addNewWalletData(userID, walletsDTO);

        WalletResponse val = mapper.map(createdWallet, WalletResponse.class);
        return val;
    }

    @PutMapping(path = "/{userID}/{walletID}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public WalletResponse updateWalletAmount(@PathVariable String userID, @PathVariable String walletID, @RequestBody WalletRequest walletRequest) {
        ModelMapper mapper = new ModelMapper();

        WalletsDTO walletsDTO = mapper.map(walletRequest, WalletsDTO.class);
        WalletsDTO updatedWallet = walletsService.updateWalletData(userID, walletID, walletsDTO);

        WalletResponse val = mapper.map(updatedWallet, WalletResponse.class);
        return val;
    }
}
