
package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ClienteDTO;



public interface IClienteService {

	public List<ClienteDTO> findAll();

	public ClienteDTO findById(Integer id);

	public ClienteDTO save(ClienteDTO cliente);

	public ClienteDTO update(Integer id, ClienteDTO cliente);

	public boolean delete(Integer id);
}
