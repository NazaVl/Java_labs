package org.StringCalculator;

import java.util.Arrays;
import java.util.ArrayList;

public class StringCalculator {
    public int add(String stringAdd) {
        if (stringAdd.isEmpty())
        {
            return 0;
        }
        else
        {
            int result = 0;
            if (stringAdd.contains("//")){
                    String delimiter = stringAdd.substring(2, stringAdd.indexOf("\n"));
                    if (delimiter.length() > 1){
                        throw new IllegalArgumentException("Incorrect input: " + delimiter);
                    }
                    stringAdd = stringAdd.substring(stringAdd.indexOf("\n") + 1).replace(delimiter, ",");
            }
            stringAdd = stringAdd.replace("\n", ",");
            if (stringAdd.contains(",,")){
                throw new IllegalArgumentException("Incorrect input: get to delimiters in row.");
            }
            String[] getValuesString = stringAdd.split(",");
            ArrayList<Integer> negativeNumbers = new ArrayList<>(0);
            for (String getValueString : getValuesString ) {
                if (!getValueString.isEmpty()) {
                    try {
                        Integer.parseInt(getValueString);
                    }
                    catch (Exception e){
                        throw new IllegalArgumentException("Incorrect input: " + getValueString);
                    }
                    if (Integer.parseInt(getValueString) <= 0) {
                        negativeNumbers.add(Integer.parseInt(getValueString));
                    }
                    result += Integer.parseInt(getValueString);
                }
            }
            if (!negativeNumbers.isEmpty())
                throw new NumberFormatException("Exception! Used negative numbers: " + Arrays.toString(new ArrayList[]{negativeNumbers}));
            return result;
        }
    }
}