package com.produto.apirest.resources;

import java.util.List;

import com.produto.apirest.models.Produto;
import com.produto.apirest.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST PRODUTOS")
@CrossOrigin(origins = "*")
public class ProdutoResource {
    
    @Autowired
    ProdutoRepository produtos;

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos")
    public List<Produto> listaProdutos(){
        return produtos.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Retorna um produto unico")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id){
        return produtos.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Salva um produto")
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtos.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "Deleta um produto")
    public void deletarProduto(@PathVariable(value="id") long id){
        produtos.deleteById(id);
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualiza um produto")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtos.save(produto);
    }
}
