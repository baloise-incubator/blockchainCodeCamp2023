package code.camp.blockchainservice.blockchain;

import code.camp.blockchainservice.controller.SmartContract;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlockchainService {

    private Logger _logger = LoggerFactory.getLogger(BlockchainService.class);

    public SmartContract getSmartContractByHash(Long smartContractHash) {

        _logger.info("calling Etherium TEST blockchain for hash : " + smartContractHash);
        // implement API call to Etherium TEST blockchain
        return null;
    }
}
