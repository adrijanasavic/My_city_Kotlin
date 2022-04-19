package com.example.mycitynovisad.dialog;

import android.app.AlertDialog;
import android.content.Context;

public class AboutDialog extends AlertDialog.Builder {

    public AboutDialog(Context context) {
        super( context );
        setTitle( "About App" );
        setMessage( "App name: Novi Sad\nAuthor: Adrijana Savic\nadrijana.work@gmail.com" );
        setPositiveButton( "OK", (dialog, which) -> dialog.dismiss());
        setNegativeButton( "Cancel", (dialog, which) -> dialog.dismiss());
    }
}
