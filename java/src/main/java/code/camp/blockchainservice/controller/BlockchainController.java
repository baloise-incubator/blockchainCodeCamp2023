package code.camp.blockchainservice.controller;

import code.camp.blockchainservice.blockchain.BlockchainService;
import code.camp.blockchainservice.blockchain.contract.BaloiseLifeInsurance;
import code.camp.blockchainservice.domain.SmartContract;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.request.EthFilter;

import java.math.BigInteger;

@RestController
@RequestMapping("life-insurance")
@Slf4j
@RequiredArgsConstructor
public class BlockchainController {

    private final BlockchainService blockchain;

//    BlockchainController(BlockchainService blockchain) {
//        this.blockchain = blockchain;
//    }

//    @GetMapping("/{smartContractHash}")
//    SmartContract getInfo(@PathVariable String smartContractHash) {
//
//        return blockchain.getSmartContractByHash(smartContractHash);
//    }

    @PostMapping("/customer")
    public void createCustomer() throws Exception {
        var smartContract = blockchain.getSmartContract(BlockchainService.CUSTOMER_1);
        smartContract.addCustomer("Hans", "Mustermann", BigInteger.valueOf(60)).send().;
//        smartContract.registrationEventFlowable(new EthFilter()).subscribe(registrationEventResponse -> {
//            final BaloiseLifeInsurance.Customer customer = registrationEventResponse.customer;
//            final String customerAddress = registrationEventResponse.customerAddress;
//            log.debug("New customer created - firstName: {} lastName: {} age: {} customerAddress: {}",
//                    customer.firstName,
//                    customer.lastName,
//                    customer.currentAge,
//                    customer.walletAddress);
//        }, throwable ->
//            log.error("Error happen during user creation: {}", throwable.getMessage(), throwable)
//        );

    }


}
