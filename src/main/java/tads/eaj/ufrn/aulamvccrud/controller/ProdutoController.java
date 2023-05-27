package tads.eaj.ufrn.aulamvccrud.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.aulamvccrud.model.Produto;
import tads.eaj.ufrn.aulamvccrud.service.ProdutoService;

import java.util.List;

@Controller
public class ProdutoController {

    ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String getIndex(Model model){

        List<Produto> produtoList = service.findAll();
        model.addAttribute("produtoList", produtoList);
        model.addAttribute("estiloUser", "estilos.css");
        return "index.html";
    }

//    @GetMapping("/cadastrarPage")
//    public String getCadastrarPage(Model model){
//        Produto p = new Produto();
//        model.addAttribute("postagem", p);
//        return "cadastrarPage";
//    }
//
//    @PostMapping("/adicionarCarrinho")
//    public String doAdicionarCarrinho(@ModelAttribute @Valid Produto p, Errors errors){
//        if (errors.hasErrors()){
//            return "index";
//        }else{
//            service.save(p);
//            return "redirect:/index";
//        }
//    }spring:
//  datasource:
//    url: jdbc:postgresql://${DATABASE_HOST}:${DATABASE_PORT}/${DATABASE_NAME}?serverTimezone=UTC
//    username: ${DATABASE_USERNAME}
//    password: ${DATABASE_PASSWORD}
//    driver-class-name: org.postgresql.Driver
//  jpa:
//    show-sql: true
//    properties:
//      hibernate:
//        dialect: org.hibernate.dialect.PostgreSQLDialect
//    generate-ddl: true
//    hibernate:
//      ddl-auto: update
//    @GetMapping("/editarPage/{id}")
//    public String getEditarPage(@PathVariable(name = "id") String id, Model model){
//
//        Optional<Produto> p = service.findById(id);
//        if (p.isPresent()){
//            model.addAttribute("postagem", p.get());
//        }else{
//            return "redirect:/index";
//        }
//
//        return "editarPage";
//    }
//
//    @GetMapping("/deletar/{id}")
//    public String doDeletar(@PathVariable(name = "id") String id){
//        Optional<Produto> postagem = service.findById(id);
//        if (postagem.isPresent()) {
//            service.delete(id);
//        }
//        return "redirect:/index";
//    }
}



