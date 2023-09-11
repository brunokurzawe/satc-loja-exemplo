package com.satc.satcloja.repository;

import com.satc.satcloja.model.Servico;
import com.satc.satcloja.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>, QuerydslPredicateExecutor<Venda> {
}
