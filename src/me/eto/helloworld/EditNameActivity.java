package me.eto.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class EditNameActivity extends Activity implements OnClickListener{
	public final static String RESULT_EXTRA = "name";
	
	EditText mInputName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_name_layout);
		findViewById(R.id.btn_submit).setOnClickListener(this);
		mInputName= (EditText)findViewById(R.id.input_name);
	}

	@Override
	public void onClick(View v) {
		String name = mInputName.getText().toString();
		Intent result = new Intent();
		result.putExtra(RESULT_EXTRA, name);
		setResult(RESULT_OK, result);
		finish();
		// Se volessi cancellare (raro perchè lo fa per noi back
		//setResult(RESULT_CANCELED);
	}
}
