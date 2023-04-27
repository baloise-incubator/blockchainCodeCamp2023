package code.camp.blockchainservice.controller;

import code.camp.blockchainservice.blockchain.BlockchainService;
import code.camp.blockchainservice.domain.SmartContract;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("life-insurance")
public class BlockchainController {

    private final BlockchainService blockchain;

    BlockchainController(BlockchainService blockchain) {
        this.blockchain = blockchain;
    }
    @GetMapping("/{smartContractHash}")
    SmartContract getInfo(@PathVariable String smartContractHash) {

        return blockchain.getSmartContractByHash(smartContractHash);
    }

}
