package personal_info;


public class PersonalInfo
{
	private String name;
	private String surname;
	private String eMail;
	private String phoneNumber;
	private Gender gender;
	private FamilyStatus familyStatus;
	public PersonalInfo(){
		super();
	}

	public String getName(){
		return name;
	}

	public String getSurname(){
		return surname;
	}

	public String getMail(){
		return eMail;
	}

	public String getPhone(){
		return phoneNumber;
	}

	public Gender getGender(){
		return gender;
	}

	public FamilyStatus getFamilyStatus(){
		return familyStatus; 
	}

}

