package com.web3.domain;

import java.math.BigInteger;

public interface EthereumRepository {
    BigInteger getBalance(String address);
    String sendTransaction(String from, String to, BigInteger amount, String privateKey);
}
