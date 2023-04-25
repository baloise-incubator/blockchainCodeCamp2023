package code.camp.blockchainservice.contract;

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
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03191633179055610958806100326000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80630b7e9c441461006757806335c7e8141461007c5780639fb9e0f5146100bc578063d715b75b146100c5578063f2f35ff5146100d8578063f7d69b1e146100f8575b600080fd5b61007a61007536600461042e565b61010b565b005b6100a961008a36600461042e565b6001600160a01b03166000908152600260208190526040909120015490565b6040519081526020015b60405180910390f35b6100a960035481565b61007a6100d33660046104f3565b610236565b6100eb6100e636600461042e565b6102e5565b6040516100b39190610571565b61007a6101063660046105bf565b61032d565b6001600160a01b03811660009081526002602081905260409091200154603c11156101a35760405162461bcd60e51b815260206004820152603760248201527f54686520616765206f662074686520696e737572656420706572736f6e206d7560448201527f737420626520657175616c206f662061626f766520363000000000000000000060648201526084015b60405180910390fd5b6001600160a01b03811660009081526002602052604081206003018054918291906101ce83806105ff565b90915550506001600160a01b0382166000908152600260205260409081902060048101805460ff1916905590517fb85bb1ceb78db92032576164cc9b8c11395f4bf6c90b5c4e05d1a06c806ced829161022a91859185916106cf565b60405180910390a15050565b6040805160a0810182528581526020808201869052818301859052600060608301819052600160808401526001600160a01b038516815260029091529190912081518190610284908261079a565b5060208201516001820190610299908261079a565b506040820151600282015560608201516003808301919091556080909201516004909101805460ff191691151591909117905580549060006102da8361085a565b919050555050505050565b6001600160a01b03811660009081526002602090815260409182902091516060926103179290916001830191016108e6565b6040516020818303038152906040529050919050565b600081116103895760405162461bcd60e51b8152602060048201526024808201527f54686520616d6f756e74206d75737420626520626967676572207468656e207a60448201526332b9379760e11b606482015260840161019a565b6001600160a01b038216600090815260026020526040812060030180548392906103b490849061090f565b90915550506001600160a01b038216600081815260026020908152604091829020600301548251938452908301849052908201527f7fa9aafeb8bb803d77de5d84bc2f2edbd842ca91b20cd5020aa21dfe26ab0be99060600161022a565b80356001600160a01b038116811461042957600080fd5b919050565b60006020828403121561044057600080fd5b61044982610412565b9392505050565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261047757600080fd5b813567ffffffffffffffff8082111561049257610492610450565b604051601f8301601f19908116603f011681019082821181831017156104ba576104ba610450565b816040528381528660208588010111156104d357600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806000806080858703121561050957600080fd5b843567ffffffffffffffff8082111561052157600080fd5b61052d88838901610466565b9550602087013591508082111561054357600080fd5b5061055087828801610466565b9350506040850135915061056660608601610412565b905092959194509250565b600060208083528351808285015260005b8181101561059e57858101830151858201604001528201610582565b506000604082860101526040601f19601f8301168501019250505092915050565b600080604083850312156105d257600080fd5b6105db83610412565b946020939093013593505050565b634e487b7160e01b600052601160045260246000fd5b81810381811115610612576106126105e9565b92915050565b600181811c9082168061062c57607f821691505b60208210810361064c57634e487b7160e01b600052602260045260246000fd5b50919050565b6000815461065f81610618565b80855260206001838116801561067c5760018114610696576106c4565b60ff1985168884015283151560051b8801830195506106c4565b866000528260002060005b858110156106bc5781548a82018601529083019084016106a1565b890184019650505b505050505092915050565b6001600160a01b03841681526020810183905260606040820181905260a0908201526000610701610100830184610652565b828103605f1901608084015261071a8160018601610652565b9050600284015460a0840152600384015460c084015260ff600485015416151560e084015280915050949350505050565b601f82111561079557600081815260208120601f850160051c810160208610156107725750805b601f850160051c820191505b818110156107915782815560010161077e565b5050505b505050565b815167ffffffffffffffff8111156107b4576107b4610450565b6107c8816107c28454610618565b8461074b565b602080601f8311600181146107fd57600084156107e55750858301515b600019600386901b1c1916600185901b178555610791565b600085815260208120601f198616915b8281101561082c5788860151825594840194600190910190840161080d565b508582101561084a5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b60006001820161086c5761086c6105e9565b5060010190565b6000815461088081610618565b6001828116801561089857600181146108ad576108dc565b60ff19841687528215158302870194506108dc565b8560005260208060002060005b858110156108d35781548a8201529084019082016108ba565b50505082870194505b5050505092915050565b60006108f28285610873565b600160fd1b81526109066001820185610873565b95945050505050565b80820180821115610612576106126105e956fea26469706673582212206a6ffa0c07e1867886821ba45bb2f200c8c5987d0171a4bc50c2f3c9f0ef8d5b64736f6c63430008130033";

    public static final String FUNC_ADDCUSTOMER = "addCustomer";

    public static final String FUNC_GETCUSTOMERAGE = "getCustomerAge";

    public static final String FUNC_GETFULLNAME = "getFullName";

    public static final String FUNC_MOUNTLYPAY = "mountlyPay";

    public static final String FUNC_NUMBEROFCUSTOMERS = "numberOfCustomers";

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

    public RemoteFunctionCall<BigInteger> getCustomerAge(String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCUSTOMERAGE, 
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
