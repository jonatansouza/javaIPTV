/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaiptv;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author jonatan
 */
public class PlayerChannel {
    private String chanelUrl;
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;
    
    public PlayerChannel(String chanelUrl) {
        this.chanelUrl = chanelUrl;
    }
    
    
    public MediaView loadChannel(){
        media = new Media(chanelUrl);
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        return mediaView;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public MediaView getMediaView() {
        return mediaView;
    }

    public void setMediaView(MediaView mediaView) {
        this.mediaView = mediaView;
    }
    
    
}
