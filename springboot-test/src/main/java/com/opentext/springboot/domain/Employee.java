package com.opentext.springboot.domain;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Data;

@SolrDocument(solrCoreName = "testCollection")
@Data
public class Employee {

	@Id
	@Field
	private int id;

	@Field
	private String username;

	@Field
	private String manager;

}
