package personal_info;

import java.io.Serializable;
import data.Data;

public class PersonalInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private String eMail;
	private String phoneNumber;
	private Gender gender;
	private FamilyStatus familyStatus;

	public String getName(){
		return name;
	}

	public String getSurname(){
		return surname;
	}

	public String getEMail(){
		return eMail;
	}

	public String getPhone(){
		return phoneNumber;
	}

	public Gender getGender(){
		return gender;
	}

	public FamilyStatus getStatus(){
		return familyStatus;
	}

	public void setName(String name){
		this.name = name;
		Data.serialize();
	}
	
	public void setSurname(String surname){
		this.surname = surname;
		Data.serialize();
	}

	public void setEMail(String eMail){
		this.eMail = eMail;
		Data.serialize();
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
		Data.serialize();
	}

	public void setGender(Gender gender){
		this.gender = gender;
		Data.serialize();
	}

	public void setFamilyStatus(FamilyStatus familyStatus){
		this.familyStatus = familyStatus;
		Data.serialize();
	}

}

