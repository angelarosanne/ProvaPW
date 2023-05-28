package tads.eaj.ufrn.aulamvccrud.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.aulamvccrud.model.Produto;
import tads.eaj.ufrn.aulamvccrud.service.ProdutoService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/cadastrarPage")
    public String getCadastrarPage(Model model){
        Produto p = new Produto();
        model.addAttribute("produto", p);
        return "cadastrarPage";
    }
    @PostMapping("/doSalvar")
    public String doSalvar(@ModelAttribute @Valid Produto p, Errors errors){
        if (errors.hasErrors()){
            return "cadastrarPage";
        }else{
            service.save(p);
            return "redirect:/index";
        }
    }

    @GetMapping("/editarPage/{id}")
    public String getEditarPage(@PathVariable(name = "id") String id, Model model){

        Optional<Produto> p = service.findById(id);
        if (p.isPresent()){
            model.addAttribute("produto", p.get());
        }else{
            return "redirect:/index";
        }

        return "editarPage";
    }

    @GetMapping("/deletar/{id}")
    public String doDeletar(@PathVariable(name = "id") String id){
        Optional<Produto> produto = service.findById(id);
        if (produto.isPresent()) {
            service.delete(id);
        }
        return "redirect:/index";
    }
}



