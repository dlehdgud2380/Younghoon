package com.scoutlee.yhhs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Appinfo3 extends Fragment implements OnClickListener {

    private EditText recipient;
    private EditText subject;
    private EditText body;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.appinfo3, container, false);

        recipient = (EditText) v.findViewById(R.id.recipient);
        subject = (EditText) v.findViewById(R.id.subject);
        body = (EditText) v.findViewById(R.id.body);
        Button button = (Button) v.findViewById(R.id.button);

        button.setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button:
                sendEmail();
                // after sending the email, clear the fields
                recipient.setText("younghoon@younghoon.hs.kr");
                subject.setText("");
                body.setText("");
                break;

        }

    }

    protected void sendEmail() {

        String[] recipients = {recipient.getText().toString()};
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        // prompts email clients only
        email.setType("message/rfc822");

        email.putExtra(Intent.EXTRA_EMAIL, recipients);
        email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

        try {
            // the user can choose the email client
            startActivity(Intent.createChooser(email, "Choose an email client from..."));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "No email client installed.",
                    Toast.LENGTH_LONG).show();
        }
    }
}
