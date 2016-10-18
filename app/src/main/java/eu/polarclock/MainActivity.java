package eu.polarclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        webSettings.setDomStorageEnabled(true);
        //webSettings.setUseWideViewPort(true);
        wv.loadUrl("file:///android_asset/polar-clock.html");
    }

	@Override
	public void onBackPressed()
	{
        WebView wv = (WebView) findViewById(R.id.webView);
        if(wv.getUrl().compareToIgnoreCase("file:///android_asset/polar-clock.html") != 0)
            wv.loadUrl("javascript:goBack()");
        else finish();
	}
}
