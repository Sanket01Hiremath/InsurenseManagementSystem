package com.application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Exception.ClaimNotFoundException;
import com.application.Model.Claim;
import com.application.Repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimServices{

	@Autowired
	private ClaimRepository claimRepo;
	
	@Override
	public List<Claim> getClaims() throws ClaimNotFoundException {
		List<Claim> list=claimRepo.findAll();
		if(list.size()==0) {
			throw new ClaimNotFoundException("Claim details Not Found!");
		}
		return list;
	}

	@Override
	public Claim getClaim(Integer Id) throws ClaimNotFoundException {
		Claim found=claimRepo.findById(Id).orElseThrow(()-> new ClaimNotFoundException("Claim details Not Found!"));
		return found;
	}

	@Override
	public Claim newClaim(Claim c) {
		return claimRepo.save(c);
	}

	@Override
	public Claim updateClaim(Integer id,Claim c) throws ClaimNotFoundException {
		Claim found=claimRepo.findById(id).orElseThrow(()-> new ClaimNotFoundException("Claim details Not Found!"));
		found.setDescription(c.getDescription());
		return claimRepo.save(found);
	}

	@Override
	public void deleteClaim(Integer id) throws ClaimNotFoundException {
		Claim found=claimRepo.findById(id).orElseThrow(()-> new ClaimNotFoundException("Claim details Not Found!"));
		claimRepo.delete(found);
	}

	

}
