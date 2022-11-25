package designpattern.iterator.demo.songs;

import java.util.Arrays;
import java.util.Iterator;

import designpattern.iterator.demo.bean.*;
import designpattern.iterator.demo.iterator.*;

public class SongsOfThe80s implements SongIterator{
	
	SongInfo[] bestSongs; //uses array as its container of type SongInfo
	
	int arrayIndex = 0;
	
	public SongsOfThe80s() {	
		bestSongs = new SongInfo[4];
		
		addSong("Take On Me", "Aha", 1987);
		addSong("Beat It", "Michael Jackson", 1982);
		addSong("Wake Me Up Before You Go", "Wham!", 1984);
		addSong("Eye of the Tiger", "Survivor", 1982);
	}
	
	public void addSong(String songName, String bandName, int yearReleased){	
		SongInfo song = new SongInfo(songName, bandName, yearReleased);
			
		bestSongs[arrayIndex] = song;
		arrayIndex++;
	}
	
	//BAD: This is replaced by the Iterator
	public SongInfo[] getBestSongs(){
		return bestSongs;
	}
	
	//GOOD: The preferred way 
	public Iterator createIterator() {
		/*
		 Returns a fixed-size list backed by the specified array. 
		 (Changes to the returned list "write through" to the array.) 
		 */
		return Arrays.asList(bestSongs).iterator();	
	}
}

