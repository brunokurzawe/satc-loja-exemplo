package com.satc.satcloja.repository;

import com.satc.satcloja.model.Fornecedor;
import com.satc.satcloja.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>  , QuerydslPredicateExecutor<Fornecedor> {
}
