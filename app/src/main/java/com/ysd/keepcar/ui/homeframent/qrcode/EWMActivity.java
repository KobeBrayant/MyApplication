package com.ysd.keepcar.ui.homeframent.qrcode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.ysd.keepcar.R;
import com.ysd.keepcar.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.Hashtable;

/*我的二维码 跳转页面*/
public class EWMActivity extends Activity {

    private static final int QR_WIDTH = 550;
    private static final int QR_HEIGHT = 550;
    private ArrayList<String> card = new ArrayList<>();
    private ImageView userIcon;
    private TextView userName;
    private ImageView userEwm;
    private  View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ewm);
        initView();
        card.clear();
        card.add("4S");
        card.add("***");
        card.add("4S 养车");
        String userphone = (String) SharedPreferencesUtils.getParam(EWMActivity.this, "userphone", "");
        card.add("手机_"+userphone);
        card.add("北京朝阳");
        qrcode(view);
        userName.setText(card.get(0));
    }

    private void qrcode(View view) {
        userEwm.setImageBitmap(createQrcode(enQrCodeOneContact(card)));

    }

    private void initView() {
        userIcon = findViewById(R.id.user_img);
        userName = findViewById(R.id.user_name);
        userEwm = findViewById(R.id.EWM);
    }
    public Bitmap createQrcode(String qrcode) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            if (qrcode == null || "".equals(qrcode) || qrcode.length() < 1) {
                Toast.makeText(EWMActivity.this,"数据为空",Toast.LENGTH_SHORT).show();
                return null;
            }
            // TODO 编码格式
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            // TODO 二维码宽高、颜色
            BitMatrix bitMatrix = writer.encode(qrcode,
                    BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff0000ff;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }

                }
            }
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            return  bitmap;
        } catch (Exception e) {
            Log.e("All_Exception", e.toString());
            Toast.makeText(EWMActivity.this,"数据太大，请重新选择",Toast.LENGTH_SHORT).show();
        }
        return null;
    }
    public String enQrCodeOneContact(ArrayList<String> nameCard){

        StringBuilder ss = new StringBuilder();
        ss.append(String.format("BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "N:%s",nameCard.get(0)))
                .append(String.format("\nTEL;iPhone;VOICE:%s",nameCard.get(1)))
                .append("\nORG:" + nameCard.get(2))
                .append("\nROLE:"+nameCard.get(3))
                .append("\nADR:"+nameCard.get(4))
                .append("\nEND:VCARD");
        return ss.toString();

    }
}
