package com.betterment.signupflow.views;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.betterment.signupflow.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.text.DecimalFormat;

@EViewGroup(R.layout.titled_input_row)
public class TitledInputRow extends LinearLayout {
    @ViewById
    protected TextView header;
    @ViewById
    protected EditText inputField;

    private DataSource dataSource;

    public TitledInputRow(Context context) {
        super(context);
    }

    public TitledInputRow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitledInputRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TitledInputRow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setData(DataSource dataSource) {
        this.dataSource = dataSource;
        header.setText(dataSource.getHeader());
        inputField.setInputType(dataSource.getInputType());
        if (dataSource.isNumberFormatted()) {
            setDecimalFormatting();
            inputField.setText("$");
        }
    }

    private void setDecimalFormatting() {
        inputField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try
                {
                    inputField.removeTextChangedListener(this);
                    if (s.length() < 1) {
                        inputField.setText("$");
                    } else {
                        float number = Float.parseFloat(s.toString().replaceAll("[$,]", ""));

                        DecimalFormat decimalFormat = new DecimalFormat("$#,###,###.##");
                        decimalFormat.setMaximumFractionDigits(0);
                        inputField.setText(decimalFormat.format(number));

                    }
                    inputField.setSelection(inputField.length());
                    inputField.addTextChangedListener(this);
                    return;
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    inputField.addTextChangedListener(this);
                }
            }
        });
    }

    public String getInput() {
        return inputField.getText().toString().replaceAll("[$,]", "");
    }

    public interface DataSource {
        String getHeader();
        int getInputType();
        boolean isNumberFormatted();
    }
}
