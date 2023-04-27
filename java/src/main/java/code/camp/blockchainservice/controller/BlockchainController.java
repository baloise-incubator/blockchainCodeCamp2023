package code.camp.blockchainservice.controller;

import code.camp.blockchainservice.blockchain.BlockchainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/payout/wallet/{wallet}")
    public void payoutToWallet(@PathVariable String wallet) {
        blockchain.payoutToWallet(wallet);
    }

    @PostMapping("/payout/customer/{customer}")
    public void payout(@PathVariable String customer) {
        var smartContract = blockchain.getSmartContract(customer);
        blockchain.payoutToWallet(customer);
    }

    @PostMapping("/customer")
    public void createCustomer() throws Exception {
        var smartContract = blockchain.getSmartContract(BlockchainService.CUSTOMER_1);
        smartContract.addCustomer("Hans", "Mustermann", BigInteger.valueOf(60)).send();
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
