package lesson19;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyProjectListener  implements ITestListener{
    @Override
    public void onStart(ITestContext arg0) {
       //TODO Auto-generated method stub;
    }

    @Override
    public void onFinish(ITestContext arg0) {
        //TODO Auto-generated method stub;
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        //TODO Auto-generated method stub;
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        //TODO Auto-generated method stub;
    }

    @Override
    public void onTestSkipped(ITestResult argo) {
        //TODO Auto-generated method stub;
    }
}