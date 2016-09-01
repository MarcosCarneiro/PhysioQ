package br.com.stenio.physioq.activities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.date.Dados;


public class OtherActivity extends FragmentActivity implements LoaderCallbacks<Cursor> {
	
	private Uri mUri;

	private TextView mTvName;
	private TextView mTvN;
	private Button mTv;

	public static final int  CONSTANTE_TELA_5 = 5;
	
	@Override
	protected void onCreate(Bundle arg0) {		
		super.onCreate(arg0);
		setContentView(R.layout.other_activity);
		
		Intent intent = getIntent();
		mUri = intent.getData();
		

		mTvName = (TextView) findViewById(R.id.tv_other);
		mTvN = (TextView) findViewById(R.id.tv_description);
		mTv = (Button) findViewById(R.id.btgo);

		
		// Invokes the method onCreateloader() in non-ui thread
		getSupportLoaderManager().initLoader(0, null, this);
		
	}

	/** Invoked by initLoader() */
	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		return new CursorLoader(getBaseContext(), mUri, null, null , null, null);
	}

	/** Invoked by onCreateLoader(), will be executed in ui-thread */
	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
		if(cursor.moveToFirst()){

			mTvName.setText("Questionário: "+cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));
			mTvN.setText("Descrição: "+cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));
			mTv.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					Bundle params = new Bundle();

					Intent ina = new Intent (OtherActivity.this, Dados.class);

					if(mTvName.getText().equals("Questionário: Fulkerson")){
						params.putString("dados", "Fulkerson");
						ina.putExtras(params);
						startActivityForResult(ina,CONSTANTE_TELA_5 );
					}
					else if(mTvName.getText().equals("Questionário: Visa P")){
						params.putString("dados", "VisaP");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}
					else if(mTvName.getText().equals("Questionário: Oswestry")){
						params.putString("dados", "Oswestry");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: Neck Disabily Index - NDI")){
						params.putString("dados", "Ndi");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: ASES")){
						params.putString("dados", "Ases");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					} else if (mTvName.getText().equals("Questionário: IKDC")){
						params.putString("dados", "Ikdc");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: LYSHOLM")){
						params.putString("dados", "Lysholm");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: FABQ")){
						params.putString("dados", "Fabq");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: Roland Morris")){
						params.putString("dados", "Roland Morris");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: DASH")){
						params.putString("dados", "Dash");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					} else if(mTvName.getText().equals("Questionário: SPADI")){
						params.putString("dados", "Spadi");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: TSO")){
						params.putString("dados", "Tso");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: UCLA")){
						params.putString("dados", "Ucla");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);

					}else if(mTvName.getText().equals("Questionário: WORC")){
						params.putString("dados", "Worc");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					}else if(mTvName.getText().equals("Questionário: CAIT")){
						params.putString("dados", "Cait");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					}else if(mTvName.getText().equals("Questionário: FAAM")){
						params.putString("dados", "Faam");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					}else if(mTvName.getText().equals("Questionário: FAOS")){
						params.putString("dados", "Faos");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					}else if(mTvName.getText().equals("Questionário: LEFS")){
						params.putString("dados", "Lefs");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					}else if(mTvName.getText().equals("Questionário: KUJALA")){
						params.putString("dados", "Kujala");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					}else if(mTvName.getText().equals("Questionário: AOFAS")){
						params.putString("dados", "Aofas");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					}else if(mTvName.getText().equals("Questionário: Oswestry")){
						params.putString("dados", "Oswestry");
						ina.putExtras(params);
						startActivityForResult(ina, CONSTANTE_TELA_5);
					}
				}
			});

		}
				
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}
}
