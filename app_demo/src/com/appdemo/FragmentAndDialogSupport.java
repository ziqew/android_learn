package com.appdemo;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FragmentAndDialogSupport extends FragmentActivity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dialog);

        View tv = findViewById(R.id.text);
        ((TextView)tv).setText("Example of displaying an alert dialog with a DialogFragment");

        // Watch for button clicks.
        Button button = (Button)findViewById(R.id.show);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showDialog();
            }
        });
    }


    void showDialog() {
        DialogFragment newFragment = MyAlertDialogFragment.newInstance(
                R.string.alert_dialog_two_buttons_title);
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }



    public static class MyAlertDialogFragment extends DialogFragment {

        public static MyAlertDialogFragment newInstance(int title) {
            MyAlertDialogFragment frag = new MyAlertDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title", title);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");

            return new AlertDialog.Builder(getActivity())
                    .setIcon(R.drawable.alert_dialog_icon)
                    .setTitle(title)
                    .setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((FragmentAndDialogSupport)getActivity()).doPositiveClick();
                            }
                        }
                    )
                    .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((FragmentAndDialogSupport)getActivity()).doNegativeClick();
                            }
                        }
                    )
                    .create();
        }
    }
}
