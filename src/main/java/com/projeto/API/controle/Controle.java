package com.projeto.API.controle;

import com.projeto.API.modelo.Pessoa;
import com.projeto.API.repositorio.Repositorio;
import com.projeto.API.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }

    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable int codigo){
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }

    @GetMapping("api/contador")
    public long contador(){
        return acao.count();
    }

    @GetMapping("api/ordernarNomes")
    public List<Pessoa> ordernarNomes(){
        return acao.findByOrderByNome();
    }

    @GetMapping("api/ordernarIdade")
    public List<Pessoa> ordernarIdade(){
        return acao.findByOrderByIdade();
    }

    @GetMapping("api/ordernarporNome")
    public List<Pessoa> ordernarporNome(){
        return acao.findByNomeOrderByIdade("Marcelo");
    }

    @GetMapping("api/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("r");
    }

    @GetMapping("api/iniciaCom")
    public  List<Pessoa> iniciaCom(){
        return acao.findByNomeStartsWith("m");
    }

    @GetMapping("api/terminaCom")
    public  List<Pessoa> terminaCom(){
        return acao.findByNomeEndsWith("o");
    }

    @GetMapping("api/somaIdades")
    public int somaIdades(){
        return acao.somaIdades();
    }

    @GetMapping("api/idadeMaiorque")
    public List<Pessoa> idadeMaiorIgual(){
        return acao.idadeMaiorIgual(25);
    }

    @GetMapping("")
    public String mensagem(){
        return "Ola Mundo!";
    }
    
    @GetMapping("/boasVindas/")
    public String boasVindas(){
        return "Seja bem vindo(a) ";
    }
    
    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo(a) " + nome;
    }
    
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
