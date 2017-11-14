package com.es.hmc.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.es.hmc.domain.KbEsUseraskinfo;

@Repository
public interface KbEsUseraskinfoRepository extends ElasticsearchRepository<KbEsUseraskinfo, String> {

}
