package android.csulb.edu.tacopronto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends Activity {

    CheckBox beefChk,chickenChk,wfChk,riceChk,cheeseChk,seafoodChk,beansChk,picoChk,guacamoleChk,lbtChk,sodaChk,margaritaChk,cervezaChk,tequillaChk;
    RadioButton largeRadio,mediumRadio,cornRadio,flourRadio;
    Button placeOrder;
    Integer beefprice = 2,chickenprice = 2, wfprice = 2, riceprice = 2,cheeseprice = 2,seafoodprice = 2,beansprice = 2, picoprice =2,
            guacamoleprice = 2, lbtprice = 2, sodaprice = 1,margaritaprice = 1,cervezaprice = 1, tequillaprice = 1, largeprice = 3,
            mediumprice = 2,cornprice = 3,flourprice = 2, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListeners();
    }

    public void addListeners(){

        beefChk = (CheckBox) findViewById(R.id.beef);
        chickenChk = (CheckBox) findViewById(R.id.chicken);
        wfChk = (CheckBox) findViewById(R.id.whiteFish);
        riceChk = (CheckBox) findViewById(R.id.rice);
        cheeseChk = (CheckBox) findViewById(R.id.cheese);
        seafoodChk = (CheckBox) findViewById(R.id.seafood);
        beansChk = (CheckBox) findViewById(R.id.beans);
        picoChk = (CheckBox) findViewById(R.id.pico);
        guacamoleChk = (CheckBox) findViewById(R.id.guacamole);
        lbtChk = (CheckBox) findViewById(R.id.lbt);
        sodaChk = (CheckBox) findViewById(R.id.soda);
        margaritaChk = (CheckBox) findViewById(R.id.margarita);
        cervezaChk = (CheckBox) findViewById(R.id.cerveza);
        tequillaChk = (CheckBox) findViewById(R.id.tequilla);
        largeRadio = (RadioButton) findViewById(R.id.radioLarge);
        mediumRadio = (RadioButton) findViewById(R.id.radioMedium);
        cornRadio = (RadioButton) findViewById(R.id.radioCorn);
        flourRadio = (RadioButton) findViewById(R.id.radioFlour);
        placeOrder = (Button) findViewById(R.id.order);

        placeOrder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder summary = new StringBuilder();
                summary.append("Your order");

                if(largeRadio.isChecked()){
                    total = total + largeprice;
                    summary.append("\nLarge Taco: $3 ");
                }
                if(mediumRadio.isChecked()){
                    total = total + mediumprice;
                    summary.append("\nMedium Taco: $2");
                }
                if(cornRadio.isChecked()){
                    total = total + cornprice;
                    summary.append("\nCorn Tortilla: $3");
                }
                if(flourRadio.isChecked()){
                    total = total + flourprice;
                    summary.append("\nFlour Tortilla: $2");
                }
                summary.append("\nFillings");
                if(beefChk.isChecked()){
                    total = total + beefprice;
                    summary.append("\nBeef: $2 ");
                }
                if(riceChk.isChecked()){
                    total = total + riceprice;
                    summary.append("\nRice: $2 ");
                }
                if(chickenChk.isChecked()){
                    total = total + chickenprice;
                    summary.append("\nChicken: $2 ");
                }
                if(wfChk.isChecked()){
                    total = total + wfprice;
                    summary.append("\nWhite Fish: $2 ");
                }
                if(cheeseChk.isChecked()){
                    total = total + cheeseprice;
                    summary.append("\nCheese: $2 ");
                }
                if(seafoodChk.isChecked()){
                    total = total + seafoodprice;
                    summary.append("\nSea Food: $2 ");
                }
                if(beansChk.isChecked()){
                    total = total + beansprice;
                    summary.append("\nBeans: $2 ");
                }
                if(picoChk.isChecked()){
                    total = total + picoprice;
                    summary.append("\nPico de Gallo: $2 ");
                }
                if(guacamoleChk.isChecked()){
                    total = total + guacamoleprice;
                    summary.append("\nGuacamole: $2 ");
                }
                if(lbtChk.isChecked()){
                    total = total + lbtprice;
                    summary.append("\nLBT: $2 ");
                }
                summary.append("\nBeverage");
                if(sodaChk.isChecked()){
                    total = total + sodaprice;
                    summary.append("\nSoda : $1 ");
                }
                if(margaritaChk.isChecked()){
                    total = total + margaritaprice;
                    summary.append("\nMargarita : $1 ");
                }
                if(cervezaChk.isChecked()){
                    total = total + cervezaprice;
                    summary.append("\nCerveza : $1 ");
                }
                if(tequillaChk.isChecked()){
                    total = total + tequillaprice;
                    summary.append("\nTequilla : $1 ");
                }

                summary.append(String.format("\nTotal: $ %d", total));

                Toast.makeText(getApplicationContext(), "Order is placed",
                        Toast.LENGTH_LONG).show();

            try {

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("+15623530446", null, summary.toString(), null, null);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            }
        });
    }


}
