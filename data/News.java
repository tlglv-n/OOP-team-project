package data;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class News
{
	private String text;
	private String theme;
	
	public News(){
		super();
	}
	public String getText() {
		return text;
	}
	public String getTheme() {
		return theme;
	}
	public String toString() {
		return "This is " + text + "and theme is " + theme;
	}
}

