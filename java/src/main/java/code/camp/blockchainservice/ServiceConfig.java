package code.camp.blockchainservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "config")
@Data
public class ServiceConfig {
    private String infuraToken;

    private String customer1WalletFile;
    private String customer1Password;
    private String customer2WalletFile;
    private String customer2Password;
}
