package com.example.adila.blowfish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mPlaintext;
    private EditText mKey;
    private TextView mCiphertextBlowfish;
    private TextView mCiphertextCaesar;
    private Button mEncrypt;
    private Button mDecrypt;
    private TextView mDecryptCaesar;
    private TextView mDecryptBlowfish;

    String plain, key, blowfish, caesar, dekripblowfish, dekripcaesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mPlaintext = findViewById(R.id.plaintext);
        mKey = findViewById(R.id.key);
        mCiphertextBlowfish = findViewById(R.id.ciphertext_blowfish);
        mCiphertextCaesar = findViewById(R.id.ciphertext_caesar);
        mEncrypt = findViewById(R.id.encrypt);
        mDecrypt = findViewById(R.id.decrypt);
        mDecryptCaesar = findViewById(R.id.decrypt_caesar);
        mDecryptBlowfish = findViewById(R.id.decrypt_blowfish);

        mEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plain = mPlaintext.getText().toString().trim();
                key = mKey.getText().toString().trim();
                blowfish = Kripto.enkripsi_blowfish(plain, key);
                caesar = Kripto.enkripsi_caesar(blowfish, 3);
                mCiphertextBlowfish.setText("" + blowfish);
                mCiphertextCaesar.setText("" + caesar);
            }
        });

        mDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dekripcaesar = Kripto.dekripsi_caesar(caesar, 3);
                dekripblowfish = Kripto.dekripsi_blowfish(dekripcaesar, key);
                mDecryptBlowfish.setText("" +dekripblowfish);
                mDecryptCaesar.setText(""+dekripcaesar);
            }
        });
    }
}
