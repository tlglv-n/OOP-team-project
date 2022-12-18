package personal_info;

import java.io.Serializable;

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

}

