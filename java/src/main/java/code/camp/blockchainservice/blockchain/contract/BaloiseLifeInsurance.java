package code.camp.blockchainservice.blockchain.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.2.
 */
@SuppressWarnings("rawtypes")
public class BaloiseLifeInsurance extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03191633179055610b38806100326000396000f3fe6080604052600436106100865760003560e01c8063b2a0b85b11610059578063b2a0b85b14610123578063baac274d14610136578063d715b75b1461016f578063f2f35ff51461018f578063f7d69b1e146101bc57600080fd5b80630b7e9c441461008b57806335c7e814146100ad5780636f9fb98a146100fa5780639fb9e0f51461010d575b600080fd5b34801561009757600080fd5b506100ab6100a63660046105ca565b6101dc565b005b3480156100b957600080fd5b506100e76100c83660046105ca565b6001600160a01b03166000908152600260208190526040909120015490565b6040519081526020015b60405180910390f35b34801561010657600080fd5b50476100e7565b34801561011957600080fd5b506100e760035481565b6100ab6101313660046105ca565b61034b565b34801561014257600080fd5b506100e76101513660046105ca565b6001600160a01b031660009081526002602052604090206003015490565b34801561017b57600080fd5b506100ab61018a36600461068f565b61039e565b34801561019b57600080fd5b506101af6101aa3660046105ca565b61044d565b6040516100f1919061070d565b3480156101c857600080fd5b506100ab6101d736600461075b565b610495565b6001600160a01b03811660009081526002602081905260409091200154603c11156102745760405162461bcd60e51b815260206004820152603760248201527f54686520616765206f662074686520696e737572656420706572736f6e206d7560448201527f737420626520657175616c206f662061626f766520363000000000000000000060648201526084015b60405180910390fd5b6001600160a01b038116600090815260026020526040812060030180549182919061029f838061079b565b90915550506001600160a01b038216600081815260026020526040808220600401805460ff191690555184929184156108fc02918591818181858888f193505050501580156102f2573d6000803e3d6000fd5b506001600160a01b0383166000908152600260205260409081902090517fb85bb1ceb78db92032576164cc9b8c11395f4bf6c90b5c4e05d1a06c806ced829161033e918691869161086b565b60405180910390a1505050565b6000341161036b5760405162461bcd60e51b815260040161026b906108e7565b6001600160a01b0381166000908152600260205260408120600301805434929061039690849061092b565b909155505050565b6040805160a0810182528581526020808201869052818301859052600060608301819052600160808401526001600160a01b0385168152600290915291909120815181906103ec908261098d565b5060208201516001820190610401908261098d565b506040820151600282015560608201516003808301919091556080909201516004909101805460ff1916911515919091179055805490600061044283610a4d565b919050555050505050565b6001600160a01b038116600090815260026020908152604091829020915160609261047f929091600183019101610ad9565b6040516020818303038152906040529050919050565b600081116104b55760405162461bcd60e51b815260040161026b906108e7565b6001600160a01b03821660009081526002602052604090206004015460ff166105205760405162461bcd60e51b815260206004820152601b60248201527f546865207573657220686173206265656e207061796564206f75740000000000604482015260640161026b565b6001600160a01b0382166000908152600260205260408120600301805483929061054b90849061092b565b90915550506001600160a01b03821660008181526002602090815260409182902060030154825193845290830184905282820152517f7fa9aafeb8bb803d77de5d84bc2f2edbd842ca91b20cd5020aa21dfe26ab0be99181900360600190a15050565b80356001600160a01b03811681146105c557600080fd5b919050565b6000602082840312156105dc57600080fd5b6105e5826105ae565b9392505050565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261061357600080fd5b813567ffffffffffffffff8082111561062e5761062e6105ec565b604051601f8301601f19908116603f01168101908282118183101715610656576106566105ec565b8160405283815286602085880101111561066f57600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080608085870312156106a557600080fd5b843567ffffffffffffffff808211156106bd57600080fd5b6106c988838901610602565b955060208701359150808211156106df57600080fd5b506106ec87828801610602565b93505060408501359150610702606086016105ae565b905092959194509250565b600060208083528351808285015260005b8181101561073a5785810183015185820160400152820161071e565b506000604082860101526040601f19601f8301168501019250505092915050565b6000806040838503121561076e57600080fd5b610777836105ae565b946020939093013593505050565b634e487b7160e01b600052601160045260246000fd5b818103818111156107ae576107ae610785565b92915050565b600181811c908216806107c857607f821691505b6020821081036107e857634e487b7160e01b600052602260045260246000fd5b50919050565b600081546107fb816107b4565b808552602060018381168015610818576001811461083257610860565b60ff1985168884015283151560051b880183019550610860565b866000528260002060005b858110156108585781548a820186015290830190840161083d565b890184019650505b505050505092915050565b6001600160a01b03841681526020810183905260606040820181905260a090820152600061089d6101008301846107ee565b828103605f190160808401526108b681600186016107ee565b9050600284015460a0840152600384015460c084015260ff600485015416151560e084015280915050949350505050565b60208082526024908201527f54686520616d6f756e74206d75737420626520626967676572207468656e207a60408201526332b9379760e11b606082015260800190565b808201808211156107ae576107ae610785565b601f82111561098857600081815260208120601f850160051c810160208610156109655750805b601f850160051c820191505b8181101561098457828155600101610971565b5050505b505050565b815167ffffffffffffffff8111156109a7576109a76105ec565b6109bb816109b584546107b4565b8461093e565b602080601f8311600181146109f057600084156109d85750858301515b600019600386901b1c1916600185901b178555610984565b600085815260208120601f198616915b82811015610a1f57888601518255948401946001909101908401610a00565b5085821015610a3d5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b600060018201610a5f57610a5f610785565b5060010190565b60008154610a73816107b4565b60018281168015610a8b5760018114610aa057610acf565b60ff1984168752821515830287019450610acf565b8560005260208060002060005b85811015610ac65781548a820152908401908201610aad565b50505082870194505b5050505092915050565b6000610ae58285610a66565b600160fd1b8152610af96001820185610a66565b9594505050505056fea264697066735822122099821d1cb098d44bb8582a6b22086b567108c4928261b25bc013c2e8ec82aa4764736f6c63430008130033";

    public static final String FUNC_ADDCUSTOMER = "addCustomer";

    public static final String FUNC_GETCONTRACTBALANCE = "getContractBalance";

    public static final String FUNC_GETCUSTOMERAGE = "getCustomerAge";

    public static final String FUNC_GETCUSTOMERBALANCE = "getCustomerBalance";

    public static final String FUNC_GETFULLNAME = "getFullName";

    public static final String FUNC_MOUNTLYPAY = "mountlyPay";

    public static final String FUNC_NUMBEROFCUSTOMERS = "numberOfCustomers";

    public static final String FUNC_PAYLIFEINSURANCEPREMIUM = "payLifeInsurancePremium";

    public static final String FUNC_PAYOUT = "payout";

    public static final Event PAYOUT_EVENT = new Event("Payout", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Customer>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected BaloiseLifeInsurance(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BaloiseLifeInsurance(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BaloiseLifeInsurance(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BaloiseLifeInsurance(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<PayoutEventResponse> getPayoutEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PAYOUT_EVENT, transactionReceipt);
        ArrayList<PayoutEventResponse> responses = new ArrayList<PayoutEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PayoutEventResponse typedResponse = new PayoutEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.payout = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.customer = (Customer) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PayoutEventResponse> payoutEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PayoutEventResponse>() {
            @Override
            public PayoutEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAYOUT_EVENT, log);
                PayoutEventResponse typedResponse = new PayoutEventResponse();
                typedResponse.log = log;
                typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.payout = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.customer = (Customer) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Flowable<PayoutEventResponse> payoutEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAYOUT_EVENT));
        return payoutEventFlowable(filter);
    }

    public static List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addCustomer(String _firstName, String _lastName, BigInteger _currentAge, String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDCUSTOMER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_firstName), 
                new org.web3j.abi.datatypes.Utf8String(_lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(_currentAge), 
                new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getContractBalance() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCONTRACTBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getCustomerAge(String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCUSTOMERAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getCustomerBalance(String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCUSTOMERBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getFullName(String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETFULLNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mountlyPay(String _walletAddress, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOUNTLYPAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> numberOfCustomers() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NUMBEROFCUSTOMERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payLifeInsurancePremium(String _walletAddress, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAYLIFEINSURANCEPREMIUM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> payout(String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAYOUT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static BaloiseLifeInsurance load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BaloiseLifeInsurance(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BaloiseLifeInsurance load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BaloiseLifeInsurance(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BaloiseLifeInsurance load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BaloiseLifeInsurance(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BaloiseLifeInsurance load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BaloiseLifeInsurance(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BaloiseLifeInsurance> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BaloiseLifeInsurance.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<BaloiseLifeInsurance> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BaloiseLifeInsurance.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BaloiseLifeInsurance> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BaloiseLifeInsurance.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BaloiseLifeInsurance> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BaloiseLifeInsurance.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Customer extends DynamicStruct {
        public String firstName;

        public String lastName;

        public BigInteger currentAge;

        public BigInteger balance;

        public Boolean active;

        public Customer(String firstName, String lastName, BigInteger currentAge, BigInteger balance, Boolean active) {
            super(new org.web3j.abi.datatypes.Utf8String(firstName), 
                    new org.web3j.abi.datatypes.Utf8String(lastName), 
                    new org.web3j.abi.datatypes.generated.Uint256(currentAge), 
                    new org.web3j.abi.datatypes.generated.Uint256(balance), 
                    new org.web3j.abi.datatypes.Bool(active));
            this.firstName = firstName;
            this.lastName = lastName;
            this.currentAge = currentAge;
            this.balance = balance;
            this.active = active;
        }

        public Customer(Utf8String firstName, Utf8String lastName, Uint256 currentAge, Uint256 balance, Bool active) {
            super(firstName, lastName, currentAge, balance, active);
            this.firstName = firstName.getValue();
            this.lastName = lastName.getValue();
            this.currentAge = currentAge.getValue();
            this.balance = balance.getValue();
            this.active = active.getValue();
        }
    }

    public static class PayoutEventResponse extends BaseEventResponse {
        public String receiver;

        public BigInteger payout;

        public Customer customer;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;

        public BigInteger balance;
    }
}
