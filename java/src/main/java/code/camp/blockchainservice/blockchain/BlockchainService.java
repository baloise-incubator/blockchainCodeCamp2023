package code.camp.blockchainservice.blockchain;

import code.camp.blockchainservice.controller.SmartContract;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Service
@Slf4j
public class BlockchainService {

    private static final String TOKEN = "INFURA_TOKEN";
    private final Logger _logger = LoggerFactory.getLogger(BlockchainService.class);

    public SmartContract getSmartContractByHash(Long smartContractHash) {

        var accessToken = System.getenv(TOKEN);
        var web3j = Web3j.build(new HttpService("https://sepolia.infura.io/v3/" + accessToken));

//        Credentials credentials = WalletUtils.loadCredentials();
//        BaloiseLifeInsurance.deploy(web3j, credentials);

        _logger.info("calling Etherium TEST blockchain for hash : " + smartContractHash);
        // implement API call to Etherium TEST blockchain
        return null;
    }
}
