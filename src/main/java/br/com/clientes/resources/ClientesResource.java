package br.com.clientes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.clientes.body.Clientes;
import br.com.clientes.entities.ClientesEntity;
import br.com.clientes.exception.ClientesNotFound;
import br.com.clientes.services.ClientesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "brasilprev")
public final class ClientesResource {

    @Autowired
    private ClientesService service;

    @ResponseBody
    @ApiOperation(value = "Buscar todos os Clientes")
    @GetMapping(path = "/clientes")
    public ResponseEntity<?> getAll(Pageable pageable) {

        Page<ClientesEntity> clientes = service.getAll(pageable);

        if (clientes == null) {
            return (ResponseEntity<?>) ResponseEntity.noContent();
        }
        return ResponseEntity.ok(clientes);

    }

    @ResponseBody
    @ApiOperation(value = "Busca por id Cliente")
    @GetMapping(path = "/clientes/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {

        ClientesEntity clientes = service.get(id);

        if (clientes == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);

    }

    @RequestBody
    @ApiOperation(value = "adicionar novo cliente")
    @PostMapping(path = "/clientes/novo")
    public ResponseEntity<?> post(Clientes clientes) {

        try {
            return ResponseEntity.ok(service.insertOrUpdate(clientes));

        } catch (Exception e) {

            return ResponseEntity.status(500).build();
        }

    }

    @RequestBody
    @ApiOperation(value = "Atualizar Cliente")
    @PutMapping(path = "/clientes/{id}")
    public ResponseEntity<?> put(@PathVariable("id") Long id, Clientes clientes) {

        ClientesEntity entity = service.get(id);

        try {
            return ResponseEntity.ok(service.insertOrUpdate(clientes));

        } catch (Exception e) {

            return ResponseEntity.status(500).build();
        }

    }

    @RequestBody
    @ApiOperation(value = "inativar cliente")
    @DeleteMapping(path = "/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.status(200).build();
        } catch (ClientesNotFound e) {
            return ResponseEntity.noContent().build();
        }
    }

}
