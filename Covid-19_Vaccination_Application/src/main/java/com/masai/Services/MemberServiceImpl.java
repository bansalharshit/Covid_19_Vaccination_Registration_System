package com.masai.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.MemberException;
import com.masai.Model.AdharCard;
import com.masai.Model.Appointment;
import com.masai.Model.CurrentAdminSession;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.IDCard;
import com.masai.Model.Member;
import com.masai.Model.Pancard;
import com.masai.Model.Vaccine;
import com.masai.Model.VaccineCount;
import com.masai.Model.VaccineRegistration;
import com.masai.Repository.AdminSessionRepository;
import com.masai.Repository.AppointmentRepo;
import com.masai.Repository.IDcardRepo;
import com.masai.Repository.MemberRepository;
import com.masai.Repository.UserSessionRepository;
import com.masai.Repository.VaccineCountRepository;
import com.masai.Repository.VaccineRegistrationRepository;
import com.masai.Repository.VaccineRepository;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	IDcardRepo idCardRepo;
	
	@Autowired
	VaccineRegistrationRepository vaccineRegisterRepo;
	
	@Autowired
	AppointmentRepo appointRepo;
	
	@Autowired
	VaccineRepository vaccineRepo;
	
	@Autowired
	VaccineCountRepository vaccineCountRepo;
	
	@Autowired
	AdminSessionRepository adminRepo;
	
	@Autowired
	UserSessionRepository userRepo;
	
	@Override
	public Member addMemberbyMobileNo(Addhar addhar, String mobileNo,String key) throws MemberException {
		
		 Optional<CurrentUserSession> optCurrUser= userRepo.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		
		
		Optional<VaccineRegistration> vacc = vaccineRegisterRepo.findById(mobileNo);
		if (vacc.isPresent()) {
			IDCard idcard = idCardRepo.findByAdharcard(member.getIdCard().getAdharcard());
			if (idcard == null)

			{
				member.setVaccineRegistration(vacc.get());
				member.setDatefor1dose(null);
				member.setDatefor2dose(null);
				member.setDose1status(false);
				member.setDose2status(false);
				return memberRepo.save(member);
			} else
				throw new MemberException("Member is already present");
		} else
			throw new MemberException("This MOBILE NUMBER is NOT REGISTERED:" + mobileNo);
	}

	

//	@Override
//	public Member getMemberById(Integer idcardid,String key) throws MemberException {
//		
//		 Optional<CurrentAdminSession> currAdmin= adminRepo.findByUuid(key);
//		 Optional<CurrentUserSession> currUser= userRepo.findByUuid(key);
//			
//			if(currAdmin != null && currUser != null) {
//				
//				throw new MemberException("YOU CANT ACCESS THIS APP");
//			}
//			
//		
//		Optional<IDCard> idcard = idCardRepo.findById(idcardid);
//		
//		if (idcard != null) {
//			Member memberbyId = memberRepo.findByIdCard(idcard);
//			if (memberbyId != null) {
//				List<Appointment> appointment = appointRepo.findByMember(memberbyId);
//				
//				memberbyId.setAppointments(appointment);
//				return memberbyId;
//			} else
//				throw new MemberException("Member is not Registered with these IDCARD ID:" + idcardid);
//		} else
//			throw new MemberException("First Register Member with IDCARD ID:" + idcardid);
//	}

//	@Override
//	public boolean deleteMember(Integer mid,String key) throws MemberException {
//		
//		 Optional<CurrentUserSession> currUser = userRepo.findByUuid(key);
//			
//			if(currUser != null) {
//				throw new MemberException("Register Member First !");
//			}
//	
//		
//		Optional<Member> memberId = memberRepo.findById(mid);
//		
//		
//		if (memberId.isPresent()) {
//			Member existingMember = memberId.get();
//			if (existingMember.getVaccineRegistration() != null)
//				vaccineRegisterRepo.delete(existingMember.getVaccineRegistration());
//			if (existingMember.getIdCard() != null)
//				idCardRepo.delete(existingMember.getIdCard());
//			if (existingMember.getAppointments() != null)
//				appointRepo.deleteAll(existingMember.getAppointments());
//			memberRepo.delete(existingMember);
//			return true;
//		} else
//			throw new MemberException("Member Is Not Registered :" + mid);
//	}
//
//	@Override
//	public Member getMemberByPanNo(String panNo,String key) throws MemberException {
//	
//		 Optional<CurrentAdminSession> currAdmin = adminRepo.findByUuid(key);
//			
//			if(currAdmin != null) {
//				
//				throw new MemberException("Register Your Member First !");
//			}
//		
//		IDCard idcard = idCardRepo.findByPancard(new Pancard(panNo));
//		
//		
//		if (idcard != null) {
//			Optional<IDCard> id = idCardRepo.findById(idcard.getId());
//			Member memberbyId = memberRepo.findByIdCard(id);
//			
//			if (memberbyId != null)
//				return memberbyId;
//			else
//				throw new MemberException("Member is not registered with this PAN NUMBER : " + panNo);
//		} else
//			throw new MemberException("Member is not Registered With PAN : " + panNo);
//	}

//	@Override
//	public boolean deleteMemberRecord(Member member,String key) throws MemberException {
//		
//		 Optional<CurrentAdminSession> currAdmin = adminRepo.findByUuid(key);
//			
//			if(currAdmin != null) {
//				
//				throw new MemberException("Register Your Member First !");
//			}
//		
//		
//		Optional<Member> memberId = memberRepo.findById(member.getMemberid());
//		
//		if (memberId.isPresent()) {
//			memberRepo.delete(member);
//			return true;
//		} else
//			throw new MemberException("MEMBER ID not found:" + member.getMemberid());
//	}

