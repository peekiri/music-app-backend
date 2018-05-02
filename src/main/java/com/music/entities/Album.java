package com.music.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="album")
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="album_id")
	private Long albumId;
	
	@Column(name="album_name", unique=true)
	private String albumName;
	
	@OneToMany(mappedBy="album")
	private Collection<Songs> songsList;
	
	@OneToOne
	@JoinColumn(name="artist_name")
	private Artist artist;
	
	@Column(name="year")
	private int yearOfRelease;

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Collection<Songs> getSongsList() {
		return songsList;
	}

	public void setSongsList(Collection<Songs> songsList) {
		this.songsList = songsList;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	
}
