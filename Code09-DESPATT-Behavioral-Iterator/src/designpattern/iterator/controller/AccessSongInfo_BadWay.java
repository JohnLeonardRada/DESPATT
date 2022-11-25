package designpattern.iterator.controller;

import designpattern.iterator.demo.bean.*;
import designpattern.iterator.demo.songs.*;

import java.util.*;

public class AccessSongInfo_BadWay {

	SongsOfThe70s songs70s;
	SongsOfThe80s songs80s;
	SongsOfThe90s songs90s;
	
	public static void main(String[] args) {
		
		System.out.println("Song of the 70s");
		ArrayList<SongInfo> aL70sSongs = new SongsOfThe70s().getBestSongs();
		
		for(int iCtr=0; iCtr < aL70sSongs.size(); iCtr++) {
			SongInfo bestSongs = (SongInfo) aL70sSongs.get(iCtr);
	
			System.out.println("\nSong Name: " + bestSongs.getSongName());
			System.out.println("Artist Name: " + bestSongs.getBandName());
			System.out.println("Year Release: " + bestSongs.getYearReleased());
		}
		
		System.out.println("\nSong of the 80s");
		
		SongInfo[] array80sSongs = new SongsOfThe80s().getBestSongs();
	
		for(int iCtr=0; iCtr < array80sSongs.length; iCtr++){
			SongInfo bestSongs = array80sSongs[iCtr];
			
			System.out.println("\nSong Name: " + bestSongs.getSongName());
			
			System.out.println("Artist Name: " + bestSongs.getBandName());
			
			System.out.println("Year Release: " + bestSongs.getYearReleased());
		}
		
		System.out.println("\nSong of the 90s");
		
		Hashtable<Integer, SongInfo> ht90sSongs = new SongsOfThe90s().getBestSongs();
	
		for (Enumeration<Integer> e = ht90sSongs.keys(); e.hasMoreElements();) {
			
			SongInfo bestSongs = ht90sSongs.get(e.nextElement());
			
			System.out.println("\nSong Name: " + bestSongs.getSongName());
			System.out.println("Artist Name: " + bestSongs.getBandName());
			System.out.println("Year Release: " + bestSongs.getYearReleased());
		}
	}	
}
