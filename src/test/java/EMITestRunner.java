import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class EMITestRunner extends Setup {
    @BeforeTest
    public void clickEMIScreen(){
        EMIPage testCase=new EMIPage(driver);
        testCase.emiScreen.click();
    }
    @Test(dataProvider = "data-provider", dataProviderClass = Dataset.class)
    public void RunTest(int loanAmount, double rInterest, int period, double pFee, int mEMI, int tInterest, int tpFee, int tPayment) throws InterruptedException, IOException, ParseException {
        EMIPage testCase=new EMIPage(driver);
        testCase.calculateEMI(loanAmount,rInterest,period,pFee);

        String emi=testCase.mEMI.getText();
        String interest=testCase.tInterest.getText();
        String processingFee=testCase.tpFee.getText();
        String totalPayment=testCase.tPayment.getText();

        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round (Double.parseDouble(emi.replace(",",""))))) ,mEMI);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round (Double.parseDouble(interest.replace(",",""))))) ,tInterest);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round (Double.parseDouble(processingFee.replace(",",""))))) ,tpFee);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round(Double.parseDouble(totalPayment.replace(",",""))))) ,tPayment);

        testCase.btnReset.click();

    }

}
