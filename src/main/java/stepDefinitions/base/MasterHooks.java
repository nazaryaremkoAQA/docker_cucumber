package stepDefinitions.base;

import base.BrowserDriverFactory;
import base.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class MasterHooks extends BrowserDriverFactory {

    private static Utils utils = new Utils();

//    private String log = "output.txt";
//    private File file = new File(log);
//    private String line = "some";
//    private String stopSuccess = "Shutdown complete";
//    private String successStart = "The node is registered to the hub and ready to use";
//    private String successScale = "The node is registered to the hub and ready to use";
//    private Utils utils = new Utils();

    public MasterHooks() throws MalformedURLException {
    }


    @Before
    public void start() throws IOException, InterruptedException {
//
//        String[] start = {"cmd.exe", "/C", "Start", "docker_start.bat"};
//        String[] scale = {"cmd.exe", "/C", "Start", "docker_scale_chrome_5.bat"};
//        if (file.delete()) {
//            System.out.println("File deleted successfully");
//        }
//
//        Runtime.getRuntime().exec(start);
//        Thread.sleep(3000);
//        BufferedReader bf = new BufferedReader(new FileReader(log));
//
//        Calendar cal = Calendar.getInstance();//2:44 15th second
//        cal.add(Calendar.SECOND, 15);//2:44   45seconds
//        long stopnow = cal.getTimeInMillis();
//
//        while (System.currentTimeMillis() < stopnow || line != null) {
//
//            if (line == null) {
//                Thread.sleep(3000);
//                line = bf.readLine();
//            }
//            if (line.contains(successStart)) {
//                break;
//            }
//            line = bf.readLine();
//        }
//
//        Runtime.getRuntime().exec(scale);
//
//        cal = Calendar.getInstance();//2:44 15th second
//        cal.add(Calendar.SECOND, 15);//2:44   45seconds
//        stopnow = cal.getTimeInMillis();
//
//        while (System.currentTimeMillis() < stopnow || line != null) {
//
//            if (line.contains(successScale)) {
//                break;
//            }
//            line = bf.readLine();
//        }
//        bf.close();
//
//        URL url = new URL("http://localhost:4444/wd/hub");
        driver = BrowserDriverFactory.getDriver(utils.getProperty("browser"));

    }

//    @After
//    public void tearDown(Scenario scenario) throws IOException {
//        String[] stop = {"cmd.exe", "/C", "Start", "docker_stop.bat"};
//
//        BufferedReader bf = new BufferedReader(new FileReader(log));
//
//        try {
//            Runtime.getRuntime().exec(stop);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        while (line != null) {
//            if (line.contains(stopSuccess)) {
//                break;
//            }
//            line = bf.readLine();
//        }
//
//        if (file.delete()) {
//            System.out.println("File deleted successfully");
//            file.deleteOnExit();
//
//        }
//        bf.close();
//
//    }
}

