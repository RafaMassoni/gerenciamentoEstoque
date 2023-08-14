package br.com.estoque.controller;



import br.com.estoque.Deposito;
import br.com.estoque.mapper.DepositoMapper;
import br.com.estoque.request.DepositoRequest;
import br.com.estoque.response.DepositoResponse;
import br.com.estoque.services.DepositoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposito")
public class DepositoController {

    @Autowired
    private DepositoService depositoService;

    private final DepositoMapper depositoMapper = DepositoMapper.INSTANCE;

    @GetMapping
    private ResponseEntity< Page<Deposito>> buscarTodos(Pageable pageable)
    {
        Page<Deposito> depositoPage = depositoService.buscarTodos(pageable);
        return ResponseEntity.ok(depositoPage);
    }

    @PostMapping
    private ResponseEntity<DepositoResponse> inserirDeposito(@Valid @RequestBody DepositoRequest depositoRequest)
    {
        Deposito deposito = depositoMapper.toModel(depositoRequest);
        deposito = depositoService.inserir(deposito);
        DepositoResponse depositoResponse = depositoMapper.toResponse(deposito);

        return ResponseEntity.ok(depositoResponse);
    }

    @GetMapping("/{idDeposito}")
    private ResponseEntity<Deposito> buscarDeposito(@PathVariable Long idDeposito)
    {
        Deposito deposito = depositoService.buscarPorId(idDeposito);
        return ResponseEntity.ok(deposito);
    }


    @PutMapping("/{idDeposito}")
    private ResponseEntity<DepositoResponse> atualizarDeposito(@PathVariable Long idDeposito,
                                                               @Valid @RequestBody DepositoRequest depositoRequest)
    {
        Deposito deposito = depositoMapper.toModel(depositoRequest);
        deposito.setId(idDeposito);

        deposito = depositoService.atualizar(deposito);
        DepositoResponse depositoResponse = depositoMapper.toResponse(deposito);

        return ResponseEntity.ok(depositoResponse);
    }

    @DeleteMapping("/{idDeposito}")
    private ResponseEntity<String> removerDeposito(@PathVariable Long idDeposito)
    {
       depositoService.removerPorId(idDeposito);
        return ResponseEntity.ok("Removido com sucesso!");
    }

}
