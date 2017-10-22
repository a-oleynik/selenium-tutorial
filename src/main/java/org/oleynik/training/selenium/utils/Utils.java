package org.oleynik.training.selenium.utils;

import org.oleynik.training.selenium.model.RGBA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static RGBA getRGBAFromCSSColor(String cssColor) {
        //"rgba(102, 102, 102, 1)"
        Pattern pattern = Pattern.compile("rgba\\s*\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\)");
        Matcher matcher = pattern.matcher(cssColor);
        RGBA rgba;
        if (matcher.find()) {
            int r = Integer.parseInt(matcher.group(1));
            int g = Integer.parseInt(matcher.group(2));
            int b = Integer.parseInt(matcher.group(3));
            int a = Integer.parseInt(matcher.group(4));
            rgba = new RGBA(r, g, b, a);
        } else throw new RuntimeException("Cannot parse scc color.");
        return rgba;
    }

    public static double getFontSizeValue(String cssFontSize) {
        return Double.parseDouble(cssFontSize.replace("px", "").trim());
    }

}
