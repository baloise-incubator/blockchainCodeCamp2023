// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;

contract BaloiseLifeInsurance{
    
    struct Customer { 
      string firstName;
      string lastName;
      uint currentAge;
      uint256 balance;
      bool active;
      address walletAddress;
    }

    event Registration(address customerAddress, Customer customer);
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

    function addCustomer(string memory _firstName, string memory _lastName, uint _currentAge) public {
        require(!customers[msg.sender].active, "Customer with this wallet address is already registered.");
        //Add customer
        customers[msg.sender] = Customer(_firstName, _lastName, _currentAge, 0, true, msg.sender);
        //Since mapping structure does not have the iterator we need to tract the number of all customers in separate variable
        numberOfCustomers++;
        emit Registration(msg.sender, customers[msg.sender]);
    }

    function getCustomerAge() public view returns(uint){
         return customers[msg.sender].currentAge;
    }

    function getFullName() public view returns (string memory) {
        return string.concat(customers[msg.sender].firstName, " ", customers[msg.sender].lastName);
    }

    function payLifeInsurancePremium() public payable {
        require(msg.value > 0, "The amount must be bigger then zero.");
        //Contains the amount of Wei that was sent to the smart contract.
        customers[msg.sender].balance += msg.value;
        emit Transfer(msg.sender, msg.value, customers[msg.sender].balance);
    }

    function payout() public{
        require(customers[msg.sender].currentAge >= 60, "The age of the insured person must be equal of above 60");

        uint256 payoutAmount = customers[msg.sender].balance;
        customers[msg.sender].balance -= payoutAmount;
        customers[msg.sender].active = false;

        address payable customerWallet = payable(msg.sender);
        customerWallet.transfer(payoutAmount);

        // Emits the event defined earlier
        emit Payout(msg.sender, payoutAmount, customers[msg.sender]);

    }

    function getCustomerBalance() public view returns (uint256){
        return customers[msg.sender].balance;
    }

    function getCustomerce() public view returns (Customer memory){
        return customers[msg.sender];
    }

    function getContractBalance() public view returns (uint256){
        //A variable of the type address always has a property called .balance which gives you the amount of ether stored on that address.
        //It doesn't mean you can access them, it just tells you how much is stored there. 
        //Remember, it's all public information. address(this) converts the Smart Contract instance to an address. 
        //So, this line essentially returns the amount of Ether that are stored on the Smart Contract itself.
        return address(this).balance;
    }


}