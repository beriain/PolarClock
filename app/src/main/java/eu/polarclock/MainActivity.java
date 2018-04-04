package eu.polarclock;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.Window;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.net.Uri;
import android.content.res.Configuration;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        WebView wv = (WebView) findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("file"))
                    return false;
                else {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    return true;
                }
            }
        });
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        webSettings.setDomStorageEnabled(true);
        
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
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        WebView wv = (WebView) findViewById(R.id.webView);
        if(wv.getUrl().compareToIgnoreCase("file:///android_asset/polar-clock.html") == 0)
            this.recreate();
    }
}
