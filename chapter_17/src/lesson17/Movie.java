package lesson17;

import java.time.LocalDate;

public class Movie {
	private String title;
	private LocalDate releasedDate;
	
	Movie() {
		
	}
	
	Movie(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public LocalDate getReleasedDate() {
		return this.releasedDate;
	}
	
	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}
}
