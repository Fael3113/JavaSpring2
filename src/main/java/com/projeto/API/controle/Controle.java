package com.projeto.API.controle;

import com.projeto.API.modelo.Cliente;
import com.projeto.API.modelo.Pessoa;
import com.projeto.API.repositorio.Repositorio;
import com.projeto.API.servico.Servico;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
    }

    @PutMapping("/api/editar")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return servico.remover(codigo);
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
    
    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo(a) " + nome;
    }
    
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }

    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente obj){

    }
}
