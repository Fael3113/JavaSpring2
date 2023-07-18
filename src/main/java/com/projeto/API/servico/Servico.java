package com.projeto.API.servico;

import com.projeto.API.modelo.Mensagem;
import com.projeto.API.modelo.Pessoa;
import com.projeto.API.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    public ResponseEntity<?> cadastrar(Pessoa obj){

        if(obj.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

}
