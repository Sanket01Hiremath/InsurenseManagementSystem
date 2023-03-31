package com.application.Service;

import java.util.List;

import com.application.Exception.ClaimNotFoundException;
import com.application.Model.Claim;

public interface ClaimServices {
	public List<Claim> getClaims()throws ClaimNotFoundException;
	public Claim getClaim(Integer Id)throws ClaimNotFoundException;
	public Claim newClaim(Claim c);
	public Claim updateClaim(Integer id,Claim c)throws ClaimNotFoundException;
	public void deleteClaim(Integer id)throws ClaimNotFoundException;
}
