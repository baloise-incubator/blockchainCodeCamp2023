package code.camp.blockchainservice.blockchain.mapper;

import code.camp.blockchainservice.domain.SmartContract;

import java.math.BigInteger;

public class SmartContractMapper {


    public SmartContract map(String contractAddress, BigInteger numberOfCustomers) {
        var contract = new SmartContract();

        contract.addressHash = contractAddress;
        contract.numberOfCustomers = numberOfCustomers;

        return contract;
    }
}
