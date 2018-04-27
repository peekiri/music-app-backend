package com.music.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Songs Class
 * 
 * @author Vishwas
 *
 */
@Entity
@Table(name="songs")
public class Songs {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="song_id")
	private int songId;
	
	@Column(name="song_name")
	private String songName;
	
	@Column(name="year")
	private int yearOfRelease;
	
	@ManyToMany
	@JoinTable(name="song_artist", joinColumns=@JoinColumn(name="song_id"), 
		inverseJoinColumns=@JoinColumn(name="artist_name"))
	private List<Artist> artist;
	
	@OneToMany(mappedBy="songs")
	private Collection<Genre> genre;
	
	@ManyToOne
	@JoinTable(name="album_songs", joinColumns=@JoinColumn(name="album_name"),
		inverseJoinColumns=@JoinColumn(name="song_id"))
	private Album album;

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public List<Artist> getArtist() {
		return artist;
	}

	public void setArtist(List<Artist> artist) {
		this.artist = artist;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public Collection<Genre> getGenre() {
		return genre;
	}

	public void setGenre(Collection<Genre> genre) {
		this.genre = genre;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}
