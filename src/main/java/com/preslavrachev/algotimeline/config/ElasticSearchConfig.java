package com.preslavrachev.algotimeline.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by preslavrachev on 13/02/16.
 */
@Configuration
public class ElasticSearchConfig {

    //TODO: Extract connection related properties into a file
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 9300;

    @Bean
    public Client elasticClient() throws UnknownHostException {
        // @formatter:off
        return TransportClient
                .builder()
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST),  PORT));
        // @formatter:on
    }

}
