package com.music.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Artist class
 * 
 * @author Vishwas
 *
 */
@Entity
@Table(name="artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="artist_id")
	private Long artistId;
	
	@Column(name="artist_name", unique=true)
	private String artistName;
	
	@ManyToMany(mappedBy="artist")
	private List<Songs> songList;
	
	@OneToOne(mappedBy="artist")
	private Album album;

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Songs> getSongList() {
		return songList;
	}

	public void setSongList(List<Songs> songList) {
		this.songList = songList;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	
}
