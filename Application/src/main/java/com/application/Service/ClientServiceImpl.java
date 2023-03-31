package com.application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Exception.ClientNotFoundException;
import com.application.Model.Client;
import com.application.Repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientServices{

	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public List<Client> getClients() throws ClientNotFoundException {
		List<Client> list=clientRepo.findAll();
		if(list.size()==0) {
			throw new ClientNotFoundException("Client Not Found!");
		}
		return list;
	}

	@Override
	public Client getClient(Integer Id) throws ClientNotFoundException{
		
		Client found=clientRepo.findById(Id).orElseThrow(()-> new ClientNotFoundException("Client Not Found!"));
		return found;
	}

	@Override
	public Client newClient(Client c) {
		return clientRepo.save(c);
	}

	@Override
	public Client updateClient(Integer Id,Client c) throws ClientNotFoundException{
		Client found=clientRepo.findById(Id).orElseThrow(()-> new ClientNotFoundException("Client Not Found!"));
		found.setAddress(c.getAddress());
		found.setPhone(c.getPhone());
		return clientRepo.save(found);
	}

	@Override
	public void deleteClient(Integer Id) throws ClientNotFoundException{
		Client found=clientRepo.findById(Id).orElseThrow(()-> new ClientNotFoundException("Client Not Found!"));
		clientRepo.delete(found);
	}

}
