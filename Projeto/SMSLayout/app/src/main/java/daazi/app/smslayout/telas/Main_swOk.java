package daazi.app.smslayout.telas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import daazi.app.smslayout.R;

public class Main_swOk extends DialogFragment {

    Button btn;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction.
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.P_MainSwOk)
                .setPositiveButton(R.string.RP_MainSwOk, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (btn.isEnabled()){
                            
                        }else {
                            btn.setEnabled(!btn.isEnabled());
                        }
                    }
                })
                .setNegativeButton(R.string.RN_MainSwOk, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancels the dialog.
                        Toast.makeText(getContext(),"Permissão negada",Toast.LENGTH_LONG).show();
                    }
                });
        // Create the AlertDialog object and return it.
        return builder.create();
    }
    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
