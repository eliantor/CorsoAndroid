package me.eto.helloworld.fragments.dynamicui;

import java.util.Random;

import me.eto.helloworld.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class FragmentSwitcher extends FragmentActivity implements OnCheckedChangeListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.switch_fragments);
		CheckBox checkbox =(CheckBox) findViewById(R.id.switch_layout);
		checkbox.setOnCheckedChangeListener(this);
		// SE VOGLIAMO AGGIUNGERE UN FRAGMENT ALL'INIZIO
//		if(savedInstanceState == null)
//			getSupportFragmentManager().beginTransaction()
//				.add(R.id.host,new SimpleFragment(),"SIMPLE1")
//				.addToBackStack(null) // DONT USE THIS IN SUCH CASE
//				.commit();
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		Fragment frag = null;
		String tag = null;
		if(isChecked){
			frag = new SimpleFragment();
			tag = "SIMPLE1";
		}else{
			SimpleFragment2 sfrag = new SimpleFragment2();
			sfrag.setColor(new Random().nextInt());
			frag = sfrag;
			tag = "SIMPLE2";
		}
		// NON PARTECIPA AL BACK DEL TELEFONO
//		getSupportFragmentManager().beginTransaction()
//			.replace(R.id.host, frag,tag)
//			.commit();
		
		// USA IL BACK DEL TELEFONO
		getSupportFragmentManager().beginTransaction()
			.replace(R.id.host, frag,tag)
			.addToBackStack(null) //accetta una stringa (passiamo null)
			.commit();
		
	}
}
