# Guide for developers
## Local development
For local development useful video:
https://www.youtube.com/watch?v=VPrSnLdE-A0&ab_channel=CodePulse

We are using Online RemixIDE. There is possibility to connect it with local
file space where you can open in your favourite ide and write Solidity code with
help of https://www.npmjs.com/package/@remix-project/remixd which will open
a socket from your local file system to the ide, just run this from the dir where contract is:
```
remixd -s .
```

After writing contract, one needs to compile it and then click on deploy
in RemixIDE.

## Generating a java class out of a solidity file
1. Generate ```BaloiseLifeInsurance.bin``` and ```BaloiseLifeInsurance.abi``` files from ```BaloiseLifeInsurance.sol``` file
```
solc BaloiseLifeInsurance.sol --bin --abi --optimize -o /path/to/this/repository/blockchainCodeCamp2023/java
```

2. Generate java class out of ```.bin``` and ```.abi``` files
```
web3j solidity generate -b /path/to/this/repository/blockchainCodeCamp2023/java/BaloiseLifeInsurance.bin -a /Users/kolja/Documents/CodeCamps/blockchainCodeCamp2023/java/BaloiseLifeInsurance.abi -o /Users/kolja/Documents/CodeCamps/blockchainCodeCamp2023/java/src/main/java -p code.camp.blockchainservice.contract
```
Taken from https://www.baeldung.com/smart-contracts-ethereum-solidity