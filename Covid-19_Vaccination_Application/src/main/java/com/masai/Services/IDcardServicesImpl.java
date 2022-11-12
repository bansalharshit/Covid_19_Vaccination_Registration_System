package com.masai.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.IdCardException;
import com.masai.Model.AdharCard;
import com.masai.Model.CurrentAdminSession;
import com.masai.Model.IDCard;
import com.masai.Model.Pancard;
import com.masai.Repository.AdminSessionRepository;
import com.masai.Repository.IDcardRepo;

@Service
public class IDcardServicesImpl implements IDcardServices {

	@Autowired
	private IDcardRepo idRepo;
	
	@Autowired
	private AdminSessionRepository adminRepo;
	
	@Override
	public IDCard addIdCard(IDCard id) throws IdCardException {
			IDCard newId = idRepo.findByPancard(id.getPancard());
			
			if(newId != null) {
				throw new IdCardException("Already ID Card !");
			}
			
			return idRepo.save(id);
	}

	@Override
	public IDCard getIdcardByPanNo(String panNo, String key) throws IdCardException {
		Optional<CurrentAdminSession> optCurrAdmin= adminRepo.findByUuid(key);
		
		if(!optCurrAdmin.isPresent()){
			
			throw new IdCardException("User Not Found !");
			
		}
	
		IDCard idcard = idRepo.findByPancard(new Pancard(panNo));
		if (idcard == null)
			throw new IdCardException("Idcard not found with the  panNo:" + panNo);
		else
			return idcard;
	}

	@Override
	public IDCard getIdCardByAdharNo(Long adharno, String key) throws IdCardException {
		
		Optional<CurrentAdminSession> CurrentAdmin= adminRepo.findByUuid(key);
		
		if(!CurrentAdmin.isPresent()) {
			
			throw new IdCardException("User Not Found !");
		}
	
		IDCard idcard = idRepo.findByAdharcard(new AdharCard(adharno));
		if (idcard == null)
			throw new IdCardException("IdCard not found with the adharNo :" + adharno);
		else
			return idcard;
	}

}
