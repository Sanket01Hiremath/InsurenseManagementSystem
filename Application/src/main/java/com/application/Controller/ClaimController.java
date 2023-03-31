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

import com.application.Exception.ClaimNotFoundException;
import com.application.Model.Claim;
import com.application.Service.ClaimServices;

@RestController
@RequestMapping("/api")
public class ClaimController {
	@Autowired
	private ClaimServices claimService;
	
	@GetMapping("/claims")
	public ResponseEntity<List<Claim>> getClients() throws ClaimNotFoundException{
		List<Claim> found=claimService.getClaims();
		return new ResponseEntity<>(found,HttpStatus.FOUND);
	}
	
	@GetMapping("/claims/{id}")
	public ResponseEntity<Claim> getClient(@PathVariable("id") Integer id) throws ClaimNotFoundException{
		Claim found=claimService.getClaim(id);
		return new ResponseEntity<>(found,HttpStatus.FOUND);
	}
	
	@PostMapping("/claims")
	public ResponseEntity<Claim> newClient(@Valid @RequestBody Claim c){
		Claim saved=claimService.newClaim(c);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@PutMapping("/claims/{id}")
	public ResponseEntity<Claim> updateClient(@Valid @RequestBody Claim c,@PathVariable("id")Integer id) throws ClaimNotFoundException{
		Claim saved=claimService.updateClaim(id,c);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/claims/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id")Integer id) throws ClaimNotFoundException{
		claimService.deleteClaim(id);
		return new ResponseEntity<>("Deleted SuccessFully",HttpStatus.GONE);
	}
}
