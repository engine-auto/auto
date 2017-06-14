package com.auto.solr;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages={"com.acme.solr"}, multicoreSupport=true)
public class SolrContext {

  static final String SOLR_HOST = "spring.data.solr.host";

  @Resource private Environment environment;

  @Bean
  public HttpSolrServer solrServer() {
    String solrHost = environment.getRequiredProperty(SOLR_HOST);
    return new HttpSolrServer(solrHost);
  }
}