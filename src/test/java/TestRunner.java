import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestRunner extends Setup {
    @Test
    public void RunTest() throws InterruptedException, IOException, ParseException {
        Utils utils=new Utils();
        TestCase testCase=new TestCase(driver);
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(testCase.emiScreen));
        testCase.emiScreen.click();
        for(int i=0;i<utils.getDataSize();i++){
            utils.readData(i);
            testCase.calculateEMI(utils.getLoan(),utils.getInterest(),utils.getPeriod(), utils.getpFee());

            String emi=testCase.mEMI.getText();
            String interest=testCase.tInterest.getText();
            String processingFee=testCase.tpFee.getText();
            String totalPayment=testCase.tPayment.getText();

            Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round (Float.parseFloat(emi.replace(",",""))))) ,utils.getmEMI());
            Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round (Float.parseFloat(interest.replace(",",""))))) ,utils.gettInterest());
            Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round (Float.parseFloat(processingFee.replace(",",""))))) ,utils.getTpFee());
            Assert.assertEquals(Integer.parseInt(totalPayment.replace(",","").split("\\.")[0]) ,utils.gettPayment());

            testCase.btnReset.click();
        }


    }


}
