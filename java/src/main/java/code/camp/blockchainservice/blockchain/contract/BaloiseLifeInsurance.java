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
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03191633179055611233806100326000396000f3fe6080604052600436106100c65760003560e01c80638d85964c1161007f578063baac274d11610059578063baac274d14610213578063cb949e511461024c578063d715b75b1461026c578063da5411a91461028c57600080fd5b80638d85964c146101c85780639fb9e0f5146101e8578063a853409a146101fe57600080fd5b80630b7e9c441461012157806363bd1d4a14610141578063650d993b146101565780636f9fb98a1461018157806381e327c01461019e5780638c160186146101a657600080fd5b3661011c57306001600160a01b03166381e327c06040518163ffffffff1660e01b8152600401600060405180830381600087803b15801561010657600080fd5b505af115801561011a573d6000803e3d6000fd5b005b600080fd5b34801561012d57600080fd5b5061011a61013c366004610a1f565b6102b2565b34801561014d57600080fd5b5061011a610421565b34801561016257600080fd5b5061016b61042c565b6040516101789190610a93565b60405180910390f35b34801561018d57600080fd5b50475b604051908152602001610178565b61011a61049c565b3480156101b257600080fd5b506101bb610574565b6040516101789190610b0b565b3480156101d457600080fd5b5061011a6101e3366004610c0c565b6105b1565b3480156101f457600080fd5b5061019060035481565b34801561020a57600080fd5b50610190610611565b34801561021f57600080fd5b5061019061022e366004610a1f565b6001600160a01b031660009081526002602052604090206003015490565b34801561025857600080fd5b5061016b610267366004610a1f565b610673565b34801561027857600080fd5b5061011a610287366004610c79565b6107ff565b34801561029857600080fd5b503360009081526002602081905260409091200154610190565b6001600160a01b03811660009081526002602081905260409091200154603c111561034a5760405162461bcd60e51b815260206004820152603760248201527f54686520616765206f662074686520696e737572656420706572736f6e206d7560448201527f737420626520657175616c206f662061626f766520363000000000000000000060648201526084015b60405180910390fd5b6001600160a01b03811660009081526002602052604081206003018054918291906103758380610d0f565b90915550506001600160a01b038216600081815260026020526040808220600401805460ff191690555184929184156108fc02918591818181858888f193505050501580156103c8573d6000803e3d6000fd5b506001600160a01b0383166000908152600260205260409081902090517f4abd51f2b72ef8b73ee8993158f730a67a506c1c5e76ea40f5fe4abf2caec3e2916104149186918691610e47565b60405180910390a1505050565b61042a336102b2565b565b6104346109c6565b60405163cb949e5160e01b8152336004820152309063cb949e5190602401600060405180830381865afa15801561046f573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526104979190810190610ee4565b905090565b600034116104f85760405162461bcd60e51b8152602060048201526024808201527f54686520616d6f756e74206d75737420626520626967676572207468656e207a60448201526332b9379760e11b6064820152608401610341565b336000908152600260205260408120600301805434929061051a908490610fab565b909155505033600081815260026020908152604091829020600301548251938452349184019190915282820152517f7fa9aafeb8bb803d77de5d84bc2f2edbd842ca91b20cd5020aa21dfe26ab0be99181900360600190a1565b33600090815260026020908152604091829020915160609261059d929091600183019101611031565b604051602081830303815290604052905090565b60405163d715b75b60e01b8152309063d715b75b906105da908690869086903390600401611051565b600060405180830381600087803b1580156105f457600080fd5b505af1158015610608573d6000803e3d6000fd5b50505050505050565b60405163baac274d60e01b8152336004820152600090309063baac274d90602401602060405180830381865afa15801561064f573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104979190611098565b61067b6109c6565b6001600160a01b03821660009081526002602052604090819020815160c081019092528054829082906106ad90610d28565b80601f01602080910402602001604051908101604052809291908181526020018280546106d990610d28565b80156107265780601f106106fb57610100808354040283529160200191610726565b820191906000526020600020905b81548152906001019060200180831161070957829003601f168201915b5050505050815260200160018201805461073f90610d28565b80601f016020809104026020016040519081016040528092919081815260200182805461076b90610d28565b80156107b85780601f1061078d576101008083540402835291602001916107b8565b820191906000526020600020905b81548152906001019060200180831161079b57829003601f168201915b5050509183525050600282015460208201526003820154604082015260049091015460ff81161515606083015261010090046001600160a01b031660809091015292915050565b6001600160a01b03811660009081526002602052604090206004015460ff16156108915760405162461bcd60e51b815260206004820152603860248201527f437573746f6d6572207769746820746869732077616c6c65742061646472657360448201527f7320697320616c726561647920726567697374657265642e00000000000000006064820152608401610341565b6040805160c0810182528581526020808201869052818301859052600060608301819052600160808401526001600160a01b03851660a084018190528152600290915291909120815181906108e69082611100565b50602082015160018201906108fb9082611100565b5060408201516002820155606082015160038083019190915560808301516004909201805460a0909401516001600160a01b031661010002610100600160a81b0319931515939093166001600160a81b031990941693909317919091179091558054906000610969836111c0565b90915550506001600160a01b0381166000908152600260205260409081902090517fa0ba44081f18dd31796c193a037b7913d3d94b9c00edede813793b21c759b9e4916109b8918491906111d9565b60405180910390a150505050565b6040518060c001604052806060815260200160608152602001600081526020016000815260200160001515815260200160006001600160a01b031681525090565b6001600160a01b0381168114610a1c57600080fd5b50565b600060208284031215610a3157600080fd5b8135610a3c81610a07565b9392505050565b60005b83811015610a5e578181015183820152602001610a46565b50506000910152565b60008151808452610a7f816020860160208601610a43565b601f01601f19169290920160200192915050565b602081526000825160c06020840152610aaf60e0840182610a67565b90506020840151601f19848303016040850152610acc8282610a67565b91505060408401516060840152606084015160808401526080840151151560a084015260018060a01b0360a08501511660c08401528091505092915050565b602081526000610a3c6020830184610a67565b634e487b7160e01b600052604160045260246000fd5b60405160c0810167ffffffffffffffff81118282101715610b5757610b57610b1e565b60405290565b604051601f8201601f1916810167ffffffffffffffff81118282101715610b8657610b86610b1e565b604052919050565b600067ffffffffffffffff821115610ba857610ba8610b1e565b50601f01601f191660200190565b600082601f830112610bc757600080fd5b8135610bda610bd582610b8e565b610b5d565b818152846020838601011115610bef57600080fd5b816020850160208301376000918101602001919091529392505050565b600080600060608486031215610c2157600080fd5b833567ffffffffffffffff80821115610c3957600080fd5b610c4587838801610bb6565b94506020860135915080821115610c5b57600080fd5b50610c6886828701610bb6565b925050604084013590509250925092565b60008060008060808587031215610c8f57600080fd5b843567ffffffffffffffff80821115610ca757600080fd5b610cb388838901610bb6565b95506020870135915080821115610cc957600080fd5b50610cd687828801610bb6565b935050604085013591506060850135610cee81610a07565b939692955090935050565b634e487b7160e01b600052601160045260246000fd5b81810381811115610d2257610d22610cf9565b92915050565b600181811c90821680610d3c57607f821691505b602082108103610d5c57634e487b7160e01b600052602260045260246000fd5b50919050565b60008154610d6f81610d28565b808552602060018381168015610d8c5760018114610da657610dd4565b60ff1985168884015283151560051b880183019550610dd4565b866000528260002060005b85811015610dcc5781548a8201860152908301908401610db1565b890184019650505b505050505092915050565b60c082526000610df260c0840183610d62565b8381036020850152610e078160018501610d62565b600284015460408601526003840154606086015260049093015460ff81161515608086015260081c6001600160a01b031660a09094019390935250919050565b60018060a01b0384168152826020820152606060408201526000610e6e6060830184610ddf565b95945050505050565b600082601f830112610e8857600080fd5b8151610e96610bd582610b8e565b818152846020838601011115610eab57600080fd5b610ebc826020830160208701610a43565b949350505050565b80518015158114610ed457600080fd5b919050565b8051610ed481610a07565b600060208284031215610ef657600080fd5b815167ffffffffffffffff80821115610f0e57600080fd5b9083019060c08286031215610f2257600080fd5b610f2a610b34565b825182811115610f3957600080fd5b610f4587828601610e77565b825250602083015182811115610f5a57600080fd5b610f6687828601610e77565b6020830152506040830151604082015260608301516060820152610f8c60808401610ec4565b6080820152610f9d60a08401610ed9565b60a082015295945050505050565b80820180821115610d2257610d22610cf9565b60008154610fcb81610d28565b60018281168015610fe35760018114610ff857611027565b60ff1984168752821515830287019450611027565b8560005260208060002060005b8581101561101e5781548a820152908401908201611005565b50505082870194505b5050505092915050565b600061103d8285610fbe565b600160fd1b8152610e6e6001820185610fbe565b6080815260006110646080830187610a67565b82810360208401526110768187610a67565b604084019590955250506001600160a01b039190911660609091015292915050565b6000602082840312156110aa57600080fd5b5051919050565b601f8211156110fb57600081815260208120601f850160051c810160208610156110d85750805b601f850160051c820191505b818110156110f7578281556001016110e4565b5050505b505050565b815167ffffffffffffffff81111561111a5761111a610b1e565b61112e816111288454610d28565b846110b1565b602080601f831160018114611163576000841561114b5750858301515b600019600386901b1c1916600185901b1785556110f7565b600085815260208120601f198616915b8281101561119257888601518255948401946001909101908401611173565b50858210156111b05787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b6000600182016111d2576111d2610cf9565b5060010190565b6001600160a01b0383168152604060208201819052600090610ebc90830184610ddf56fea26469706673582212203d5a3cb6ac522e7fbfcd567945fb4fbe77b2793b0a4b21d66187444bb172927b64736f6c63430008130033";

    public static final String FUNC_addCustomer = "addCustomer";

    public static final String FUNC_GETCONTRACTBALANCE = "getContractBalance";

    public static final String FUNC_getCustomer = "getCustomer";

    public static final String FUNC_GETCUSTOMERAGE = "getCustomerAge";

    public static final String FUNC_getCustomerBalance = "getCustomerBalance";

    public static final String FUNC_GETFULLNAME = "getFullName";

    public static final String FUNC_NUMBEROFCUSTOMERS = "numberOfCustomers";

    public static final String FUNC_payout = "payout";

    public static final String FUNC_RECEIVEMOUNTLYPREMIUM = "receiveMountlyPremium";

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

    public RemoteFunctionCall<TransactionReceipt> addCustomer(String _firstName, String _lastName, BigInteger _currentAge) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_addCustomer, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_firstName), 
                new org.web3j.abi.datatypes.Utf8String(_lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(_currentAge)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addCustomer(String _firstName, String _lastName, BigInteger _currentAge, String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_addCustomer, 
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

    public RemoteFunctionCall<Customer> getCustomer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_getCustomer, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Customer>() {}));
        return executeRemoteCallSingleValueReturn(function, Customer.class);
    }

    public RemoteFunctionCall<Customer> getCustomer(String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_getCustomer, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Customer>() {}));
        return executeRemoteCallSingleValueReturn(function, Customer.class);
    }

    public RemoteFunctionCall<BigInteger> getCustomerAge() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCUSTOMERAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getCustomerBalance() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_getCustomerBalance, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getCustomerBalance(String _walletAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_getCustomerBalance, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
                FUNC_payout, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _walletAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> payout() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_payout, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> receiveMountlyPremium(BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECEIVEMOUNTLYPREMIUM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
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
