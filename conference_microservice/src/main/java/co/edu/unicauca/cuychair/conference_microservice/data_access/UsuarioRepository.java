
package co.edu.unicauca.cuychair.conference_microservice.data_access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.ClienteEntity;


@Repository
public class UsuarioRepository {

	private ArrayList<ClienteEntity> listaDeClientes;

	public UsuarioRepository() {
		this.listaDeClientes = new ArrayList<ClienteEntity>();
		cargarClientes();
	}

	public List<ClienteEntity> findAll() {
		System.out.println("Invocando a listarclientes");
		return this.listaDeClientes;
	}

	public ClienteEntity findById(Integer id) {
		System.out.println("Invocando a consultar un cliente");
		ClienteEntity objCliente = null;

		for (ClienteEntity cliente : listaDeClientes) {
			if (cliente.getId() == id) {
				objCliente = cliente;
				break;
			}
		}

		return objCliente;
	}

	public ClienteEntity save(ClienteEntity cliente) {
		System.out.println("Invocando a almacenar cliente");
		ClienteEntity objCliente = null;
		if (this.listaDeClientes.add(cliente)) {
			objCliente = cliente;
		}

		return objCliente;
	}

	public ClienteEntity update(Integer id, ClienteEntity cliente) {
		System.out.println("Invocando a actualizar un cliente");
		ClienteEntity objCliente = null;

		for (int i = 0; i < this.listaDeClientes.size(); i++) {
			if (this.listaDeClientes.get(i).getId() == id) {
				this.listaDeClientes.set(i, cliente);
				objCliente = cliente;
				break;
			}
		}

		return objCliente;
	}

	public boolean delete(Integer id) {
		System.out.println("Invocando a eliminar un cliente");
		boolean bandera = false;

		for (int i = 0; i < this.listaDeClientes.size(); i++) {
			if (this.listaDeClientes.get(i).getId() == id) {
				this.listaDeClientes.remove(i);
				bandera = true;
				break;
			}
		}

		return bandera;
	}

	private void cargarClientes() {
		ClienteEntity objCliente1 = new ClienteEntity(1, "Juan", "Perez", "juan@unicauca.edu.co", new Date());
		this.listaDeClientes.add(objCliente1);
		ClienteEntity objCliente2 = new ClienteEntity(2, "Catalina", "Lopez", "catalina@unicauca.edu.co", new Date());
		this.listaDeClientes.add(objCliente2);
		ClienteEntity objCliente3 = new ClienteEntity(3, "Sandra", "Sanchez", "Sandra@unicauca.edu.co", new Date());
		this.listaDeClientes.add(objCliente3);
		ClienteEntity objCliente = new ClienteEntity(4, "Andres", "Perez", "andres@unicauca.edu.co", new Date());
		this.listaDeClientes.add(objCliente);
	}

}
