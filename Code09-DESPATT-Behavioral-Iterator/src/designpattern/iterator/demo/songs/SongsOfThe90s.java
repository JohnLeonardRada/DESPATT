package designpattern.iterator.demo.songs;

import java.util.Hashtable;
import java.util.Iterator;

import designpattern.iterator.demo.bean.*;
import designpattern.iterator.demo.iterator.*;

public class SongsOfThe90s implements SongIterator{
	Hashtable<Integer, SongInfo> bestSongs = new Hashtable<Integer, SongInfo>();
	int hashKey = 0;
	
	public SongsOfThe90s() {
		addSong("Macarena", "Los Del Rio", 1993);
		addSong("I Want It That Way", "Backstreet Boys", 1999);
		addSong("Harana", "Parokya Ni Edgar", 1997);
		addSong("Getting Jiggy With It", "Will Smith", 1997);
	}
	
	public void addSong(String songName, String bandName, int yearReleased){	
		SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
		bestSongs.put(hashKey, songInfo);
		hashKey++;
	}
	
	//BAD: The old way
	public Hashtable<Integer, SongInfo> getBestSongs(){
		return bestSongs;
	}

	//NEW: the preferred way
	public Iterator createIterator() {
		return bestSongs.values().iterator();
	}
}


