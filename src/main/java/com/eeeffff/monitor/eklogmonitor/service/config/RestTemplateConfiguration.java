package com.eeeffff.monitor.eklogmonitor.service.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 忽略自定义证书认证的restTemplate
 * 
 * @author fenglibin
 *
 */
@Configuration
public class RestTemplateConfiguration {

	@Autowired
	private AppMonitorProperties elasticSearchProperties;

	@Bean("allowAllHttpsRestTemplate")
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		restTemplateBuilder = restTemplateBuilder.requestFactory(() -> {
			TrustStrategy acceptingTrustStrategy = (chain, authType) -> true;
			SSLContext sslContext;
			try {
				sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			} catch (KeyManagementException e) {
				throw new RuntimeException(e);
			} catch (KeyStoreException e) {
				throw new RuntimeException(e);
			}
			SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("https", csf).register("http", new PlainConnectionSocketFactory()).build();

			BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager(
					socketFactoryRegistry);

			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf)
					.setConnectionManager(connectionManager).setMaxConnTotal(1000).setMaxConnPerRoute(1000).build();

			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
					httpClient);

			return requestFactory;
		});
		if (StringUtils.isNotEmpty(elasticSearchProperties.getEsUsername())
				&& StringUtils.isNotEmpty(elasticSearchProperties.getEsPassword())) {
			restTemplateBuilder = restTemplateBuilder.basicAuthentication(elasticSearchProperties.getEsUsername(),
					elasticSearchProperties.getEsPassword());
		}
		return restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(10)).setReadTimeout(Duration.ofSeconds(60))
				.build();
	}
}