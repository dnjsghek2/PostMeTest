package gpslocation.wonho.example.com.postmetest;

import android.content.Context;
import android.view.Window;
/**
 * Created by wonhochoi on 2016. 8. 26..
 */
import android.app.Dialog;
import android.os.Bundle;

public class PostMeDialog extends Dialog {

    public PostMeDialog(Context context) {
        super(context);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog);

    }
}