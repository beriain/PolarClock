package eu.polarclock;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.Window;
import android.webkit.WebViewClient;

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
                view.loadUrl(url);
                return false;
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
}
