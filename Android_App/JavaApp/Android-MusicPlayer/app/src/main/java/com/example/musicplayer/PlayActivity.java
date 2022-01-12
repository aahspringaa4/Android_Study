package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private WebView webView;
    private Random random = new Random();
    private ImageButton ib_back;
    private ImageButton ib_continue;

    private String[] 발라드 = {"https://www.youtube.com/watch?v=o4n96GSPj1A"};
    private String[] 댄스팝 = {"https://www.youtube.com/watch?v=TxI8gEgACEU"};
    private String[] 트로트 = {"https://www.youtube.com/watch?v=Bwump6p5Uwc"};
    private String[] 힙합 = {"https://www.youtube.com/watch?v=qU0IcDr9aaY"};
    private String[] OST = {"https://www.youtube.com/watch?v=J0UUPaREffw"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        if (Objects.equals(MainActivity.select, "발라드")) {
            webView.loadUrl(발라드[random.nextInt(발라드.length+1)]);
        } else if(Objects.equals(MainActivity.select, "댄스/팝")) {
            webView.loadUrl(댄스팝[random.nextInt(댄스팝.length+1)]);
        } else if(Objects.equals(MainActivity.select, "트로트")) {
            webView.loadUrl(트로트[random.nextInt(트로트.length+1)]);
        } else if(Objects.equals(MainActivity.select, "랩/힙합")) {
            webView.loadUrl(힙합[random.nextInt(힙합.length+1)]);
        } else if(Objects.equals(MainActivity.select, "OST")) {
            webView.loadUrl(OST[random.nextInt(OST.length+1)]);
        }

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());

        ib_back = (ImageButton) findViewById(R.id.ib_back);
        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ib_continue = (ImageButton) findViewById(R.id.ib_continue);
        ib_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();

                if (Objects.equals(MainActivity.select, "발라드")) {
                    webView.loadUrl(발라드[random.nextInt(발라드.length+1)]);
                } else if(Objects.equals(MainActivity.select, "댄스/팝")) {
                    webView.loadUrl(댄스팝[random.nextInt(댄스팝.length+1)]);
                } else if(Objects.equals(MainActivity.select, "트로트")) {
                    webView.loadUrl(트로트[random.nextInt(트로트.length+1)]);
                } else if(Objects.equals(MainActivity.select, "랩/힙합")) {
                    webView.loadUrl(힙합[random.nextInt(힙합.length+1)]);
                } else if(Objects.equals(MainActivity.select, "OST")) {
                    webView.loadUrl(OST[random.nextInt(OST.length+1)]);
                }
            }
        });

    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}