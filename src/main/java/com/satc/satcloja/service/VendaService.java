package com.satc.satcloja.service;


import com.satc.satcloja.model.ItemVenda;
import com.satc.satcloja.model.Venda;
import com.satc.satcloja.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;


    public Venda salvarVenda(Venda venda) {



        Venda save = vendaRepository.save(venda);
        return save;
    }


}
