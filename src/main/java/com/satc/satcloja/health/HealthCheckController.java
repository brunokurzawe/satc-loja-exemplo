package com.satc.satcloja.health;

import com.satc.satcloja.model.*;
import com.satc.satcloja.repository.ClienteRepository;
import com.satc.satcloja.repository.ProdutoRepository;
import com.satc.satcloja.repository.ServicoRepository;
import com.satc.satcloja.repository.VendaRepository;
import com.satc.satcloja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HealthCheckController {

    @Autowired
    public ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService produtoService;

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public VendaRepository vendaRepository;

    @Autowired
    public ServicoRepository servicoRepository;

    @GetMapping("/health")
    public String healthCheck() {

        Produto produto = new Produto();
        produto.setDescricao("Intel Pentium I5");
        produto.setNome("PC Intel");
        produto.setValorUnitario(1000.00);
        produto.setDataPrazo(LocalDate.now());
        produto.setDataValidade(LocalDate.now());
        produto.setPrecoCompra(850.00);
        produto.setStatus(Status.DISPONIVEL);
        produto.setEstocavel(Boolean.TRUE);

        produto = produtoRepository.save(produto);

        Servico servico = new Servico();
        servico.setQuantidadeHoras(20.00);
        servico.setDescricao("Instalação Office");
        servico.setEstocavel(Boolean.TRUE);
        servico.setValorUnitario(150.00);

        servico = servicoRepository.save(servico);

        Cliente cliente = new Cliente();
        cliente.setCpf("046969623");
        cliente.setRg("5224778");
        cliente.setNome("Bruno");
        cliente.setEmail("bruno.kurzawe@betha.com.br");
        cliente.setEndereco("Rua tal de tall");
        cliente.setTelefone("999089410");

        cliente = clienteRepository.save(cliente);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(LocalDate.now());
        venda.setObservacao("Teste");
        venda.setFormaPagamento(FormaPagamento.A_VISTA);

        ItemVenda itemVenda = new ItemVenda(produto, 1000.00, 1.0, 10.00);
        ItemVenda itemVenda2 = new ItemVenda(servico, 120.00, 1.0, 10.00);

        venda.addItemVenda(itemVenda);
        venda.addItemVenda(itemVenda2);

        vendaRepository.save(venda);

        return "OK";
    }

    @GetMapping("/teste")
    public String healthCheck2() {

        Produto produto = new Produto();
        produto.setDescricao("Intel Pentium I5");
        produto.setNome("PC Intel");
        produto.setValorUnitario(1000.00);
        produto.setDataPrazo(LocalDate.now());
        produto.setDataValidade(LocalDate.now());
        produto.setPrecoCompra(850.00);
        produto.setStatus(Status.DISPONIVEL);
        produto.setEstocavel(Boolean.TRUE);

        produtoRepository.save(produto);

        Servico servico = new Servico();
        servico.setQuantidadeHoras(20.00);
        servico.setDescricao("Instalação Office");
        servico.setEstocavel(Boolean.TRUE);
        servico.setValorUnitario(150.00);

        servico = servicoRepository.save(servico);

        Cliente cliente = new Cliente();
        cliente.setCpf("046969623");
        cliente.setRg("5224778");
        cliente.setNome("Bruno");
        cliente.setEmail("bruno.kurzawe@betha.com.br");
        cliente.setEndereco("Rua tal de tall");
        cliente.setTelefone("999089410");

        cliente = clienteRepository.save(cliente);

        return "Comando Executado!  " + produto.getId();
    }


    @GetMapping("/teste-produto")
    public String healthCheck3() {

        Produto produto = new Produto();
        produto.setDescricao("Intel Pentium I5");
        produto.setNome("PC Intel");
        produto.setValorUnitario(1000.00);
        produto.setDataPrazo(LocalDate.now());
        produto.setDataValidade(LocalDate.now());
        produto.setPrecoCompra(850.00);
        produto.setStatus(Status.DISPONIVEL);
        produto.setEstocavel(Boolean.TRUE);

        produto = produtoRepository.save(produto);

        Produto produto2 = new Produto();
        produto2.setDescricao("Intel Pentium I5");
        produto2.setNome("PC Intel");
        produto2.setValorUnitario(1000.00);
        produto2.setDataPrazo(LocalDate.now());
        produto2.setDataValidade(LocalDate.now());
        produto2.setPrecoCompra(850.00);
        produto2.setStatus(Status.DISPONIVEL);
        produto2.setEstocavel(Boolean.TRUE);

        produto2 = produtoRepository.save(produto2);

        Produto produto3 = new Produto();
        produto3.setDescricao("Intel Pentium I5");
        produto3.setNome("PC Intel");
        produto3.setValorUnitario(1000.00);
        produto3.setDataPrazo(LocalDate.now());
        produto3.setDataValidade(LocalDate.now());
        produto3.setPrecoCompra(850.00);
        produto3.setStatus(Status.ALUGADO);
        produto3.setEstocavel(Boolean.TRUE);

        produto3 = produtoRepository.save(produto3);


        return "";

    }



}
