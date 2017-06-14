package com.auto.solr.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.beans.Field;

public class BaseBean {
	// 索引ID
	@Field
	private String id;
	// 命中高亮词
	private Map<String, String> highLight = new HashMap<String, String>();
	// 得分
	private java.lang.Float score = null;

	/**
	 * 索引ID
	 * 
	 * @author zqf
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 索引ID
	 * 
	 * @author zqf
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 命中高亮词
	 * 
	 * @author zqf
	 * @return
	 */
	public Map<String, String> getHighLight() {
		return highLight;
	}

	/**
	 * 命中高亮词
	 * 
	 * @author zqf
	 * @param heighLight
	 */
	public void setHighLight(Map<String, String> highLight) {
		this.highLight = highLight;
	}

	public java.lang.Float getScore() {
		return score;
	}

	public void setScore(java.lang.Float score) {
		this.score = score;
	}
}
