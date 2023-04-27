package code.camp.blockchainservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
@Data
public class ServiceConfig {
    private String infuraToken;
    private String walletPassword;
    private String pathToWalletFile;
}
