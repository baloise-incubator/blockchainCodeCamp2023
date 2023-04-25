// SPDX-License-Identifier: MIT
pragma solidity ^0.6.0;
//contract keyword is like Class in Java
contract SimpleStorage {

    //unsigned integer - automatically initialized to 0
    //public variable
    uint256 favoriteNumber;
    // bool favoriteBool = false;
    // string favoriteString = "String";
    // int256 favoriteInt = -5;
    // address favoriteAddress= 0xD166B90156f25F5CD2e4B9D3cdC35F9F283C75C3;
    // bytes32 favoriteBytes = "cat";

    //way to define new type in Solidity
    struct People{
        uint256 favoriteNumber;
        string name;
    }

    //Dunamic array - can change its size
    People[] public people;
    mapping(string => uint256) public nameToFavoriteNumber;

    //People public person = People({favoriteNumber: 2, name: "Patrick"});

     function store(uint256 _favoriteNumber) public {
         favoriteNumber =  _favoriteNumber;
     }

     //'view': read of the blockchain, 'pure' keywords are used on functions which do not make a transaction.
     //Smart Contract button is blue if this is view function or public variable (are automatically view functions), because these do not make a transaction.
     function retrive() public view returns(uint256){
         return favoriteNumber;
     }
    
     //pure functions are used for calculations but do not save the state
     function retrivePure(uint256 favoriteNumber) public pure {
         favoriteNumber + favoriteNumber;
     }
     //we can store data in memory(data will be stored only during the execution of the function)
     // or in storage (data will persist even after function executes). We must decide that only for Objects and not for primitive types.
     function addPerson(string memory _name, uint256 _favoriteNumber) public {
         people.push(People(_favoriteNumber, _name));
         nameToFavoriteNumber[_name] = _favoriteNumber;
     }

     

}