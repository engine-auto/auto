package com.auto.solr;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.auto.solr.bean.BaseBean;

public interface SolrProductRepository extends
		SolrCrudRepository<BaseBean, String> {

	Page<BaseBean> findByPopularity(Integer popularity, Pageable page);

	Page<BaseBean> findByNameOrDescription(@Boost(2) String name,
			String description, Pageable page);

	@Highlight
	HighlightPage<BaseBean> findByNameIn(Collection<String> name, Page page);

	@Query(value = "name:?0")
	@Facet(fields = { "cat" }, limit = 20)
	FacetPage<BaseBean> findByNameAndFacetOnCategory(String name, Pageable page);
}