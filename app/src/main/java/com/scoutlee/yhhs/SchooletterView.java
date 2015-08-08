package com.scoutlee.yhhs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class SchooletterView extends ActionBarActivity implements View.OnClickListener {

    String URL;
    WebView WEBVIEW;
    String DATA;
    String DOWNURL;
    //private long latestId = -1;
    //private Uri urlToDownload;
    //private DownloadManager downloadManager;
    //private DownloadManager.Request request;


    private final Handler handler = new android.os.Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticelistitem);

        WEBVIEW = new WebView(this);

        String Title = getIntent().getStringExtra("title");
        String Date = getIntent().getStringExtra("date");
        String Writer= getIntent().getStringExtra("writer");

        URL = getIntent().getStringExtra("URL");
        WEBVIEW = (WebView)findViewById(R.id.webView1);

        TextView txtTitle = (TextView) findViewById(R.id.Title);
        TextView txtDate = (TextView) findViewById(R.id.Date);
        TextView txtWriter = (TextView) findViewById(R.id.Writer);
        TextView txtDownload = (TextView) findViewById(R.id.downloadText);


        txtTitle.setText(Title);
        txtDate.setText(Date);
        txtWriter.setText(Writer);
        networkTask();

        txtDownload.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_schooletterview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Browser:
                String ViewURL = getIntent().getStringExtra("URL");
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ViewURL));
                startActivity(browserIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    private void networkTask() {

        final Handler mHandler = new Handler();

        new Thread()
        {

            public void run()
            {
                try{

                    Document doc = Jsoup.connect(URL).get();
                    Elements element = doc.select("div.board_read_body");
                    Elements DownURL= doc.select("div>dl>dd>a");

                    String s[] = new String[element.size()];
                    for(int i=0;i<element.size();i++){
                        s[i]=element.get(i).text().toString();
                    }
                    for(int i=0;i<element.size();i++){
                        Log.e("asdf", s[i]);
                    }

                    String downURL[] = new String[DownURL.size()];
                    for(int j=0;j<DownURL.size();j++){
                        //downURL[j]=DownURL.get(j).attr("href");
                        downURL[j]=DownURL.get(j).text().toString();
                    }


                    DATA = element.toString();
                    DOWNURL = "http://www.younghoon.hs.kr"+downURL[0];
                    Log.d("DownDATA", DOWNURL);
                    //DownloadFromLink(DOWNURL);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mHandler.post(new Runnable()
                {
                    public void run()
                    {
                        WEBVIEW.getSettings().setJavaScriptEnabled(true);
                        WEBVIEW.getSettings().setBuiltInZoomControls(true);
                        WEBVIEW.getSettings().setDisplayZoomControls(false);
                        WEBVIEW.getSettings().setTextZoom(80);
                        WEBVIEW.setWebViewClient(new WebViewClient() {
                            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                                Toast.makeText(SchooletterView.this, description, Toast.LENGTH_SHORT).show();
                            }
                        });
//                        WEBVIEW.loadData(data,"text/html","utf-8");
                        if(DATA==null){
                            DATA = getResources().getString(R.string.nodata2);
                        }else if(DATA.equals("<p class=\"바탕글\"></p")){
                            DATA = getResources().getString(R.string.nodata2);
                        } else {
                        }
                        Log.d("DATA", DATA);
                        WEBVIEW.loadDataWithBaseURL(null, DATA, "text/html", "utf-8", null);
                        handler.sendEmptyMessage(0);


                        TextView txtDownload = (TextView) findViewById(R.id.downloadText);

                        if(DOWNURL == null) {
                            DOWNURL = "첨부파일이 없습니다.";
                            txtDownload.setText(DOWNURL);

                        }else {
                            txtDownload.setText(DOWNURL);
                        }

                    }
                });

            }
        }.start();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.downloadText:
                Uri uri = Uri.parse(DOWNURL);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                break;
        }
    }

   /* public void DownloadFromLink(String url){
        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        urlToDownload = Uri.parse(url);
        List<String> pathSegments = urlToDownload.getPathSegments();
        request = new DownloadManager.Request(urlToDownload);
        request.setTitle("다운로드 중");
        request.setDescription("요청한 파일을 다운로드합니다");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, pathSegments.get(pathSegments.size() - 1));
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdirs();
        latestId = downloadManager.enqueue(request);
    }*/
}