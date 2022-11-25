package structural.pattern.adapter;

public class TestAdapter {

	public static void main(String[] args) {
		 AudioPlayer audioPlayer = new AudioPlayer();
		 
		 /*
		  songs are based pandemic: 
		  
		  https://www.chicagotribune.com/entertainment/music/ct-ent-coronavirus-songs-20200504
		  -r4jdtacc2jakpoecfwqah3hzzu-story.html
		  */
	     audioPlayer.play("mp3", "I Believe That We Will Win.mp3");
	     audioPlayer.play("mp4", "Quarantine Clean.mp4");
	     audioPlayer.play("vlc", "Stay Away.vlc");
	     audioPlayer.play("avi", "Gotta Be Patient.avi");
	     
	     /*
	       as a hands-on formative (non-graded) exercise, add another class that will
	       inherit from the AdvancedMediaPlayer to play of type AVI media files. 
	       Modify as well the MediaAdapter for this new file type.
	     */
	     
	     /*once you are done with the modifications,remove the comment line below and
	     to retest the same file type */
	     //audioPlayer.play("avi", "Gotta Be Patient.avi");
	}
}

