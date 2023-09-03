package com.satc.satcloja.repository;

import com.satc.satcloja.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Servico, Long> {
}
