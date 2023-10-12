package com.web3.infrastructure;

import com.web3.domain.EthereumRepository;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class EthereumWeb3jAdapter implements EthereumRepository {
    private Web3j web3j;

    public EthereumWeb3jAdapter(String rpcUrl) {
        this.web3j = Web3j.build(new HttpService(rpcUrl));
    }

    @Override
    public BigInteger getBalance(String address) {
        try {
            return web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send().getBalance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch balance", e);
        }
    }

    @Override
    public String sendTransaction(String from, String to, BigInteger amount, String privateKey) {
        try {
            Credentials credentials = Credentials.create(privateKey);
            TransactionReceipt receipt = Transfer.sendFunds(
                    web3j, credentials, to,
                    BigDecimal.valueOf(amount.longValue()), Convert.Unit.ETHER
            ).send();
            return receipt.getTransactionHash();
        } catch (Exception e) {
            throw new RuntimeException("Failed to send transaction", e);
        }
    }
}
