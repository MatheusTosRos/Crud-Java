package com.example.demo.controllers;

import com.example.demo.models.LivroModel;
import com.example.demo.services.LivroSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class LivroController {

    @Autowired
    private LivroSevice livroSevice;

    @GetMapping("/todosLivros")
    public List<LivroModel> getLivrosAll() {
        List<LivroModel> livros = livroSevice.findAll();
        return livros;
    }

    @GetMapping("/{id}")
    public LivroModel getLivrosById(@PathVariable Long id) {
        LivroModel livro = livroSevice.findById(id);
        return livro;
    }

    @PostMapping("/novoLivro")
    public LivroModel createLivro(@RequestBody LivroModel livroModel) {

        return livroSevice.create(livroModel);
    }

//    @DeleteMapping
//    public void deleteLivro()
}