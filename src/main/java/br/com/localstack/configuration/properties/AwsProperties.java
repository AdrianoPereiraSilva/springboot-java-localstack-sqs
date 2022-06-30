package br.com.localstack.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
public class AwsProperties {

    @Value("${cloud.aws.region.static}")
    public String region;

    @Value("${cloud.aws.credentials.access-key}")
    public String accessKeyId;

    @Value("${cloud.aws.credentials.secret-key}")
    public String secretAccessKey;

    @Value("${cloud.aws.end-point.uri}")
    public String sqsUrl;
}
