package com.example.homefitp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class RegistroDialog extends DialogFragment implements View.OnClickListener {

    private Callback callback;

    static RegistroDialog newInstance() {
        return new RegistroDialog();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(RegistroDialog.STYLE_NORMAL, R.style.FullscreenDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registro_dialog, container, false);
        Button btnAceptar = view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        callback.onAceptarClick();
    }

    public interface Callback {
        void onAceptarClick();
    }
}
