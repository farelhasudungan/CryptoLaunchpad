package com.launchpad.service;

import com.launchpad.contracts.LaunchpadToken;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import java.math.BigInteger;

public class BlockchainService {
    private Web3j web3j;
    private Credentials credentials;
    
    private static final String BASE_MAINNET = "https://mainnet.base.org";
    private static final String BASE_TESTNET = "https://goerli.base.org";
    private static final String ARBITRUM_MAINNET = "https://arb1.arbitrum.io/rpc";
    private static final String ETHEREUM_MAINNET = "https://mainnet.infura.io/v3";
    
    public BlockchainService(String network) {
        String rpcUrl = getRpcUrl(network);
        this.web3j = Web3j.build(new HttpService(rpcUrl));
        
        String privateKey = System.getenv("PRIVATE_KEY");
        this.credentials = Credentials.create(privateKey);
    }
    
    private String getRpcUrl(String network) {
        switch (network.toLowerCase()) {
            case "base":
                return BASE_MAINNET;
            case "arbitrum":
                return ARBITRUM_MAINNET;
            case "ethereum":
                return ETHEREUM_MAINNET;
            default:
                return BASE_TESTNET;
        }
    }
    
    public String deployToken(String name, String symbol, BigInteger initialSupply) throws Exception {
        LaunchpadToken token = LaunchpadToken.deploy(
            web3j,
            credentials,
            new DefaultGasProvider(),
            name,
            symbol,
            initialSupply
        ).send();
        

        return token.getContractAddress();
    }
    
    public BigInteger getBalance(String address) throws Exception {
        return web3j.ethGetBalance(address, org.web3j.protocol.core.DefaultBlockParameterName.LATEST)
                   .send()
                   .getBalance();
    }
    
    public String getDeployerAddress() {
        return credentials.getAddress();
    }
}
