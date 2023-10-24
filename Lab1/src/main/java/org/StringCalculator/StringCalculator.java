package org.StringCalculator;



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
            for (String getValueString : getValuesString ) {
                if (!getValueString.isEmpty()) {
                    try {
                        Integer.parseInt(getValueString);
                    }
                    catch (Exception e){
                        throw new IllegalArgumentException("Incorrect input: " + getValueString);
                    }
                    result += Integer.parseInt(getValueString);
                }
            }
            return result;
        }
    }
}