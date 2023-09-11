package com.satc.satcloja.repository;

import com.satc.satcloja.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, QuerydslPredicateExecutor<Cliente> {
}

