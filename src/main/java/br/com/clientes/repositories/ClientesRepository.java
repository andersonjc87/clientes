package br.com.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clientes.entities.ClientesEntity;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> {

}
