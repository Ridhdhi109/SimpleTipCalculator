package com.ridhdhi.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public EditText etTotal;
	public TextView tvTipAmount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etTotal = (EditText) findViewById(R.id.ettotal);
		tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
		
		etTotal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			String total_check_amount = etTotal.getText().toString();
			System.out.println("total_check_amount"+total_check_amount);
			if("0.00".equals(total_check_amount)) {
			etTotal.setText("");
			}
			}
			});
		
	}
	
	protected void calculateTip(float percent) {

		String total = etTotal.getText().toString();
		if (total == null || "".equals(total))
		total = "0";	
		float sub_total = Float.parseFloat(total);
		float tip_amount = sub_total * (percent/100f);
		System.out.println(tip_amount);
		tvTipAmount.setText(String.format("$ %.2f", tip_amount));	
		
	}
		
		public void tip10Percent(View v) {
		calculateTip(10.0f);
		}
		
		public void tip15Percent(View v) {
		calculateTip(15.0f);
		}
		
		public void tip20Percent(View v) {
		calculateTip(20.0f);
		}
}
