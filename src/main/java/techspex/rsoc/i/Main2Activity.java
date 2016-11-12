package techspex.rsoc.i;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends Activity {
    WebView w;
    ProgressDialog mProgressDialog;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        w=(WebView)findViewById(R.id.web1);
        w.setWebViewClient(new MyBrowser());
        w.getSettings().setLoadsImagesAutomatically(true);
        w.getSettings().setJavaScriptEnabled(true);
        s="<html>\n" +
                "<title> imap </title>\n" +
                "<body>\n" +
                "<iframe src=\"http://192.168.43.51/hackapp/all.php\" width=\"800\" height=\"500\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\n" +
                "</body>\n" +
                "</html> ";

        //w.loadUrl("file:///android_asset/imap.html");
        mProgressDialog = new ProgressDialog(Main2Activity.this);
        mProgressDialog.setTitle("Get to saintgits");
        mProgressDialog.setMessage("...Loading...");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.show();
        w.loadDataWithBaseURL(null, s, "text/html","UTF-8",null);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            w.setVisibility(view.VISIBLE);

            return true;
        }
    }


}
