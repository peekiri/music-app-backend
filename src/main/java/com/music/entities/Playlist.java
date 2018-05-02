package com.music.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="playlist")
public class Playlist {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="playlist_id")
	private Long playlistId;
	
	@Column(name="playlist_name")
	private String playlistName;
	
	@ManyToOne
	@JoinColumn(name="User_email_address")
	private User user;
	
	@ManyToMany
	@JoinTable(name="playlist_song", joinColumns=@JoinColumn(name="playlist_id"), 
		inverseJoinColumns=@JoinColumn(name="song_id"))
	private Collection<Songs> songsList;

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Songs> getSongsList() {
		return songsList;
	}

	public void setSongsList(Collection<Songs> songsList) {
		this.songsList = songsList;
	}

	public Long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}
	
}
