package base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserDriverFactory {

    private ThreadLocal<RemoteWebDriver> driverThreadLocal = new ThreadLocal<>();
    private URL url = new URL("http://localhost:4444/wd/hub");
    public static RemoteWebDriver driver;

    private String browser;

    private BrowserDriverFactory(String browser) throws MalformedURLException {
        this.browser = browser;
    }

    public BrowserDriverFactory() throws MalformedURLException {
    }

    public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
        BrowserDriverFactory driverFactory = new BrowserDriverFactory(browser);
        return driverFactory.createDriver();
    }

    private RemoteWebDriver createDriver() {
        ChromeOptions capabilities;

        switch (browser) {
//            case "ie":
//                capabilities = DesiredCapabilities.internetExplorer();
//                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//                capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
//                capabilities.setBrowserName("internet explorer");
//                capabilities.setPlatform(Platform.WINDOWS);
//            case "firefox":
//                capabilities = DesiredCapabilities.firefox();
//                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//                capabilities.setBrowserName("firefox");
//                capabilities.setPlatform(Platform.LINUX);
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-popup-blocking");
                capabilities = options;

        }

        driverThreadLocal.set(new RemoteWebDriver(url, new ChromeOptions()));

        return driverThreadLocal.get();

    }
}
