// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;

//Enable console.log function
import "hardhat/console.sol";

contract BaloiseLifeInsurance{
    
    struct Customer { 
      string firstName;
      string lastName;
      uint currentAge;
      uint256 balance;
      bool active;
    }

    event Transfer(address sender, uint256 amount, uint256 balance);
    event Payout(address receiver, uint256 payout, Customer customer);

    address private owner;
    address payable private ownerAddress;
    mapping (address => Customer) private customers;
    uint public numberOfCustomers;

    constructor() {
        // 'msg.sender' is sender of current call, contract deployer for a constructor
        owner = msg.sender;
    }

    function addCustomer(string memory _firstName, string memory _lastName, uint _currentAge, address _walletAddress) public {
        //Add customer
        customers[_walletAddress] = Customer(_firstName, _lastName, _currentAge, 0, true);
        //Since mapping structure does not have the iterator we need to tract the number of all customers in separate variable
        numberOfCustomers++;
    }

    function getCustomerAge(address _walletAddress) public view returns(uint){
         return customers[_walletAddress].currentAge;
    }

    function getFullName(address _walletAddress) public view returns (string memory) {
        return string.concat(customers[_walletAddress].firstName, " ", customers[_walletAddress].lastName);
    }

    function mountlyPay(address _walletAddress, uint amount) public {
        require(amount > 0, "The amount must be bigger then zero.");
        require(customers[_walletAddress].active, "The user has been payed out");
        customers[_walletAddress].balance += amount;
        //ownerAddress.transfer(amount);

        // Emits the event defined earlier
        emit Transfer(_walletAddress, amount, customers[_walletAddress].balance);
    }

    function payLifeInsurancePremium(address _walletAddress) public payable {
        require(msg.value > 0, "The amount must be bigger then zero.");
        //Contains the amount of Wei that was sent to the smart contract.
        customers[_walletAddress].balance += msg.value;
        console.log("Premium payed - customer: '%s %s' amount: %s", customers[_walletAddress].firstName, customers[_walletAddress].lastName, msg.value);
        console.log("Contract balance: %s", address(this).balance);
    }

    function payout(address _walletAddress) public{
        require(customers[_walletAddress].currentAge >= 60, "The age of the insured person must be equal of above 60");
    

        uint256 payoutAmount = customers[_walletAddress].balance;
        customers[_walletAddress].balance -= payoutAmount;
        customers[_walletAddress].active = false;

        address payable customerWallet = payable(_walletAddress);
        customerWallet.transfer(payoutAmount);

        console.log("Payout to address: %s amount: %s", _walletAddress, payoutAmount);

        // Emits the event defined earlier
        emit Payout(_walletAddress, payoutAmount, customers[_walletAddress]);

    }

    function getCustomerBalance(address _walletAddress) public view returns (uint256){
        console.log("Customer %s %s has balance of: %s", customers[_walletAddress].firstName, customers[_walletAddress].lastName, customers[_walletAddress].balance);
        return customers[_walletAddress].balance;
    }

    function getContractBalance() public view returns (uint256){
        console.log("Contract balance: %s", address(this).balance);
        //A variable of the type address always has a property called .balance which gives you the amount of ether stored on that address. 
        //It doesn't mean you can access them, it just tells you how much is stored there. 
        //Remember, it's all public information. address(this) converts the Smart Contract instance to an address. 
        //So, this line essentially returns the amount of Ether that are stored on the Smart Contract itself.
        return address(this).balance;
    }


}