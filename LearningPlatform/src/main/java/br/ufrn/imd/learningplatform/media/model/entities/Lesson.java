package br.ufrn.imd.learningplatform.media.model.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public abstract class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;
	private String description;
	private List<String> categories;
	private String thumbnailUrl;

	public Lesson() {}
    
    public Lesson(String id, String title, String description, List<String> categories, String thumbnailUrl) {
    	this.id = id;
    	this.title = title;
    	this.description = description;
    	this.categories = categories;
    	this.thumbnailUrl = thumbnailUrl;
    }	

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    // Equals e hash code
}
