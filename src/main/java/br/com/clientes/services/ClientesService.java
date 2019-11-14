package br.com.clientes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.clientes.body.Clientes;
import br.com.clientes.entities.ClientesEntity;
import br.com.clientes.exception.ClientesNotFound;
import br.com.clientes.repositories.ClientesRepository;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    public Page<ClientesEntity> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    public ClientesEntity get(Long idCliente) {
        Optional<ClientesEntity> subEmitterOp = repository.findById(idCliente);

        if (subEmitterOp.isPresent()) {
            return subEmitterOp.get();
        }

        return null;
    }

    public ClientesEntity insertOrUpdate(Clientes clientes) {
        return this.repository.save(convertToEntity(clientes));
    }

    public ClientesEntity convertToEntity(Clientes clientes) {

        ClientesEntity entity = new ClientesEntity();

        entity.setIdClientes(clientes.getIdCliente());
        entity.setNome(clientes.getNome());
        entity.setEmail(clientes.getEmail());
        entity.setSenha(clientes.getSenha());
        entity.setRua(clientes.getRua());
        entity.setCidade(clientes.getCidade());
        entity.setBairro(clientes.getBairro());
        entity.setCep(clientes.getCep());
        entity.setEstado(clientes.getEstado());

        return entity;
    }

    public void delete(Long id) throws ClientesNotFound {

        Optional<ClientesEntity> entityOp = repository.findById(id);

        if (entityOp.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ClientesNotFound("Clientes not found");
        }

    }

}