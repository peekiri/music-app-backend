package com.music.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class Genre {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="genre_id")
	private int genreId;
	
	@Column(name="genre_name")
	private String genreName;
	
	@ManyToOne
	@JoinTable(name="song_genre", joinColumns=@JoinColumn(name="genre_id"),
			inverseJoinColumns=@JoinColumn(name="song_id"))
	private Songs songs;
	
	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Songs getSongs() {
		return songs;
	}

	public void setSongs(Songs songs) {
		this.songs = songs;
	}
	
}
