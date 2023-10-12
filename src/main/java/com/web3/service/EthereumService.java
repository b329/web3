package com.web3.service;

import com.web3.domain.EthereumRepository;

import java.math.BigInteger;

public class EthereumService {
    private final EthereumRepository ethereumRepository;

    public EthereumService(EthereumRepository ethereumRepository) {
        this.ethereumRepository = ethereumRepository;
    }

    public BigInteger getBalance(String address) {
        return ethereumRepository.getBalance(address);
    }

    public String sendTransaction(String from, String to, BigInteger amount, String privateKey) {
        return ethereumRepository.sendTransaction(from, to, amount, privateKey);
    }


}
