package designpattern.iterator.controller;

import designpattern.iterator.demo.iterator.SongIterator;
import designpattern.iterator.demo.songs.SongsOfThe70s;
import designpattern.iterator.demo.songs.SongsOfThe80s;
import designpattern.iterator.demo.songs.SongsOfThe90s;

import designpattern.iterator.demo.bean.*;

import java.util.*;

public class AccessSongInfo_PreferredWay {

	static SongsOfThe70s songs70s; //defaulted to null
	static SongsOfThe80s songs80s; //defaulted to null
	static SongsOfThe90s songs90s; //defaulted to null
	
	static SongIterator iter70sSongs; //defaulted to null
	static SongIterator iter80sSongs; //defaulted to null
	static SongIterator iter90sSongs; //defaulted to null
	
	public static void main(String[] args) {
		songs70s = new SongsOfThe70s();
		songs80s = new SongsOfThe80s();
		songs90s = new SongsOfThe90s();
		
		initialize(songs70s, songs80s, songs90s);
		
		printSongs(iter70sSongs);
		printSongs(iter80sSongs);
		printSongs(iter90sSongs);
	}
	
	public static void initialize (SongIterator newSongs70s, SongIterator newSongs80s, 
			SongIterator newSongs90s) {
			
			iter70sSongs = newSongs70s;
			iter80sSongs = newSongs80s;
			iter90sSongs = newSongs90s;
		}
	
	public static void printSongs(SongIterator iterator) {
		Iterator<SongInfo> songIterator = iterator.createIterator();
			
		while(songIterator.hasNext()){
			SongInfo bestSongs = (SongInfo) songIterator.next();
			
			System.out.println("\nSong Name: " + bestSongs.getSongName());
			System.out.println("Artist Name: " + bestSongs.getBandName());
			System.out.println("Year Release: " + bestSongs.getYearReleased());
		}	
	}
}

