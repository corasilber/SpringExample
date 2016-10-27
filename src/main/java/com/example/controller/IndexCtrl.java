package com.example.controller;

import com.example.entity.Pessoa;
import com.example.model.PessoaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by grayson on 27/10/16.
 */
@RestController
@RequestMapping("/rest")
public class IndexCtrl {


    private PessoaDAO pessoaDAO;

    @Autowired
    public IndexCtrl(PessoaDAO pessoaDAO){
        this.pessoaDAO = pessoaDAO;
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> index(@RequestParam(value = "nome", required = false) String nome){
        if(nome != null){
            return pessoaDAO.getPessoaWithNameLike(nome);
        }else{
            return pessoaDAO.getAll();
        }
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa){
        return pessoaDAO.inserirPessoa(pessoa);

    }






}
