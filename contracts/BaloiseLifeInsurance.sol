// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;

contract BaloiseLifeInsurance{

    address private contractOwner;
    
    struct Customer { 
      string firstName;
      string lastName;
      uint256 currentFund;
      uint currentAge;
    }

    Customer private customer;

    constructor() {
        contractOwner = msg.sender; // 'msg.sender' is sender of current call, contract deployer for a constructor
    }

    function addCustomer(string memory _firstName, string memory _lastName, uint _currentAge) public {
        customer.firstName = _firstName;
        customer.lastName = _lastName;
        customer.currentAge = _currentAge;
    }

    function getCustomerAge() public view returns(uint){
         return customer.currentAge;
    }

    function getFullName() public view returns (string memory) {
        return string.concat(customer.firstName, customer.lastName);
    }


}