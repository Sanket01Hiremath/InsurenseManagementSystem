package com.application.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Exception.ClientNotFoundException;
import com.application.Model.Client;
import com.application.Service.ClientServices;

@RestController
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private ClientServices clientService;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getClients() throws ClientNotFoundException{
		List<Client> found=clientService.getClients();
		return new ResponseEntity<>(found,HttpStatus.FOUND);
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") Integer id) throws ClientNotFoundException{
		Client found=clientService.getClient(id);
		return new ResponseEntity<>(found,HttpStatus.FOUND);
	}
	
	@PostMapping("/clients")
	public ResponseEntity<Client> newClient(@Valid @RequestBody Client c){
		Client saved=clientService.newClient(c);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@Valid @RequestBody Client c,@PathVariable("id")Integer id) throws ClientNotFoundException{
		Client saved=clientService.updateClient(id,c);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id")Integer id) throws ClientNotFoundException{
		clientService.deleteClient(id);
		return new ResponseEntity<>("Deleted SuccessFully",HttpStatus.GONE);
	}
}
