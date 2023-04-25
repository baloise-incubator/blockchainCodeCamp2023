# blockchainCodeCamp2023

## Smart contract and Remix
What is smart contract, pls read here:
https://ethereum.org/en/developers/docs/smart-contracts/anatomy/

For creating smart contract we use [Remix IDE](https://remix.ethereum.org/) and [Solidity](https://docs.soliditylang.org/en/v0.8.17/introduction-to-smart-contracts.html) language

There you can create contract, however deployment would be  local and not
published to any network. In order to be able to publish smart contract
to public blockchain network like Ethereum one needs to connect remix online
ide with wallet. We used [Metamsk](https://metamask.io/)
Usefull video can be found here:
https://www.youtube.com/watch?v=VPrSnLdE-A0&ab_channel=CodePulse

Once we have contract written we need to put it "live" which means it has
to be deployed on some block chain network. We chose official ethereum test
network [Sepolia](https://ethereum.org/en/developers/docs/networks/)
In order to deploy this smart contract one test network one needs ethereum
coins to pay for contract deployment. For test environment currency is SepoliaETH.
One can aquire 0.5SepoliaETH for free on following way:
1. Go to this address https://sepoliafaucet.com/
2. Here you will be asked to reate account on [Alchemy](https://www.alchemy.com/)
3. in the field on the page in first step enter your hash of metamask wallet
4. wait for one minute and the mony will arrive on account
Now we can use Remix and have funds on account to publish on Sepolia test network