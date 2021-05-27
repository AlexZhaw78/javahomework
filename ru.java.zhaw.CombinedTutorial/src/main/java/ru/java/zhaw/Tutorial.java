package ru.java.zhaw;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "tutorials")

@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;

	
	@Column(name = "title")
	private String title;

	
	@Column(name = "description")
	private String description;

	
	@Column(name = "published")
	private boolean published;

	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}
	
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	}	
}
