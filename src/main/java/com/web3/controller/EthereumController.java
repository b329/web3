package com.web3.controller;

import com.web3.service.EthereumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/ethereum")
public class EthereumController {

    private final EthereumService ethereumService;

    public EthereumController(EthereumService ethereumService) {
        this.ethereumService = ethereumService;
    }

    @GetMapping("/balance")
    public BigInteger getBalance(@RequestParam String address) {
        return ethereumService.getBalance(address);
    }
}
