package com.example.authresourceserver.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {   // Used to configure Authorization Server Security which means security of /oauth/token endpoint
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {  // Used to configure the Client Details for OAuth2 (Configure the ClientDetailsService)

        /**
         * @see <a href="https://docs.spring.io/spring-security/oauth/apidocs/org/springframework/security/oauth2/provider/ClientDetailsService.html"></a>
         */


        clients.inMemory()
                .withClient("ClientId")
                .secret("secure")
                .authorizedGrantTypes("authorization_code")
                .scopes("user_info")
                .autoApprove(true);
    }


}
