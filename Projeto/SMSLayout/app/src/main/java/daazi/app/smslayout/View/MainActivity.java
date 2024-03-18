package daazi.app.smslayout.View;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import daazi.app.smslayout.R;
import daazi.app.smslayout.Util.AppUtil;
import daazi.app.smslayout.telas.Main_swOk;

public class MainActivity extends AppCompatActivity {

    SmsManager objSmsManager;
    EditText editMensagem, editSMS;
    Button btnEnviar;
    Switch swOk;

    String smsPara;
    String smsMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Main_swOk ok = new Main_swOk();
        Inicializacao();

        swOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok.setBtn(btnEnviar);
                ok.show(getSupportFragmentManager(), "SW");
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(AppUtil.getVazioEdit(editMensagem,editSMS)){
                smsPara = editSMS.getText().toString();
                smsMensagem = editMensagem.getText().toString();

                try{

                    /*Pega a configuração padrão*/
                    objSmsManager = SmsManager.getDefault();
                    objSmsManager.sendTextMessage(smsPara,null,smsMensagem,null,null);
                    Toast.makeText(getApplicationContext(),"SMS Enviado...",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Lamentamos pois ocoreu uma falha (SMS não enviado) ",Toast.LENGTH_LONG).show();
                }
                }else {
                    AppUtil.voErroEdit(editMensagem,editSMS);
                }

            }
        });

    }

    private void Inicializacao() {
        editMensagem = findViewById(R.id.editMensagem);
        editSMS = findViewById(R.id.editPara);
        btnEnviar = findViewById(R.id.btnEnviar);
        swOk = findViewById(R.id.swOk);
    }
}