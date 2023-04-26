// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;

contract BaloiseLifeInsurance{

    address private owner;
    uint256 private weiSent;
    address payable private ownerAddress;
    
    struct Customer { 
      string firstName;
      string lastName;
      uint currentAge;
      uint256 balance;
      bool active;
    }

    event Transfer(address sender, uint256 amount, uint256 balance);
    event Payout(address receiver, uint256 payout, Customer customer);

    mapping (address => Customer) private customers;
    uint public numberOfCustomers;

    constructor() {
        // 'msg.sender' is sender of current call, contract deployer for a constructor
        owner = msg.sender;
        //weiSent = msg.value;
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
        customers[_walletAddress].balance += amount;
        //ownerAddress.transfer(amount);

        // Emits the event defined earlier
        emit Transfer(_walletAddress, amount, customers[_walletAddress].balance);
    }

    function payout(address _walletAddress) public{
        require(customers[_walletAddress].currentAge >= 60, "The age of the insured person must be equal of above 60");

        uint256 payoutAmount = customers[_walletAddress].balance;
        customers[_walletAddress].balance -= payoutAmount;
        customers[_walletAddress].active = false;
        // Emits the event defined earlier
        emit Payout(_walletAddress, payoutAmount, customers[_walletAddress]);

    }

    function getContractBalance() public view returns (uint256){
        return address(this).balance;
    }


}