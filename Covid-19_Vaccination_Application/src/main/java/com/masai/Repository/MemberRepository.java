package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.IDCard;
import com.masai.Model.Member;
import com.masai.Model.VaccineRegistration;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	public Member findByIdCard(Optional<IDCard> idcard);

	public Member findByvaccineRegistration(VaccineRegistration vr);

}
