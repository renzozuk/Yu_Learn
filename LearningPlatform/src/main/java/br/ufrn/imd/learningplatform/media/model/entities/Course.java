package br.ufrn.imd.learningplatform.media.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;
	private String description;
	private String thumbnailUrl;

    public Course() {}
    
    public Course(String id, String title, String description, String thumbnailUrl) {
    	this.id = id;
    	this.title = title;
    	this.description = description;
    	this.thumbnailUrl = thumbnailUrl;
    }

  

	public String getId() {
        return id;
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

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public void setId(String id) {
        this.id = id;
    }


    // Equals e hash code
}
