package com.rfonseca985.projeto_backend.services;

import com.rfonseca985.projeto_backend.model.Produto;
import com.rfonseca985.projeto_backend.model.excepition.ResourceNotFoundExcepition;
import com.rfonseca985.projeto_backend.repository.ProdutoRepository;
import com.rfonseca985.projeto_backend.repository.ProdutoRepositoryOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.findById(id);
    }

    public Produto adicionar(Produto produto){
        return produtoRepository.save(produto);
    }
    public void deletar(Integer id){
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(Integer id, Produto produtoAtualizado){
        // Verificar se o produto com o ID fornecido existe no banco de dados
        Optional<Produto> produtoExistenteOptional = produtoRepository.findById(id);

        if (produtoExistenteOptional.isPresent()) {
            // Atualizar os dados do produto existente com os dados do produtoAtualizado
            Produto produtoExistente = produtoExistenteOptional.get();
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setValor(produtoAtualizado.getValor());
            produtoExistente.setObservacao(produtoAtualizado.getObservacao());
            // Outros campos que você deseja atualizar

            // Salvar as alterações no banco de dados
            return produtoRepository.save(produtoExistente);
        } else {
            // Se o produto com o ID fornecido não existe, você pode escolher lançar uma exceção ou lidar de outra forma
            // Neste exemplo, estamos retornando null, mas é recomendável tratar isso de uma maneira mais robusta
            return null;
        }
    }
}
