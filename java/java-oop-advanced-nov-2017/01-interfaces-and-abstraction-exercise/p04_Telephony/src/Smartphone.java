import interfaces.Browsable;
import interfaces.Callable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private String[] phoneNumbers;
    private String[] urls;

    Smartphone(String[] phoneNumbers, String[] webSites) {
        this.phoneNumbers = phoneNumbers;
        this.urls = webSites;
    }

    private String checkForValidUrl(String url) {
        Pattern validUrlPattern = Pattern.compile("(?<validUrl>\\bhttp:\\/\\/[^0-9\\s]+\\.[a-z]+\\b)");
        Matcher validUrlMatcher = validUrlPattern.matcher(url);

        if (validUrlMatcher.find()) {
            return String.format("Browsing: %s!", validUrlMatcher.group());
        } else {
            return "Invalid URL!";
        }
    }

    private String checkForValidNum(String number) {
        Pattern validNumPattern = Pattern.compile("(?<validNum>\\b\\d+\\b)");
        Matcher validNumMatcher = validNumPattern.matcher(number);

        if (validNumMatcher.find()) {
            return String.format("Calling... %s", validNumMatcher.group());
        } else {
            return "Invalid number!";
        }
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        for (String phoneNumber : this.phoneNumbers) {
            result.append(checkForValidNum(phoneNumber)).append(System.lineSeparator());
        }
        return result.toString();
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        for (String url : this.urls) {
            result.append(checkForValidUrl(url)).append(System.lineSeparator());
        }
        return result.toString();
    }
}
