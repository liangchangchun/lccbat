package com.es.hmc.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "useraskinfo", type = "useraskinfo-type")
@Setting(settingPath = "/static/hmc-setting.json")
@Mapping(mappingPath = "/static/useraskinfo-mappings.json")
public class KbEsUseraskinfo {
	
	@Id
	private String id;
	@Field(type = FieldType.keyword , index = false , store = true)
	private String userPhone;
	@Field(type = FieldType.text, analyzer="ik_max_word", searchAnalyzer="ik_max_word", store = true)
	private String askerInfo;
	@Field(type = FieldType.Date, index = false , store = true)
	private Date  searchTime;
	@Field(type = FieldType.keyword , index = false , store = true)
	private String guid;
	
	
	
}
