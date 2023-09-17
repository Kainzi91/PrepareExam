import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NumberConverter {

    private int decimalNumber;
    private String binaryNumber;
    private String hexNumber;
    private String octalNumber;
    private String asciiRepresentation;

    private List<Object> aktValues = new ArrayList<>();

    private List<Object[]> history = new ArrayList<>();



    public NumberConverter() {
    }

    /**
     *
     * @Setter
     */
    public void setDecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
        this.binaryNumber = Integer.toBinaryString(decimalNumber);
        this.hexNumber = Integer.toHexString(decimalNumber).toUpperCase();
        this.octalNumber = Integer.toOctalString(decimalNumber);



        try {
            if (decimalNumber >= 0 && decimalNumber <= 65535) {
                this.asciiRepresentation = Character.toString((char) decimalNumber);
            } else {
                throw new IllegalArgumentException("The decimal number is out of valid ASCII range");
            }
        } catch (IllegalArgumentException e) {
            this.asciiRepresentation = "INVALID";
            System.out.println(e.getMessage());
        }

        aktValues.clear(); // löschen Sie zuerst alle vorherigen Werte
        aktValues.add(decimalNumber);
        aktValues.add(binaryNumber);
        aktValues.add(hexNumber);
        aktValues.add(octalNumber);
        aktValues.add(asciiRepresentation);

        history.add(aktValues.toArray());

    }

    public void setBinaryNumber(String binaryNumber) {
        this.binaryNumber = binaryNumber;
        this.decimalNumber = Integer.parseInt(binaryNumber, 2);
        setDecimalNumber(this.decimalNumber); // Update other representations
    }

    public void setHexNumber(String hexNumber) {
        this.hexNumber = hexNumber.toUpperCase();
        this.decimalNumber = Integer.parseInt(hexNumber, 16);
        setDecimalNumber(this.decimalNumber); // Update other representations
    }

    public void setOctalNumber(String octalNumber) {
        this.octalNumber = octalNumber;
        this.decimalNumber = Integer.parseInt(octalNumber, 8);
        setDecimalNumber(this.decimalNumber); // Update other representations
    }

    public void setAsciiRepresentation(String asciiRepresentation) {
        this.asciiRepresentation = asciiRepresentation;
        this.decimalNumber = (int) asciiRepresentation.charAt(0);
        setDecimalNumber(this.decimalNumber); // Update other representations
    }

    /**
     *
     * @Getter
     */
    public int getDecimalNumber() {
        return decimalNumber;
    }
    public Object[][] getHistory() {
        return history.toArray(new Object[0][]);
    }

    public String getBinaryNumber() {
        return binaryNumber;
    }

    public String getHexNumber() {
        return hexNumber;
    }

    public String getOctalNumber() {
        return octalNumber;
    }

    public String getAsciiRepresentation() {
        return asciiRepresentation;
    }

    /**
     *
     * @Getter all
     */
    public Object[] getAktValues() {
        return  aktValues.toArray();
    }




    @Override
    public String toString() {
        return "NumberConverter{" +
                "decimalNumber=" + decimalNumber +
                ", binaryNumber='" + binaryNumber + '\'' +
                ", hexNumber='" + hexNumber + '\'' +
                ", octalNumber='" + octalNumber + '\'' +
                ", asciiRepresentation='" + asciiRepresentation + '\'' +
                '}';
    }

    public void printHistory() {
        System.out.println("---- History ----");
        for (Object[] entry : history) {
            for (Object value : entry) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

}
