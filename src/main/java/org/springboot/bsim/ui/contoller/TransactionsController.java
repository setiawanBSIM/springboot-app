package org.springboot.bsim.ui.contoller;

import org.modelmapper.ModelMapper;
import org.springboot.bsim.service.iservice.ITransactionsService;
import org.springboot.bsim.shared.dto.TransactionsDTO;
import org.springboot.bsim.ui.model.request.TransactionsRequest;
import org.springboot.bsim.ui.model.response.TransactionsResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionsController {

    private final ITransactionsService transactionsService;

    public TransactionsController(ITransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TransactionsResponse> getTransactions() {
        List<TransactionsDTO> transactions = transactionsService.getListTransactions();

        List<TransactionsResponse> returnValue = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        for (TransactionsDTO transactionsDTO : transactions) {
            returnValue.add(modelMapper.map(transactionsDTO, TransactionsResponse.class));
        }
        return returnValue;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public TransactionsResponse addTransactions(@RequestBody TransactionsRequest transactionsRequest) {

        System.out.println(transactionsRequest.toString());
        ModelMapper modelMapper = new ModelMapper();
        /* TransactionsDTO transactionsDTO = modelMapper.map(transactionsRequest, TransactionsDTO.class);*/
        TransactionsDTO transactionsDTO = new TransactionsDTO();

        transactionsDTO.setAmount(transactionsRequest.getAmount());
        transactionsDTO.setTanggal(transactionsRequest.getTanggal());
        transactionsDTO.setName(transactionsRequest.getName());
        transactionsDTO.setWalletId(transactionsRequest.getWalletId());
        System.out.println(transactionsDTO.toString());
        TransactionsDTO createdTransactions = transactionsService.addTransactions(transactionsDTO);

        TransactionsResponse returnValue = modelMapper.map(createdTransactions, TransactionsResponse.class);

        return returnValue;
    }

    @GetMapping(path = "/{walletId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TransactionsResponse> getTransactionsByWalletId(@PathVariable long walletId) {
        List<TransactionsDTO> transactionsDTO = transactionsService.getTransactionsByWalletId(walletId);

        ModelMapper modelMapper = new ModelMapper();

        List<TransactionsResponse> returnValue = new ArrayList<>();
        for (TransactionsDTO dto : transactionsDTO) {
            returnValue.add(modelMapper.map(dto, TransactionsResponse.class));
        }
        return returnValue;
    }

    @PutMapping(path = "/{walletId}/{transactionsId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public TransactionsResponse updateTransactions(@PathVariable long walletId, @PathVariable String transactionsId, @RequestBody TransactionsRequest transactionsRequest) {
        ModelMapper modelMapper = new ModelMapper();

        transactionsRequest.setWalletId(walletId);

        TransactionsDTO transactionsDTO = modelMapper.map(transactionsRequest, TransactionsDTO.class);

        TransactionsDTO updateTransactions = transactionsService.updateTransactions(transactionsDTO, transactionsId);

        TransactionsResponse returnvalue = modelMapper.map(updateTransactions, TransactionsResponse.class);

        return returnvalue;
    }


}
