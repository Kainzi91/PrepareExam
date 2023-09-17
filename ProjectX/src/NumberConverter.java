import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NumberConverter {

    private int decimalNumber;
    private String binaryNumber;
    private String hexNumber;
    private String octalNumber;
    private String asciiRepresentation;
    private List<String[]> allValues = new ArrayList<>();

    private List<Object> otherAllValues = new ArrayList<>();

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

        this.saveAllValuesAsList();
        this.saveAllValuesAsListToObject();
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
    public void saveAllValuesAsList() {
        String[] values = new String[]{Integer.valueOf(decimalNumber).toString(), binaryNumber, hexNumber, octalNumber, asciiRepresentation};
        allValues.add(values);
    }

    public void saveAllValuesAsListToObject() {
        otherAllValues.clear();

        otherAllValues.add(decimalNumber);
        otherAllValues.add(binaryNumber);
        otherAllValues.add(hexNumber);
        otherAllValues.add(octalNumber);
        otherAllValues.add(asciiRepresentation);
    }

    public List<Object> getAllValuesForObject(){
        return this.otherAllValues;
    }


    public List<String[]> returnMyNumbers(){
        return this.allValues;
    }


    public NumberConverter getCopy() {
        NumberConverter copy = new NumberConverter();
        copy.setDecimalNumber(this.decimalNumber);
        // Andere Eigenschaften könnten hier auch kopiert werden, wenn nötig
        return copy;
    }

    public void myPrint(){
        for(int i = 0; i < allValues.size(); i++){
            for (int j = 0; j < allValues.get(i).length; j++){
                System.out.println(allValues.get(i)[j]);
            }
        }
    }



    @Override
    public String toString() {
        return "NumberConverter{" +
                "decimalNumber=" + decimalNumber +
                ", binaryNumber='" + binaryNumber + '\'' +
                ", hexNumber='" + hexNumber + '\'' +
                ", octalNumber='" + octalNumber + '\'' +
                ", asciiRepresentation='" + asciiRepresentation + '\'' +
                ", allValues=" + allValues.stream().map(Arrays::toString).collect(Collectors.joining(", ")) +
                '}';
    }

}
