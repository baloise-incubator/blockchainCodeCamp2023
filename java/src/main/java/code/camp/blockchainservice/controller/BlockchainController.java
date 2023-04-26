package code.camp.blockchainservice.controller;

import code.camp.blockchainservice.blockchain.BlockchainService;
import code.camp.blockchainservice.domain.SmartContract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BlockchainController {

    private final BlockchainService blockchain;

    BlockchainController(BlockchainService blockchain) {
        this.blockchain = blockchain;
    }
    @GetMapping("/smart-contracts/{smartContractHash}")
    SmartContract getInfo(@PathVariable String smartContractHash) {

        return blockchain.getSmartContractByHash(smartContractHash);
    }

}
