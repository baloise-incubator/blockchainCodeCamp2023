# blockchainCodeCamp2023

## Smart contract and Remix
What is smart contract, pls read here:
https://ethereum.org/en/developers/docs/smart-contracts/anatomy/

For creating smart contract we use [Remix IDE](https://remix.ethereum.org/) and [Solidity](https://docs.soliditylang.org/en/v0.8.17/introduction-to-smart-contracts.html) language

There you can create contract, however by default deployment would be in
local javascript based blockchain that run in the browser and not to real ethereum blockchain
published to any network. In order to be able to publish smart contract
to public blockchain network like Ethereum one needs to connect remix online
ide with wallet. We used [Metamask](https://metamask.io/)
Usefull video can be found here:
https://www.youtube.com/watch?v=VPrSnLdE-A0&ab_channel=CodePulse

Once we have contract written we need to put it "live" which means it has
to be deployed on some blockchain network. We chose official ethereum test
network [Sepolia](https://ethereum.org/en/developers/docs/networks/)
In order to deploy this smart contract one test network one needs ethereum
coins to pay for contract deployment. For test environment currency is SepoliaETH.
One can aquire 0.5SepoliaETH for free on following way:
1. Go to this address https://sepoliafaucet.com/
2. Here you will be asked to reate account on [Alchemy](https://www.alchemy.com/)
3. in the field on the page in first step enter your hash of metamask wallet
4. wait for one minute and the mony will arrive on account
Now we can use Remix and have funds on account to publish on Sepolia test network

Interesting stuff:
Solidty does not work with decimal because all payments can be done WEI(10^18 WEI = 1 ETH). 
There's no need to use fractional values - all values are represented in wei, which is the
smallest unit of ether.

## Maximum contract storage
https://ethereum.stackexchange.com/questions/1038/is-there-a-theoretical-limit-for-amount-of-data-that-a-contract-can-store
Contract storage is a key of 32 bytes and a value of 32 bytes, so the maximum a single contract can store is around 1.46 GB (32^32).

# Link collection
- https://remix.ethereum.org
- https://www.baeldung.com/smart-contracts-ethereum-solidity
- https://sepolia.etherscan.io/
