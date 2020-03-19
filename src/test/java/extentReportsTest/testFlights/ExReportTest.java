package extentReportsTest.testFlights;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ExReportTest extends BaseTestFly {

        public static ExtentTest extentTest;
        public static ExtentHtmlReporter htmlReporter;
        public static ExtentReports extentReport;

        @BeforeTest
        public void setUpReport(){

            /* Creo una instancia de reporte HTML y le indica la ruta donde quiero que me guarde el informe */
            htmlReporter = new ExtentHtmlReporter("reports/reportDemo/flights.html");
            extentReport = new ExtentReports();
            extentReport.attachReporter(htmlReporter);
        }

        @AfterMethod
        public void getResult(ITestResult result){

            /* En esta funcion, utilizo la clase ExtentTest para registrar los resultados de mis test. */
            /* Segun el estado del test, me va a mostrar diferentes mensajes */

            if(result.getStatus() == ITestResult.FAILURE){
                extentTest.fail(MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
                extentTest.fail(result.getThrowable());
            }

            if(result.getStatus() == ITestResult.SUCCESS){
                extentTest.pass(MarkupHelper.createLabel(result.getName() + " Test Case Passed", ExtentColor.GREEN));
            }

            else{
                extentTest.skip(MarkupHelper.createLabel(result.getName() + " Test Case Skipped", ExtentColor.BLUE));
                extentTest.skip(result.getThrowable());
            }
        }

        @AfterTest
        public void tearDownReport(){
            extentReport.flush();
        }
}