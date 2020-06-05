package com.example.seriestest;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class FileData {
    private List<Row> table = new ArrayList<>();
    public void addRow(@NotNull String row)
    {
        String[] splitString = row.split("\\s+");
        Row newRow = new Row();
        for(String number : splitString)
        {
            newRow.addNumber(number);
        }
        table.add(newRow);

    }

    public List<Row> getTable() {
        return table;
    }
    public Row getRow(int index)
    {
        return table.get(index);
    }
    public Pair<Integer> valid()
    {

        int index =1;
        for(Row row : table)
        {
            int rowValidationResult=row.validate();
            if (rowValidationResult!=0)
            {

                Pair<Integer> validationPair= new Pair<>(index,rowValidationResult);
            }
            index++;
        }
        return new Pair<>(0,0);
    }
    void swap (int line1,int line2)
    {
        Collections.swap(table,line1,line2);
    }
    void swapNumbers(int line1,int line2 ,int index1 ,int index2)
    {
        String tmp = table.get(line1).getNumber(index1);
        table.get(line1).addNumber(table.get(line2).getNumber(index2),index1);
        table.get(line2).addNumber(tmp,index2);
    }
}
