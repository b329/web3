package com.web3.config;

import com.web3.service.EthereumService;
import com.web3.infrastructure.EthereumWeb3jAdapter;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EthereumConfig {

    @Bean
    public EthereumService ethereumService() {
        Dotenv dotenv = Dotenv.load();
        String rpcUrl = dotenv.get("ETHEREUM_RPC_URL"); // .env에서 읽어옴

        if (rpcUrl == null) {
            throw new RuntimeException("Please set ETHEREUM_RPC_URL in .env file.");
        }

        EthereumWeb3jAdapter web3jAdapter = new EthereumWeb3jAdapter(rpcUrl);
        return new EthereumService(web3jAdapter);
    }
}
