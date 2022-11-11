package com.masai.Services;

import com.masai.Exception.IdCardException;
import com.masai.Model.IDCard;

public interface IDcardServices {

	
	public IDCard addIdCard(IDCard id) throws IdCardException; 
	
}
