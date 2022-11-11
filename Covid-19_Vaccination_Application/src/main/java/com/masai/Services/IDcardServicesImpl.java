package com.masai.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.IdCardException;
import com.masai.Model.IDCard;
import com.masai.Repository.IDcardRepo;

@Service
public class IDcardServicesImpl implements IDcardServices {

	@Autowired
	private IDcardRepo idRepo;
	
	@Override
	public IDCard addIdCard(IDCard id) throws IdCardException {
			IDCard newId = idRepo.findByPancard(id.getPancard());
			
			if(newId == null) {
				throw new IdCardException("Already ID Card !");
			}
			
			return newId;
	}

}
