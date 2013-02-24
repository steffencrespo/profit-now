package com.example.profitnow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText purchasePrice;
	private EditText finalTarget;
	private EditText finalProfit;
	private EditText currentPrice;
	private EditText currentProfit;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		purchasePrice = (EditText) findViewById(R.id.editText1);
		finalTarget = (EditText) findViewById(R.id.editText2);
		finalProfit = (EditText) findViewById(R.id.editText3);
		currentPrice = (EditText) findViewById(R.id.editText4);
		currentProfit = (EditText) findViewById(R.id.editText5);
		
		fillTheNumberFields();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void calculate(View v){
		float purchase = Float.parseFloat(purchasePrice.getText().toString());
		float targetSale = Float.parseFloat(finalTarget.getText().toString());
		float current = Float.parseFloat(currentPrice.getText().toString());
		
		finalProfit.setText(String.valueOf(percentualValueOf(purchase, targetSale)));
		currentProfit.setText(String.valueOf(percentualValueOf(purchase,current)));
		
	}
	
	private float percentualValueOf(float purchase, float sale){
		return (1-(purchase/sale))*100;
	}
	
	private void fillTheNumberFields(){
		purchasePrice.setText("0");
		finalTarget.setText("0");
		finalProfit.setText("0");
		currentPrice.setText("0");
		currentProfit.setText("0");
	}

}
