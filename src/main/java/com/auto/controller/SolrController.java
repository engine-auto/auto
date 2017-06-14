package com.auto.controller;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolrController {

    @Autowired
    private SolrClient client;

    @RequestMapping("/testSolr")
    public String testSolr() throws IOException, SolrServerException {
        SolrDocument document = client.getById("core1", "904072");
        System.out.println(document);
        return document.toString();
    }
    
}