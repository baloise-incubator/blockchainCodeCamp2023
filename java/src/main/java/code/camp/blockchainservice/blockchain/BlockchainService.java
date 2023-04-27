package code.camp.blockchainservice.blockchain;

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

@Service
@Slf4j
public class BlockchainService {

    private static final String TOKEN = "INFURA_TOKEN";
    private static final String accessToken = System.getenv(TOKEN);
    private static final String PASSWORD = "WALLET_PASSWORD";
    private final Logger _logger = LoggerFactory.getLogger(BlockchainService.class);
    private final String password = System.getenv(PASSWORD);
    private final String pathToWalletFile = "/Users/kolja/Documents/CodeCamps/blockchainCodeCamp2023/UTC--2023-04-25T10-27-16.21765000Z--606b791149899f76d53aa8db35035bfc24fb6b7a.json";
    private final SmartContractMapper mapper = new SmartContractMapper();

    public SmartContract getSmartContractByHash(String smartContractHash) {
        _logger.info("calling Etherium sepolia TEST blockchain for hash : " + smartContractHash);
        var web3j = Web3j.build(new HttpService("https://sepolia.infura.io/v3/" + accessToken));
        var credentials = getCredentials(pathToWalletFile);
        var contract = BaloiseLifeInsurance.load(smartContractHash, web3j, credentials,  new DefaultGasProvider());
        _logger.info("Successfully loaded smart contract with id : " + contract.getContractAddress());
        var numberOfCustomers = getNumberOfCustomers(contract);
        var smartContract = mapper.map(contract.getContractAddress(), numberOfCustomers);
        return smartContract;
    }

    private BigInteger getNumberOfCustomers(BaloiseLifeInsurance contract) {
        BigInteger numberOfCustomers;
        try {
            numberOfCustomers = contract.numberOfCustomers().send();
        } catch (Exception e) {
            _logger.error("Failed to execute remote function call to get number of customers from smart contract");
            throw new RuntimeException(e);
        }
        return numberOfCustomers;
    }

    private Credentials getCredentials(String pathToWalletFile) {
        Credentials credentials;
        try {
            credentials = WalletUtils.loadCredentials(password, pathToWalletFile);
        } catch (Exception e) {
            _logger.error("Error during setting credentials of wallet", e);
            throw new RuntimeException(e);
        }
        return credentials;
    }
}
