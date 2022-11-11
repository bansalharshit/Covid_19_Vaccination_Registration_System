package com.masai.Services;

import com.masai.Exception.IdCardException;
import com.masai.Model.IDCard;
import com.masai.Model.Pancard;

public interface IDcardServices {

	
	public IDCard addIdCard(IDCard id) throws IdCardException; 
	
	public IDCard getIdcardByPanNo(String panNo,String key) throws IdCardException;

	public IDCard getIdCardByAdharNo(Long adharno,String key) throws IdCardException;
	
}
