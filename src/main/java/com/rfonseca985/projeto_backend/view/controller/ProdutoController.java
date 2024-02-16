package com.rfonseca985.projeto_backend.view.controller;

import com.rfonseca985.projeto_backend.services.ProdutoService;
import com.rfonseca985.projeto_backend.shared.ProdutoDTO;
import com.rfonseca985.projeto_backend.view.model.ProdutoRequest;
import com.rfonseca985.projeto_backend.view.model.ProdutoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controlador para manipulação de operações relacionadas a produtos via API REST.
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    /**
     * Obtém todos os produtos.
     *
     * @return ResponseEntity contendo uma lista de ProdutoResponse e o status HTTP.
     */
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterTodos() {
        List<ProdutoDTO> produtos = produtoService.obterTodos();
        ModelMapper mapper = new ModelMapper();
        List<ProdutoResponse> resposta = produtos.stream()
                .map(produtoDTO -> mapper.map(produtoDTO, ProdutoResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    /**
     * Obtém um produto pelo seu ID.
     *
     * @param id O ID do produto a ser obtido.
     * @return ResponseEntity contendo um ProdutoResponse e o status HTTP.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Integer id) {
        Optional<ProdutoDTO> dto = produtoService.obterPorId(id);
        ProdutoResponse response = new ModelMapper().map(dto.get(), ProdutoResponse.class);
        return new ResponseEntity<>(Optional.of(response), HttpStatus.OK);
    }

    /**
     * Adiciona um novo produto.
     *
     * @param request O objeto ProdutoRequest contendo os dados do novo produto.
     * @return ResponseEntity contendo um ProdutoResponse e o status HTTP.
     */
    @PostMapping
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest request) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO dto = mapper.map(request, ProdutoDTO.class);
        dto = produtoService.adicionar(dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoResponse.class), HttpStatus.CREATED);
    }

    /**
     * Deleta um produto pelo seu ID.
     *
     * @param id O ID do produto a ser deletado.
     * @return ResponseEntity com o status HTTP.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Atualiza um produto pelo seu ID.
     *
     * @param request O objeto ProdutoRequest contendo os dados atualizados.
     * @param id      O ID do produto a ser atualizado.
     * @return ResponseEntity contendo um ProdutoResponse e o status HTTP.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@RequestBody ProdutoRequest request, @PathVariable Integer id) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO dto = mapper.map(request, ProdutoDTO.class);
        dto = produtoService.atualizar(id, dto);
        return new ResponseEntity<>(
                mapper.map(dto, ProdutoResponse.class), HttpStatus.OK);
    }
}
