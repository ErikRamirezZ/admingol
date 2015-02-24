package com.raze.admingol.specifications;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.raze.admingol.domain.Sucursal;
import com.raze.admingol.domain.Torneo;
import com.raze.admingol.domain.Torneo_;

public class TorneoSpecifications {

	static Logger log = LoggerFactory.getLogger(TorneoSpecifications.class);
	
	public static Specification<Torneo> torneoInSucursales(final List<Sucursal> sucursales) {

		return new Specification<Torneo>() {
			
			@Override
			public Predicate toPredicate(Root<Torneo> torneoRoot,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return torneoRoot.get(Torneo_.sucursal).in(sucursales);
			}
		};
	}
	
}
