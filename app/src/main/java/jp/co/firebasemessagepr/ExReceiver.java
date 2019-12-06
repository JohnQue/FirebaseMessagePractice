package jp.co.firebasemessagepr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class ExReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Receiver", "has been called!");
        TaskTest taskTest = new TaskTest(context);
        taskTest.execute();
    }

    public static class TaskTest extends AsyncTask<Void, Void, JSONObject>{
        WeakReference<Context> contextRef;

        TaskTest(Context context){
            contextRef = new WeakReference<>(context);
        }

        @Override
        protected JSONObject doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            Context context = contextRef.get();
            Toast.makeText(context, "サーバーからアップデータ完了", Toast.LENGTH_SHORT).show();
        }
    }
}
