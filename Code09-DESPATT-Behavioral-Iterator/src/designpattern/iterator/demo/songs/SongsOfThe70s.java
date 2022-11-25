package designpattern.iterator.demo.songs;

import java.util.*;
import java.util.Iterator;

import designpattern.iterator.demo.iterator.*;
import designpattern.iterator.demo.bean.*;

public class SongsOfThe70s implements SongIterator { 
	//uses ArrayList as its container
	ArrayList<SongInfo> bestSongs; //defaulted to null- ArrayList holds SongInfo objects
	
	public SongsOfThe70s() {
		bestSongs = new ArrayList<SongInfo>();
		
		addSong("Lumang Tugtugin", "Apo Hiking Society", 1978);
		addSong("Itanong Mo Sa Mga Bata", "Asin", 1978);
		addSong("How Deep is Your Love", "Bee Gees", 1977);
		addSong("Anak", "Freddie Aguilar", 1978);
	}
	
	// Add a SongInfo object to the end of the ArrayList
	public void addSong(String songName, String bandName, int yearReleased){
		SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
		bestSongs.add(songInfo);
	}

	// Traditional: The old way which we do NOT want	
	public ArrayList<SongInfo> getBestSongs(){
		return bestSongs;
	}

	//GOOD: the new way
	public Iterator createIterator() {
		return bestSongs.iterator();
	}
}

