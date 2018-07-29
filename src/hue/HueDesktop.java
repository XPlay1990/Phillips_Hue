package hue;

import com.philips.lighting.hue.sdk.PHHueSDK;
import data.HueProperties;
import gui.DesktopView;

/**
 * HueDesktop.java
 * An example Java/Swing Desktop application illustrating how to connect to a bridge and change your Hue lights
 * using a Java Desktop Application.
 * 
 * For more information on programming for Hue see:
 * http://developers.meethue.com
 *
 */
class HueDesktop {

    public static void main(String args[]) {
        new HueDesktop();
    }

    public HueDesktop() {
        PHHueSDK phHueSDK = PHHueSDK.create();

        HueProperties.loadProperties();  // Load in HueProperties, if first time use a properties file is created.


        //  Set Up the View (A JFrame, MenuBar and Console).
        DesktopView desktopView = new DesktopView();

        // Bind the Model and View
        Controller controller = new Controller(desktopView);
        desktopView.setController(controller);

        phHueSDK.getNotificationManager().registerSDKListener(controller.getListener());

    }

}