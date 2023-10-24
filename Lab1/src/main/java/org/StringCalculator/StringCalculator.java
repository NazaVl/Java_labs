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