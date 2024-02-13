package com.rfonseca985.projeto_backend.services;

import com.rfonseca985.projeto_backend.model.Produto;
import com.rfonseca985.projeto_backend.model.excepition.ResourceNotFoundExcepition;
import com.rfonseca985.projeto_backend.repository.ProdutoRepository;
import com.rfonseca985.projeto_backend.shared.ProdutoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Serviço responsável por operações relacionadas a produtos.
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Obtém uma lista de todos os produtos no sistema.
     *
     * @return Lista de objetos ProdutoDTO representando os produtos.
     */
    public List<ProdutoDTO> obterTodos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Obtém um produto pelo seu ID.
     *
     * @param id O ID do produto a ser obtido.
     * @return Optional contendo um objeto ProdutoDTO se encontrado.
     * @throws ResourceNotFoundExcepition Se o produto com o ID fornecido não for encontrado.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id) {
        Optional<Produto> produtos = produtoRepository.findById(id);
        if (produtos.isEmpty()) {
            throw new ResourceNotFoundExcepition("Produto com id: " + id + " não encontrado");
        }
        ProdutoDTO dto = new ModelMapper().map(produtos.get(), ProdutoDTO.class);
        return Optional.of(dto);
    }

    /**
     * Adiciona um novo produto ao sistema.
     *
     * @param produtoDto O objeto ProdutoDTO a ser adicionado.
     * @return O ProdutoDTO do produto adicionado.
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto) {
        produtoDto.setId(null);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produto = produtoRepository.save(produto);
        produtoDto.setId(produto.getId());
        return produtoDto;
    }

    /**
     * Deleta um produto pelo seu ID.
     *
     * @param id O ID do produto a ser deletado.
     * @throws ResourceNotFoundExcepition Se o produto com o ID fornecido não for encontrado.
     */
    public void deletar(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            throw new ResourceNotFoundExcepition("Produto id: " + id + " não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    /**
     * Atualiza um produto pelo seu ID.
     *
     * @param id         O ID do produto a ser atualizado.
     * @param produtoDto O ProdutoDTO com as informações atualizadas.
     * @return O ProdutoDTO atualizado.
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {
        produtoDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produtoRepository.save(produto);
        return produtoDto;
    }
}
