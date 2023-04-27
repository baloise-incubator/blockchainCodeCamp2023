package code.camp.blockchainservice.blockchain;

import code.camp.blockchainservice.ServiceConfig;
import code.camp.blockchainservice.blockchain.contract.BaloiseLifeInsurance;
import code.camp.blockchainservice.blockchain.mapper.SmartContractMapper;
import code.camp.blockchainservice.domain.SmartContract;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class BlockchainService {

    private static String accessToken;
    private final SmartContractMapper mapper = new SmartContractMapper();
    private static final String SMART_CONTRACT_HASH = "0xf7D7Fc1C52Ee76b1f87F7eCD386201DbF448A5Fa";
    public static final String CUSTOMER_1 = "customer1";
    public static final String CUSTOMER_2 = "customer2";

    private  Map<String, Credentials> credentialsMap = new HashMap<>();


    public BlockchainService(ServiceConfig config) {
        init(config);
//        URL resource = getClass().getClassLoader().getResource(config.getPathToWalletFile());
//        if (resource == null) {
//            throw new IllegalArgumentException("file not found!");
//        } else {
//            pathToWalletFile =  resource.getPath();
//        }
    }

    private void init(ServiceConfig config){
        accessToken = config.getInfuraToken();
        credentialsMap.put(CUSTOMER_1, getCredentials(config.getCustomer1Password(), config.getCustomer1WalletFile()));
        credentialsMap.put(CUSTOMER_2, getCredentials(config.getCustomer2Password(), config.getCustomer2WalletFile()));
    }

//    public SmartContract getSmartContractByHash(String smartContractHash) {
//        log.info("calling Etherium sepolia TEST blockchain for hash : " + smartContractHash);
//        var web3j = Web3j.build(new HttpService("https://sepolia.infura.io/v3/" + accessToken));
//        var credentials = getCredentials(pathToWalletFile);
//        BaloiseLifeInsurance contract = BaloiseLifeInsurance.load(smartContractHash, web3j, credentials,  new DefaultGasProvider());
//        log.info("Successfully loaded smart contract with id : " + contract.getContractAddress());
//        var numberOfCustomers = getNumberOfCustomers(contract);
//
//        var smartContract = mapper.map(contract.getContractAddress(), numberOfCustomers);
//        return smartContract;
//    }

    public BaloiseLifeInsurance getSmartContract(String customerId) {
        log.info("calling Etherium sepolia TEST blockchain for hash : " + SMART_CONTRACT_HASH);
        var web3j = Web3j.build(new HttpService("https://sepolia.infura.io/v3/" + accessToken));
        var contract = BaloiseLifeInsurance.load(SMART_CONTRACT_HASH, web3j, credentialsMap.get(customerId),  new DefaultGasProvider());
        log.info("Successfully loaded smart contract with id : " + contract.getContractAddress());
        return contract;
    }

    private BigInteger getNumberOfCustomers(BaloiseLifeInsurance contract) {
        BigInteger numberOfCustomers;
        try {
            numberOfCustomers = contract.numberOfCustomers().send();
        } catch (Exception e) {
            log.error("Failed to execute remote function call to get number of customers from smart contract");
            throw new RuntimeException(e);
        }
        return numberOfCustomers;
    }

    private Credentials getCredentials(String password, String pathToWalletFile) {
        URL resource = getClass().getClassLoader().getResource(pathToWalletFile);
        if (resource == null) {
            throw new IllegalArgumentException("Wallet file not found!");
        }
        Credentials credentials;
        try {
            credentials = WalletUtils.loadCredentials(password, resource.getPath());
        } catch (Exception e) {
            log.error("Error during setting credentials of wallet", e);
            throw new RuntimeException(e);
        }
        return credentials;
    }

    public void payoutToWallet(String wallet) {
        var smartContract = getSmartContract(BlockchainService.CUSTOMER_1);
        smartContract.payout(wallet);
        log.info("Successfully payed out pension funds to customer with id : " + wallet);
    }
}
