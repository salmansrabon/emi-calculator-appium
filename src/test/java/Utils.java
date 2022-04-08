import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    private int loan;
    private double interest;
    private int period;
    private double pFee;
    private int mEMI;
    private int tInterest;
    private int tpFee;
    private int tPayment;

    public Utils() throws IOException, ParseException {
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getpFee() {
        return pFee;
    }

    public void setpFee(double pFee) {
        this.pFee = pFee;
    }

    public int getmEMI() {
        return mEMI;
    }

    public void setmEMI(int mEMI) {
        this.mEMI = mEMI;
    }

    public int gettInterest() {
        return tInterest;
    }

    public void settInterest(int tInterest) {
        this.tInterest = tInterest;
    }

    public int getTpFee() {
        return tpFee;
    }

    public void setTpFee(int tpFee) {
        this.tpFee = tpFee;
    }

    public int gettPayment() {
        return tPayment;
    }

    public void settPayment(int tPayment) {
        this.tPayment = tPayment;
    }
    String fileName="./src/test/resources/DataSet.json";
    JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(new FileReader(fileName));
    JSONArray jsonArray = (JSONArray) obj;

    public int getDataSize(){
        return jsonArray.size();
    }
    public void readData(int pos) {
        JSONObject json = (JSONObject) jsonArray.get(pos);
        setLoan(Math.toIntExact((Long) json.get("loan")));
        setInterest((double) json.get("interest"));
        setPeriod (Math.toIntExact((Long) json.get("period")));
        setpFee ((double) json.get("pFee"));
        setmEMI(Math.toIntExact((Long) json.get("mEMI")));
        settInterest(Math.toIntExact((Long) json.get("tInterest")));
        setTpFee (Math.toIntExact((Long) json.get("tpFee")));
        settPayment(Math.toIntExact((Long) json.get("tPayment")));
    }
}
