package me.eto.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowNameActivity extends Activity implements OnClickListener{
	private static final int EDIT_NAME_REQUEST = 1;
	
	private Button mRequest;
	private TextView mOutput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name_request_layout);
		mRequest = (Button)findViewById(R.id.btn_request);
		mOutput = (TextView)findViewById(R.id.tv_output);
		mRequest.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// CHIEDIAMO UN OPERAZIONE DA COMPLETARE
		// IN UN' ALTRA ACTIVITY
		startActivityForResult(new Intent(this,EditNameActivity.class), EDIT_NAME_REQUEST);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==EDIT_NAME_REQUEST){
			if(resultCode==RESULT_OK){
				String name = data.getStringExtra(EditNameActivity.RESULT_EXTRA);
				mOutput.setText(name);
			}else{
				Toast.makeText(this, "Azione annullata", Toast.LENGTH_SHORT).show();
			}
		}
	}
}