//	@Override
//	public Member getMemberByAdharNo(Long adharNo,String key) throws MemberException {
//		 
//		Optional<CurrentAdminSession> currAdmin= adminRepo.findByUuid(key);
//			
//			if(currAdmin != null) {
//				
//				throw new MemberException("Register Your Member First !");
//			}
//		
//		 IDCard idcard = idCardRepo.findByAdharcard(new AdharCard(adharNo));
//		
//		Optional<IDCard> newIdcard = idCardRepo.findById(idcard.getId());
//		
//		if (newIdcard != null) {
//			Member mbyId = memberRepo.findByIdCard(newIdcard);
//			if (mbyId != null)
//				return mbyId;
//			else
//				throw new MemberException("Member with ADHAR NUMBER : " + adharNo+" Not Found !");
//		} else
//			throw new MemberException("First Register Member with ADHAR NUMBER : " + adharNo);
//
//	}

	@Override
	public Member updatedoseStatus(Member member, Integer mid,String key) throws MemberException {
		
		 Optional<CurrentAdminSession> optCurrAdmin= adminRepo.findByUuid(key);
			
			if(optCurrAdmin!=null) {
				
				throw new MemberException("Admin Not Found !");
			}
			
		Optional<Member> mId = memberRepo.findById(mid);
		if (mId.isPresent()) {
			Member exist = mId.get();
			LocalDate present = LocalDate.now();
			LocalDate pastDate = present.minusDays(3);

			if (member.getDatefor1dose() != null) {
				LocalDate given1 = member.getDatefor1dose();
				if (member.getDatefor1dose() != null && (given1.isBefore(present) || present.isEqual(given1))
						&& given1.isAfter(pastDate)) {
					exist.setDatefor1dose(member.getDatefor1dose());
					if (exist.getDatefor1dose() != null) {
						exist.setDose1status(null);
						Optional<Vaccine> vaccine = vaccineRepo.findByvaccinename(exist.getVaccine().getVaccinename());
						exist.setVaccine(vaccine.get());
						VaccineCount vc = vaccineCountRepo.findByvaccine(vaccine.get());
						vc.setQuantity(vc.getQuantity() - 1);
					}
				}

				else if (member.getDatefor1dose() != null && present.isBefore(given1))
					throw new MemberException("Future date is given in DOSE 1 DATE area");

				else if (member.getDatefor1dose() != null && pastDate.isAfter(given1))
					throw new MemberException(" date is 3 days before the present date(DOSE 1)");
			}
			if (exist.getDatefor1dose() == null && member.getDatefor2dose() != null)
				throw new MemberException(" Dose 1 not taken");

			if (member.getDatefor2dose() != null) {
				LocalDate given2 = member.getDatefor2dose();
				if (given2.isBefore(present)
						|| present.isEqual(given2) && given2.isAfter(pastDate) && exist.getDatefor1dose() != null) {
					System.out.println("call");
					exist.setDatefor2dose(member.getDatefor2dose());
					if (exist.getDatefor2dose() != null) {
						exist.setDose2status(true);
						Vaccine vaccine = exist.getVaccine();
						VaccineCount vc = vaccineCountRepo.findByvaccine(vaccine);
						vc.setQuantity(vc.getQuantity() - 1);
					}

				}

				else if (member.getDatefor2dose() != null && present.isBefore(given2))
					throw new MemberException("Future date is given in DOSE 2 DATE area");
				else if (member.getDatefor1dose() != null && pastDate.isAfter(given2))
					throw new MemberException("date is 3 days before the present date(DOSE 2)");

			}

			if (exist.getDatefor2dose() != null)
				exist.setDose2status(true);
			return memberRepo.save(exist);
		} else
			throw new MemberException("Member not found with the MEMBER ID :" + member.getMemberid());

	}



	@Override
	public Member updateMember(Member member, Integer mid, String key) throws MemberException {
		 Optional<CurrentAdminSession> optCurrAdmin= adminRepo.findByUuid(key);
		 Optional<CurrentUserSession> optCurrUser= userRepo.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()&&!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
		
		Optional<Member> mId = memberRepo.findById(mid);
		if (mId.isPresent()) {
			Member exist = mId.get();
			if (member.getIdCard() != null) {
				IDCard id = exist.getIdCard();
				if (member.getIdCard().getDob() != null)
					id.setDob(member.getIdCard().getDob());
				if (member.getIdCard().getCity() != null)
					id.setCity(member.getIdCard().getCity());
				
				if (member.getIdCard().getAddress() != null)
					id.setAddress(member.getIdCard().getAddress());
				if (member.getIdCard().getPincode() != null)
					id.setPincode(member.getIdCard().getPincode());
				if (member.getIdCard().getState() != null)
					id.setState(member.getIdCard().getState());

				if (member.getIdCard().getAdharcard() != null) {
					AdharCard adar = exist.getIdCard().getAdharcard();
					adar.setAdharNo(member.getIdCard().getAdharcard().getAdharNo());
				}

				if (member.getIdCard().getPancard() != null) {
					Pancard pan = exist.getIdCard().getPancard();
					pan.setPanNo(member.getIdCard().getPancard().getPanNo());
				}
			}
			return memberRepo.save(exist);
		} else
			throw new MemberException("Member not found with the MEMBER ID :" + member.getMemberid());
	}

	

}
