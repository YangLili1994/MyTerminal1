package com.myterminal1.xili.myterminal1.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.myterminal1.xili.myterminal1.Driver.UART;
import com.myterminal1.xili.myterminal1.R;

import java.io.UnsupportedEncodingException;

public class UARTActivity extends AppCompatActivity {

    /****************************************/
    String rxIdCode = "";
    String tag = "serial test";

    private EditText ET1;
    private Button RECV;
    private Button SEND;

    UART com3 = new UART();
    /****************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uart);

        /********************************************/
        ET1 = (EditText)findViewById(R.id.UART_edit1);
        RECV = (Button)findViewById(R.id.UART_recv1);
        SEND = (Button)findViewById(R.id.UART_send1);

        com3.Open(3, 115200);

        RECV.setOnClickListener(new manager());

        SEND.setOnClickListener(new manager());
        /*********************************************/
    }

    class manager implements View.OnClickListener {
        public void onClick(View v) {
            int i;
            switch (v.getId()) {
                //recvive
                case R.id.UART_recv1:
                    Log.d(tag, "recv start ...");
                    String content = read(com3);
                    ET1.append(content);
                    break;

                //send
                case R.id.UART_send1:
                    Log.d(tag,"send start ...");

                    CharSequence tx = ET1.getText();

                    int[] text = new int[tx.length()];

                    for (i=0; i<tx.length(); i++)
                    {
                        text[i] = tx.charAt(i);
                    }

                    com3.Write(text, tx.length());

                    ET1.setText("");
            }
        }
    }

    private String read(UART com){
        String content;
        StringBuilder contentBuilder = new StringBuilder();
        int[] RX = com.Read();

        if(RX == null)
            return new String("");
        for (int b : RX) {
            contentBuilder.append(Integer.toHexString(b));
            contentBuilder.append(" ");
        }
        content = contentBuilder.toString();
        return content;
    }

    private byte[] intArrayToByteArray(int[] content){
        int index = 0;
        byte[] result = new byte[content.length];
        for (int i : content){
            result[index++] = (byte) i ;
        }
        return result;
    }

    static {
        System.loadLibrary("Hardware");
    }
}
