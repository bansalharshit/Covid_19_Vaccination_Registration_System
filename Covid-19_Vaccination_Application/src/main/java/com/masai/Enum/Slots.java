package com.masai.Enum;

public enum Slots {
SLOT1{
	@Override
	public String timeSlot() {
		return "10:00 AM to 10:30 AM";
	}
},SLOT2{
	@Override
	public String timeSlot() {
		// TODO Auto-generated method stub
		return "10:30 AM to 11:00 AM";
	}
},SLOT3{
	@Override
	public String timeSlot() {
		// TODO Auto-generated method stub
		return "11:00 AM to 11:30 AM";
	}
},SLOT4{
	@Override
	public String timeSlot() {
		// TODO Auto-generated method stub
		return "11:30 AM to 12:00 PM";
	}
},SLOT5{
	@Override
	public String timeSlot() {
		// TODO Auto-generated method stub
		return "12:30 PM to 1:00 PM";
	}
},SLOT6{
	@Override
	public String timeSlot() {
		// TODO Auto-generated method stub
		return "1:00 PM to 1:30 PM";
	}
},SLOT7{
	@Override
	public String timeSlot() {
		// TODO Auto-generated method stub
		return "1:30 PM to 2:00 PM";
	}
},SLOT8{
	@Override
	public String timeSlot() {
		// TODO Auto-generated method stub
		return "2:00 AM to 2:30 AM";
	}
},SLOT9{
	@Override
	public String timeSlot() {
		// TODO Auto-generated method stub
		return "2:30 AM to 3:00 AM";
	}
};

public String timeSlot() {
	
	return null;
}

}
