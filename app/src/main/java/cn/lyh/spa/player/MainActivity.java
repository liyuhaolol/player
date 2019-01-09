package cn.lyh.spa.player;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;

public class MainActivity extends AppCompatActivity {
    IjkVideoView ijkVideoView;
    private String URL_VOD = "http://220.194.157.67/lms_30539/tv_channel_295__redirect__30539.m3u8";
    //private String URL_VOD = "http://30539.hlsplay.aodianyun.com/lms_30539/tv_channel_295.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ijkVideoView = findViewById(R.id.player);
        ijkVideoView.setUrl(URL_VOD); //设置视频地址
        ijkVideoView.setTitle("这里是标题"); //设置视频标题
        StandardVideoController controller = new StandardVideoController(this);
        ijkVideoView.setVideoController(controller); //设置控制器，如需定制可继承BaseVideoController
        ijkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_16_9);
        ////////
        //高级设置（可选，须在start()之前调用方可生效）
        PlayerConfig playerConfig = new PlayerConfig.Builder()
                //.enableCache() //启用边播边缓存功能
                //.autoRotate() //启用重力感应自动进入/退出全屏功能
                .enableMediaCodec()//启动硬解码，启用后可能导致视频黑屏，音画不同步
                //.usingSurfaceView() //启用SurfaceView显示视频，不调用默认使用TextureView
                //.savingProgress() //保存播放进度
                //.disableAudioFocus() //关闭AudioFocusChange监听
                //.setLooping() //循环播放当前正在播放的视频
                .build();
        ijkVideoView.setPlayerConfig(playerConfig);
        ////////






        ijkVideoView.start(); //开始播放，不调用则不自动播放
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ijkVideoView != null){
            ijkVideoView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ijkVideoView != null){
            ijkVideoView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ijkVideoView != null){
            ijkVideoView.release();
        }
    }


    @Override
    public void onBackPressed() {
        if (ijkVideoView != null &&!ijkVideoView.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
