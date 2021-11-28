package com.automationbyTanu.properties;

import com.automationbyTanu.configrationexceptions;

import static com.automationbyTanu.properties.propertyloader.chromedriverpath;
import static com.automationbyTanu.properties.propertyloader.runonbrowser;

public class propertyvalidator {
    public static void validateconfigrations() throws Exception {

        if (runonbrowser.equalsIgnoreCase("Chrome")) {
        }
        if (chromedriverpath.isEmpty()) {
            throw new configrationexceptions("ChromedriverPath empty");
        }
    }
            /*if (runonbrowser.equalsIgnoreCase("Firefox")) {

            }
               if (firefoxdriverapth.isEmpty()) {
                   throw new Configrationexceptions("firefoxdriverpathempty");

               }*/

    }

