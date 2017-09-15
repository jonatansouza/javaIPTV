/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaiptv;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author jonatan
 */
public class MediaIPTV extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        StackPane root = new StackPane();
        //http://content.jwplatform.com/manifests/vM7nH0Kl.m3u8
        //http://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8
        //http://walterebert.com/playground/video/hls/sintel-trailer.m3u8
        //http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8
        /*Media newMedia = new Media();
        MediaPlayer mp = new MediaPlayer(newMedia);
        MediaView mv = new MediaView(mp);
        
        mp.setAutoPlay(true);
        */
        
        PlayerChannel playerChannel = new PlayerChannel("http://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8");
        Image image = new Image(new FileInputStream(new File("/home/jonatan/NetBeansProjects/MediaIPTV/src/pics/loading.gif")));
        ImageView imageView = new ImageView(image);
        
        root.getChildren().add(imageView);
        root.getChildren().add(playerChannel.loadChannel());
        
        Scene scene = new Scene(root, 720, 480);
        
        primaryStage.setTitle("chanel ");
        primaryStage.setScene(scene);
        primaryStage.show();
       //new Thread(new Loading(playerChannel.getMediaPlayer())).start();
         
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    class Loading implements Runnable{
        private MediaPlayer mp;

        public Loading(MediaPlayer mp) {
            this.mp = mp;
        }
        
        
        @Override
        public void run() {
            while (true) {                
                System.out.println(mp.bufferProgressTimeProperty());
            }
        }
        
    }
    
    
    
}
