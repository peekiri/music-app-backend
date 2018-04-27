package com.music.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="playlist_name")
	private String playlistName;
	
	@ManyToOne
	@JoinColumn(name="User_email_address")
	private User user;
	
	@ManyToMany
	@JoinTable(name="playlist_song", joinColumns=@JoinColumn(name="playlist_name"), 
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
	
}
