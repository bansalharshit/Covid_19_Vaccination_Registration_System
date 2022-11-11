package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.IDCard;
import com.masai.Model.Pancard;

@Repository
public interface IDcardRepo extends JpaRepository<IDCard, Integer> {

	public IDCard findByPancard(Pancard pancard);
	
}
