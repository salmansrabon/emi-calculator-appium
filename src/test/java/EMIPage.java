import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EMIPage {
    @FindBy(id = "com.continuum.emi.calculator:id/btnStart")
    MobileElement emiScreen;
    @FindBy(id="com.continuum.emi.calculator:id/etLoanAmount")
    MobileElement txtLoanAmount;
    @FindBy(id="com.continuum.emi.calculator:id/etInterest")
    MobileElement txtInterest;
    @FindBy(id="com.continuum.emi.calculator:id/etYears")
    MobileElement txtPeriod;
    @FindBy(id="com.continuum.emi.calculator:id/etFee")
    MobileElement txtpFee;
    @FindBy(id="com.continuum.emi.calculator:id/btnCalculate")
    MobileElement btnCalculate;
    @FindBy(id="com.continuum.emi.calculator:id/btnReset")
    MobileElement btnReset;

    @FindBy(id="com.continuum.emi.calculator:id/monthly_emi_result")
    MobileElement mEMI;
    @FindBy(id="com.continuum.emi.calculator:id/total_interest_result")
    MobileElement tInterest;
    @FindBy(id="com.continuum.emi.calculator:id/processing_fee_result")
    MobileElement tpFee;
    @FindBy(id="com.continuum.emi.calculator:id/total_payment_result")
    MobileElement tPayment;


    public EMIPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void calculateEMI(int loanAmount, double interest, int period, double fee) {
        txtLoanAmount.sendKeys(""+loanAmount+"");
        txtInterest.sendKeys(""+interest+"");
        txtPeriod.sendKeys(""+period+"");
        txtpFee.sendKeys(""+fee+"");
        btnCalculate.click();
    }
}
