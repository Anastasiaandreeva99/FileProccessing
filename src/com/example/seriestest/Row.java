package com.example.seriestest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Row {
    private List<String> row = new ArrayList<>();

    public Row() {
        row =new ArrayList<>();
    }
    public void addNumber(String number) {
         row.add(number);
    }
    public void addNumber (String number,int index)
    {
        row.add(index,number);
    }
    private boolean isValid(String numberToValidate)
    {
        final Pattern pattern = Pattern.compile("^[1-9][0-9]*$");
        return pattern.matcher(numberToValidate).matches();
    }
    public int validate()
    {
        int index=1;
        for(String number : row)
        {
            if (!isValid(number))
            {
                return index;
            }
            index++;
        }
        return 0;
    }

    public List<String> getRow() {
        return row;
    }
    public String getRowString()
    {
        String result = String.join(" ",row);
        return result;
    }
    public String getNumber(int index)
    {
        return row.get(index);
    }
}