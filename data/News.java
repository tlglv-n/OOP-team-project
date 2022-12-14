package data;

import java.util.Objects;

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
	public void setText(String text) {
		this.text = text;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getText() {
		return text;
	}
	public String getTheme() {
		return theme;
	}
	public int hashCode() {
		return Objects.hash(text, theme);
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		News other = (News) obj;
		return Objects.equals(text, other.text) && Objects.equals(theme, other.theme);
	}
	public String toString() {
		return "This is " + text + "and theme is " + theme;
	}
}

