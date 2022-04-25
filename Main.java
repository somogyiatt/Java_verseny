import java.util.*;
import java.lang.*;

class Main {

    public static final String FIRST_OPERATION = "[row - 1][column]";
    public static final String SECOND_OPERATION = "[row][column - 1]";
    public static final String THIRD_OPERATION = "[row + 1][column]";
    public static final String FOURTH_OPERATION = "[row][column + 1]";
    public static final String FIFTH_OPERATION = "[row + 1][column - 1]";
    public static final String SIXTH_OPERATION = "[row - 1][column + 1]";
    public static final String SEVENTH_OPERATION = "[row - 1][column - 1]";
    public static final String EIGHTH_OPERATION = "[row + 1][column + 1]";

    public static final int MAX_FIND_NUMBER = 4;

    public static final long DEFAULT_MULTIPLICATION_VALUE = 1;

    public static void main(String[] args) {

        String[][] matrix = new String[][]{
                {"82", "02", "09", "27", "48", "46", "57", "77", "51", "42", "51", "94", "03", "70", "20", "93", "73", "45", "84", "26", "16", "33", "21", "16", "86"},
                {"16", "97", "30", "39", "45", "44", "07", "05", "33", "07", "32", "36", "42", "52", "47", "66", "34", "56", "04", "68", "37", "19", "47", "87", "01"},
                {"86", "35", "35", "45", "04", "01", "79", "42", "19", "67", "46", "08", "13", "33", "92", "29", "33", "20", "73", "42", "57", "43", "95", "64", "20"},
                {"90", "02", "96", "98", "69", "12", "29", "52", "80", "04", "81", "92", "44", "73", "64", "87", "54", "74", "76", "21", "41", "35", "07", "62", "58"},
                {"12", "68", "55", "66", "72", "07", "33", "16", "80", "34", "59", "26", "87", "41", "68", "84", "71", "81", "76", "84", "26", "71", "62", "79", "18"},
                {"74", "65", "63", "03", "37", "36", "81", "26", "03", "02", "74", "90", "48", "86", "61", "59", "86", "51", "67", "68", "64", "20", "30", "19", "03"},
                {"36", "25", "62", "98", "24", "85", "69", "20", "68", "02", "73", "27", "77", "14", "54", "51", "24", "96", "71", "29", "25", "14", "63", "92", "55"},
                {"20", "23", "06", "43", "20", "11", "73", "39", "31", "54", "06", "90", "82", "75", "56", "96", "80", "52", "49", "50", "37", "49", "04", "74", "89"},
                {"69", "41", "06", "52", "60", "29", "54", "62", "53", "08", "52", "05", "08", "05", "75", "07", "78", "99", "26", "78", "24", "33", "89", "78", "27"},
                {"40", "05", "10", "44", "99", "68", "74", "42", "71", "27", "97", "85", "07", "63", "80", "08", "28", "05", "85", "06", "29", "03", "58", "80", "33"},
                {"27", "48", "94", "93", "15", "10", "95", "42", "44", "55", "45", "27", "88", "83", "02", "31", "73", "31", "11", "61", "43", "07", "31", "98", "07"},
                {"59", "20", "60", "37", "11", "27", "36", "44", "97", "78", "28", "13", "83", "97", "12", "44", "56", "95", "03", "83", "84", "72", "69", "38", "55"},
                {"56", "96", "56", "41", "98", "61", "93", "37", "53", "17", "12", "83", "88", "25", "31", "13", "22", "85", "92", "95", "85", "05", "58", "89", "90"},
                {"23", "35", "19", "16", "36", "06", "04", "85", "62", "38", "84", "86", "59", "42", "89", "20", "12", "96", "91", "55", "45", "59", "30", "11", "14"},
                {"49", "58", "53", "21", "36", "80", "27", "74", "45", "84", "71", "45", "12", "28", "06", "38", "86", "29", "87", "12", "53", "41", "42", "06", "27"},
                {"80", "16", "45", "39", "40", "92", "92", "36", "20", "26", "89", "23", "23", "92", "31", "52", "37", "50", "41", "05", "31", "61", "42", "50", "28"},
                {"69", "87", "50", "99", "14", "61", "82", "37", "41", "06", "18", "26", "04", "02", "82", "03", "04", "74", "32", "79", "45", "14", "66", "20", "08"},
                {"24", "56", "93", "50", "86", "01", "56", "67", "98", "65", "45", "06", "68", "96", "22", "34", "71", "32", "04", "19", "70", "27", "05", "77", "26"},
                {"66", "35", "16", "20", "17", "96", "05", "10", "92", "03", "29", "48", "56", "06", "07", "64", "14", "97", "69", "48", "01", "10", "67", "50", "42"},
                {"38", "18", "63", "22", "36", "15", "40", "91", "89", "02", "68", "01", "34", "64", "06", "52", "98", "26", "82", "86", "19", "68", "66", "62", "85"},
                {"51", "40", "75", "61", "81", "02", "62", "20", "06", "76", "31", "50", "97", "62", "91", "09", "13", "54", "32", "54", "06", "92", "03", "06", "25"},
                {"94", "54", "86", "68", "37", "13", "02", "85", "38", "06", "31", "79", "72", "54", "53", "24", "67", "41", "88", "08", "36", "46", "38", "23", "43"},
                {"92", "74", "81", "58", "38", "08", "88", "20", "57", "77", "95", "51", "68", "65", "75", "31", "05", "14", "79", "29", "48", "46", "27", "64", "85"},
                {"86", "83", "93", "17", "35", "10", "13", "61", "03", "30", "04", "79", "01", "87", "24", "70", "99", "39", "33", "09", "53", "81", "38", "85", "28"},
                {"12", "43", "86", "67", "82", "71", "45", "64", "04", "32", "19", "84", "79", "38", "17", "42", "56", "34", "81", "43", "75", "46", "88", "49", "40"}
        };

        int currentOperationRow;
        int currentOperationColumn;
        int maxRow = matrix.length;
        int maxColumn = matrix[0].length;

        long maxMultiplicationValue = DEFAULT_MULTIPLICATION_VALUE;
        long currentMultiplicationValue;

        String[] valuePosition;

        HashMap<String, Integer> alreadyExaminedValues = new HashMap<String, Integer>();
        HashMap<String, Integer> lastExaminedValue = new HashMap<String, Integer>();

        HashMap<Integer, String> resultMap = new HashMap<Integer, String>();

        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                currentMultiplicationValue = DEFAULT_MULTIPLICATION_VALUE;
                valuePosition = new String[]{};
                do {

                    if (valuePosition.length == 0) {
                        currentOperationColumn = column;
                        currentOperationRow = row;
                    } else {
                        currentOperationColumn = Integer.parseInt(valuePosition[1]);
                        currentOperationRow = Integer.parseInt(valuePosition[0]);
                    }

                    if (alreadyExaminedValues.get((String.valueOf(currentOperationRow) + ':' + String.valueOf(currentOperationColumn))) == null) {
                        alreadyExaminedValues.put((String.valueOf(currentOperationRow) + ':' + String.valueOf(currentOperationColumn)), alreadyExaminedValues.size());
                    }

                    lastExaminedValue.clear();
                    lastExaminedValue.putAll(matrixKereses(matrix, currentOperationRow, currentOperationColumn, maxRow, maxColumn, alreadyExaminedValues));

                    for (String name : lastExaminedValue.keySet()) {
                        valuePosition = name.split(":");
                    }

                    currentMultiplicationValue *= Integer.parseInt(matrix[Integer.parseInt(valuePosition[0])][Integer.parseInt(valuePosition[1])]);
                    alreadyExaminedValues.putAll(lastExaminedValue);

                } while (alreadyExaminedValues.size() < MAX_FIND_NUMBER);

                if (currentMultiplicationValue > maxMultiplicationValue) {
                    maxMultiplicationValue = currentMultiplicationValue;
                    resultMap.clear();

                    for (String key : alreadyExaminedValues.keySet()) {
                        valuePosition = key.split(":");
                        resultMap.put(alreadyExaminedValues.get(key), "matrix[" + valuePosition[0] + "][" + valuePosition[1] + "] = " + matrix[Integer.parseInt(valuePosition[0])][Integer.parseInt(valuePosition[1])]);
                    }
                }
                alreadyExaminedValues.clear();
            }
        }

        for (int key : resultMap.keySet()) {
            System.out.println(resultMap.get(key));
        }
    }

    public static HashMap<String, Integer> matrixKereses(String[][] matrix, int row, int column, int maxRow, int maxColumn, HashMap<String, Integer> alreadyExaminedValues) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        int maxSzam = 0;
        String which_operation = "";

        if (row > 0) {
            if (maxSzam < Integer.parseInt(matrix[row - 1][column]) && (alreadyExaminedValues.get(String.valueOf(row - 1) + ':' + String.valueOf(column)) == null)) {
                maxSzam = Integer.parseInt(matrix[row - 1][column]);
                which_operation = FIRST_OPERATION;
            }
        }
        if (column > 0) {
            if (maxSzam < Integer.parseInt(matrix[row][column - 1]) && (alreadyExaminedValues.get(String.valueOf(row) + ':' + String.valueOf(column - 1)) == null)) {
                maxSzam = Integer.parseInt(matrix[row][column - 1]);
                which_operation = SECOND_OPERATION;
            }
        }
        if (row < maxRow - 1) {
            if (maxSzam < Integer.parseInt(matrix[row + 1][column]) && (alreadyExaminedValues.get(String.valueOf(row + 1) + ':' + String.valueOf(column)) == null)) {
                maxSzam = Integer.parseInt(matrix[row + 1][column]);
                which_operation = THIRD_OPERATION;
            }
        }
        if (column < maxColumn - 1) {
            if (maxSzam < Integer.parseInt(matrix[row][column + 1]) && (alreadyExaminedValues.get(String.valueOf(row) + ':' + String.valueOf(column + 1)) == null)) {
                maxSzam = Integer.parseInt(matrix[row][column + 1]);
                which_operation = FOURTH_OPERATION;
            }
        }
        if (row > 0 && column > 0 && row < maxRow - 1 && column < maxColumn - 1) {
            if (maxSzam < Integer.parseInt(matrix[row + 1][column - 1]) && (alreadyExaminedValues.get(String.valueOf(row + 1) + ':' + String.valueOf(column - 1)) == null)) {
                maxSzam = Integer.parseInt(matrix[row + 1][column - 1]);
                which_operation = FIFTH_OPERATION;
            }
            if (maxSzam < Integer.parseInt(matrix[row - 1][column + 1]) && (alreadyExaminedValues.get(String.valueOf(row - 1) + ':' + String.valueOf(column + 1)) == null)) {
                maxSzam = Integer.parseInt(matrix[row - 1][column + 1]);
                which_operation = SIXTH_OPERATION;
            }
            if (maxSzam < Integer.parseInt(matrix[row - 1][column - 1]) && (alreadyExaminedValues.get(String.valueOf(row - 1) + ':' + String.valueOf(column - 1)) == null)) {
                maxSzam = Integer.parseInt(matrix[row - 1][column - 1]);
                which_operation = SEVENTH_OPERATION;
            }
            if (maxSzam < Integer.parseInt(matrix[row + 1][column + 1]) && (alreadyExaminedValues.get(String.valueOf(row + 1) + ':' + String.valueOf(column + 1)) == null)) {
                which_operation = EIGHTH_OPERATION;
            }
        }
        switch (which_operation) {
            case FIRST_OPERATION:
                resultMap.put((String.valueOf(row - 1) + ':' + String.valueOf(column)), alreadyExaminedValues.size());
                break;
            case SECOND_OPERATION:
                resultMap.put((String.valueOf(row) + ':' + String.valueOf(column - 1)), alreadyExaminedValues.size());
                break;
            case THIRD_OPERATION:
                resultMap.put((String.valueOf(row + 1) + ':' + String.valueOf(column)), alreadyExaminedValues.size());
                break;
            case FOURTH_OPERATION:
                resultMap.put((String.valueOf(row) + ':' + String.valueOf(column + 1)), alreadyExaminedValues.size());
                break;
            case FIFTH_OPERATION:
                resultMap.put((String.valueOf(row + 1) + ':' + String.valueOf(column - 1)), alreadyExaminedValues.size());
                break;
            case SIXTH_OPERATION:
                resultMap.put((String.valueOf(row - 1) + ':' + String.valueOf(column + 1)), alreadyExaminedValues.size());
                break;
            case SEVENTH_OPERATION:
                resultMap.put((String.valueOf(row - 1) + ':' + String.valueOf(column - 1)), alreadyExaminedValues.size());
                break;
            case EIGHTH_OPERATION:
                resultMap.put((String.valueOf(row + 1) + ':' + String.valueOf(column + 1)), alreadyExaminedValues.size());
                break;
            default:
                break;
        }
        return resultMap;
    }

}