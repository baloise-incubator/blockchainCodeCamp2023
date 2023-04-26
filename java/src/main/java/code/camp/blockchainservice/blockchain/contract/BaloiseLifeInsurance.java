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
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03191633179055610d79806100326000396000f3fe60806040526004361061007f5760003560e01c8063a853409a1161004e578063a853409a146101e2578063d715b75b14610207578063da5411a914610227578063e77a52641461024d57600080fd5b80630b7e9c44146101665780636f9fb98a146101885780638c160186146101aa5780639fb9e0f5146101cc57600080fd5b3661016157600034116100e55760405162461bcd60e51b8152602060048201526024808201527f54686520616d6f756e74206d75737420626520626967676572207468656e207a60448201526332b9379760e11b60648201526084015b60405180910390fd5b33600090815260026020526040812060030180543492906101079084906107b1565b909155505033600081815260026020908152604091829020600301548251938452349184019190915282820152517f7fa9aafeb8bb803d77de5d84bc2f2edbd842ca91b20cd5020aa21dfe26ab0be99181900360600190a1005b600080fd5b34801561017257600080fd5b506101866101813660046107e6565b61026f565b005b34801561019457600080fd5b50475b6040519081526020015b60405180910390f35b3480156101b657600080fd5b506101bf6103d9565b6040516101a1919061084e565b3480156101d857600080fd5b5061019760035481565b3480156101ee57600080fd5b5033600090815260026020526040902060030154610197565b34801561021357600080fd5b50610186610222366004610904565b610416565b34801561023357600080fd5b503360009081526002602081905260409091200154610197565b34801561025957600080fd5b506102626105dd565b6040516101a19190610982565b6001600160a01b03811660009081526002602081905260409091200154603c11156103025760405162461bcd60e51b815260206004820152603760248201527f54686520616765206f662074686520696e737572656420706572736f6e206d7560448201527f737420626520657175616c206f662061626f766520363000000000000000000060648201526084016100dc565b6001600160a01b038116600090815260026020526040812060030180549182919061032d83806109fa565b90915550506001600160a01b038216600081815260026020526040808220600401805460ff191690555184929184156108fc02918591818181858888f19350505050158015610380573d6000803e3d6000fd5b506001600160a01b0383166000908152600260205260409081902090517f4abd51f2b72ef8b73ee8993158f730a67a506c1c5e76ea40f5fe4abf2caec3e2916103cc9186918691610b2c565b60405180910390a1505050565b336000908152600260209081526040918290209151606092610402929091600183019101610bcf565b604051602081830303815290604052905090565b6001600160a01b03811660009081526002602052604090206004015460ff16156104a85760405162461bcd60e51b815260206004820152603860248201527f437573746f6d6572207769746820746869732077616c6c65742061646472657360448201527f7320697320616c726561647920726567697374657265642e000000000000000060648201526084016100dc565b6040805160c0810182528581526020808201869052818301859052600060608301819052600160808401526001600160a01b03851660a084018190528152600290915291909120815181906104fd9082610c3e565b50602082015160018201906105129082610c3e565b5060408201516002820155606082015160038083019190915560808301516004909201805460a0909401516001600160a01b031661010002610100600160a81b0319931515939093166001600160a81b03199094169390931791909117909155805490600061058083610cfe565b90915550506001600160a01b0381166000908152600260205260409081902090517fa0ba44081f18dd31796c193a037b7913d3d94b9c00edede813793b21c759b9e4916105cf91849190610d17565b60405180910390a150505050565b6106216040518060c001604052806060815260200160608152602001600081526020016000815260200160001515815260200160006001600160a01b031681525090565b3360009081526002602052604090819020815160c0810190925280548290829061064a90610a0d565b80601f016020809104026020016040519081016040528092919081815260200182805461067690610a0d565b80156106c35780601f10610698576101008083540402835291602001916106c3565b820191906000526020600020905b8154815290600101906020018083116106a657829003601f168201915b505050505081526020016001820180546106dc90610a0d565b80601f016020809104026020016040519081016040528092919081815260200182805461070890610a0d565b80156107555780601f1061072a57610100808354040283529160200191610755565b820191906000526020600020905b81548152906001019060200180831161073857829003601f168201915b5050509183525050600282015460208201526003820154604082015260049091015460ff81161515606083015261010090046001600160a01b0316608090910152919050565b634e487b7160e01b600052601160045260246000fd5b808201808211156107c4576107c461079b565b92915050565b80356001600160a01b03811681146107e157600080fd5b919050565b6000602082840312156107f857600080fd5b610801826107ca565b9392505050565b6000815180845260005b8181101561082e57602081850181015186830182015201610812565b506000602082860101526020601f19601f83011685010191505092915050565b6020815260006108016020830184610808565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261088857600080fd5b813567ffffffffffffffff808211156108a3576108a3610861565b604051601f8301601f19908116603f011681019082821181831017156108cb576108cb610861565b816040528381528660208588010111156108e457600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806000806080858703121561091a57600080fd5b843567ffffffffffffffff8082111561093257600080fd5b61093e88838901610877565b9550602087013591508082111561095457600080fd5b5061096187828801610877565b93505060408501359150610977606086016107ca565b905092959194509250565b602081526000825160c0602084015261099e60e0840182610808565b90506020840151601f198483030160408501526109bb8282610808565b91505060408401516060840152606084015160808401526080840151151560a084015260018060a01b0360a08501511660c08401528091505092915050565b818103818111156107c4576107c461079b565b600181811c90821680610a2157607f821691505b602082108103610a4157634e487b7160e01b600052602260045260246000fd5b50919050565b60008154610a5481610a0d565b808552602060018381168015610a715760018114610a8b57610ab9565b60ff1985168884015283151560051b880183019550610ab9565b866000528260002060005b85811015610ab15781548a8201860152908301908401610a96565b890184019650505b505050505092915050565b60c082526000610ad760c0840183610a47565b8381036020850152610aec8160018501610a47565b600284015460408601526003840154606086015260049093015460ff81161515608086015260081c6001600160a01b031660a09094019390935250919050565b60018060a01b0384168152826020820152606060408201526000610b536060830184610ac4565b95945050505050565b60008154610b6981610a0d565b60018281168015610b815760018114610b9657610bc5565b60ff1984168752821515830287019450610bc5565b8560005260208060002060005b85811015610bbc5781548a820152908401908201610ba3565b50505082870194505b5050505092915050565b6000610bdb8285610b5c565b600160fd1b8152610b536001820185610b5c565b601f821115610c3957600081815260208120601f850160051c81016020861015610c165750805b601f850160051c820191505b81811015610c3557828155600101610c22565b5050505b505050565b815167ffffffffffffffff811115610c5857610c58610861565b610c6c81610c668454610a0d565b84610bef565b602080601f831160018114610ca15760008415610c895750858301515b600019600386901b1c1916600185901b178555610c35565b600085815260208120601f198616915b82811015610cd057888601518255948401946001909101908401610cb1565b5085821015610cee5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b600060018201610d1057610d1061079b565b5060010190565b6001600160a01b0383168152604060208201819052600090610d3b90830184610ac4565b94935050505056fea2646970667358221220ab9ab6b791b76f27a84cd99090d4eeacca6bbe848d4abb01f3eee6be3b31252b64736f6c63430008130033";

    public static final String FUNC_ADDCUSTOMER = "addCustomer";

    public static final String FUNC_GETCONTRACTBALANCE = "getContractBalance";

    public static final String FUNC_GETCUSTOMERAGE = "getCustomerAge";

    public static final String FUNC_GETCUSTOMERBALANCE = "getCustomerBalance";

    public static final String FUNC_GETCUSTOMERCE = "getCustomerce";

    public static final String FUNC_GETFULLNAME = "getFullName";

    public static final String FUNC_NUMBEROFCUSTOMERS = "numberOfCustomers";

    public static final String FUNC_PAYOUT = "payout";

    public static final Event PAYOUT_EVENT = new Event("Payout", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Customer>() {}));
    ;

    public static final Event REGISTRATION_EVENT = new Event("Registration", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Customer>() {}));
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

    public static List<RegistrationEventResponse> getRegistrationEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(REGISTRATION_EVENT, transactionReceipt);
        ArrayList<RegistrationEventResponse> responses = new ArrayList<RegistrationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RegistrationEventResponse typedResponse = new RegistrationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.customerAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.customer = (Customer) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RegistrationEventResponse> registrationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RegistrationEventResponse>() {
            @Override
            public RegistrationEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REGISTRATION_EVENT, log);
                RegistrationEventResponse typedResponse = new RegistrationEventResponse();
                typedResponse.log = log;
                typedResponse.customerAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.customer = (Customer) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<RegistrationEventResponse> registrationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REGISTRATION_EVENT));
        return registrationEventFlowable(filter);
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

    public RemoteFunctionCall<BigInteger> getCustomerAge() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCUSTOMERAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getCustomerBalance() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCUSTOMERBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Customer> getCustomerce() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCUSTOMERCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Customer>() {}));
        return executeRemoteCallSingleValueReturn(function, Customer.class);
    }

    public RemoteFunctionCall<String> getFullName() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETFULLNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

        public String walletAddress;

        public Customer(String firstName, String lastName, BigInteger currentAge, BigInteger balance, Boolean active, String walletAddress) {
            super(new org.web3j.abi.datatypes.Utf8String(firstName), 
                    new org.web3j.abi.datatypes.Utf8String(lastName), 
                    new org.web3j.abi.datatypes.generated.Uint256(currentAge), 
                    new org.web3j.abi.datatypes.generated.Uint256(balance), 
                    new org.web3j.abi.datatypes.Bool(active), 
                    new org.web3j.abi.datatypes.Address(160, walletAddress));
            this.firstName = firstName;
            this.lastName = lastName;
            this.currentAge = currentAge;
            this.balance = balance;
            this.active = active;
            this.walletAddress = walletAddress;
        }

        public Customer(Utf8String firstName, Utf8String lastName, Uint256 currentAge, Uint256 balance, Bool active, Address walletAddress) {
            super(firstName, lastName, currentAge, balance, active, walletAddress);
            this.firstName = firstName.getValue();
            this.lastName = lastName.getValue();
            this.currentAge = currentAge.getValue();
            this.balance = balance.getValue();
            this.active = active.getValue();
            this.walletAddress = walletAddress.getValue();
        }
    }

    public static class PayoutEventResponse extends BaseEventResponse {
        public String receiver;

        public BigInteger payout;

        public Customer customer;
    }

    public static class RegistrationEventResponse extends BaseEventResponse {
        public String customerAddress;

        public Customer customer;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;

        public BigInteger balance;
    }
}
