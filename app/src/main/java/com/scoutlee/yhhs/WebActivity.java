package com.scoutlee.yhhs;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class WebActivity extends ActionBarActivity {

    private WebView webView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        webView = (WebView) this.findViewById(R.id.webView1);
        mProgressBar = (ProgressBar) this.findViewById(R.id.progressBar);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSaveFormData(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl("http://www.younghoon.hs.kr/index/index.do");
    }


    private class MyWebViewClient extends WebViewClient {


        public void onProgressChanged(WebView view, int newProgress) {
            //현제 페이지 진행사항을 ProgressBar를 통해 알린다.
            if (newProgress < 100) {
                mProgressBar.setProgress(newProgress);
            } else {
                mProgressBar.setVisibility(View.INVISIBLE);
                mProgressBar.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // SSL 에러가 발생해도 계속 진행!
        }
    }
}