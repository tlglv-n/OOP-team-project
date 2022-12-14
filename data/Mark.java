package data;

import java.util.Objects;

public class Mark
{
	private double firstAtt = -1;
	private double secondAtt = -1;
	private double finalMark = -1;

	public Mark(){
		super();
	}

	public double getFinal(){
		return finalMark;
	}

	public double getFirstAtt() {
		return firstAtt;
	}

	public void setFirstAtt(double firstAtt) {
		this.firstAtt = firstAtt;
	}

	public double getSecondAtt() {
		return secondAtt;
	}

	public void setSecondAtt(double secondAtt) {
		this.secondAtt = secondAtt;
	}

	public double getFinalMark() {
		return finalMark;
	}

	public void setFinalMark(double finalMark) {
		this.finalMark = finalMark;
	}

	public int hashCode() {
		return Objects.hash(finalMark, firstAtt, secondAtt);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		return this.finalMark == other.finalMark && this.firstAtt == other.firstAtt
				&& this.secondAtt == other.secondAtt;
	}
	
}

