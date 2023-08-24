package br.com.leuxam.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leuxam.mudi.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
