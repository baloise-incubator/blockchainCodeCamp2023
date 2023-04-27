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

@Service
@Slf4j
public class BlockchainService {

    private static String accessToken;
    private final String password;
    private final String pathToWalletFile;
    private final SmartContractMapper mapper = new SmartContractMapper();
    private final Logger _logger = LoggerFactory.getLogger(BlockchainService.class);

    public BlockchainService(ServiceConfig config) {
        password = config.getWalletPassword();
        accessToken = config.getInfuraToken();
        URL resource = getClass().getClassLoader().getResource(config.getPathToWalletFile());
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            pathToWalletFile =  resource.getPath();
        }
    }
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
