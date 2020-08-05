package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}, glue = {
        "stepDefinitions"}, monochrome = true, tags = {}
        ,
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})

public class MainRunner extends AbstractTestNGCucumberTests {


    private static String log = "output.txt";
    private static File file = new File(log);
    private static String line = "some";
    private static String stopSuccess = "Shutdown complete";
    private static String successStart = "The node is registered to the hub and ready to use";
    private static String successScale = "The node is registered to the hub and ready to use";


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    public static void start() throws IOException, InterruptedException {

        String[] start = {"cmd.exe", "/C", "Start", "docker_start.bat"};
        String[] scale = {"cmd.exe", "/C", "Start", "docker_scale_chrome_5.bat"};
        if (file.delete()) {
            System.out.println("File deleted successfully");
        }

        Runtime.getRuntime().exec(start);
        Thread.sleep(3000);
        BufferedReader bf = new BufferedReader(new FileReader(log));

        Calendar cal = Calendar.getInstance();//2:44 15th second
        cal.add(Calendar.SECOND, 15);//2:44   45seconds
        long stopnow = cal.getTimeInMillis();

        while (System.currentTimeMillis() < stopnow || line != null) {

            if (line == null) {
                Thread.sleep(3000);
                line = bf.readLine();
            }
            if (line.contains(successStart)) {
                break;
            }
            line = bf.readLine();
        }

        Runtime.getRuntime().exec(scale);

        cal = Calendar.getInstance();//2:44 15th second
        cal.add(Calendar.SECOND, 15);//2:44   45seconds
        stopnow = cal.getTimeInMillis();

        while (System.currentTimeMillis() < stopnow || line != null) {

            if (line.contains(successScale)) {
                break;
            }
            line = bf.readLine();
        }
        bf.close();

        URL url = new URL("http://localhost:4444/wd/hub");
    }

    @AfterClass
    public static void tearDown() throws IOException {
        String[] stop = {"cmd.exe", "/C", "Start", "docker_stop.bat"};

        BufferedReader bf = new BufferedReader(new FileReader(log));

        try {
            Runtime.getRuntime().exec(stop);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (line != null) {
            if (line.contains(stopSuccess)) {
                break;
            }
            line = bf.readLine();
        }

        if (file.delete()) {
            System.out.println("File deleted successfully");
            file.deleteOnExit();

        }
        bf.close();

    }



}