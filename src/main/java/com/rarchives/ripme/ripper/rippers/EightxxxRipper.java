package com.rarchives.ripme.ripper.rippers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.rarchives.ripme.ripper.AbstractHTMLRipper;
import com.rarchives.ripme.ui.RipStatusMessage.STATUS;
import com.rarchives.ripme.utils.Http;  

public class EightxxxRipper extends AbstractHTMLRipper {

public EightxxxRipper(URL url) throws IOException {
        super(url);
    }

@Override
    public String getHost() {
        return "8xxx";
    }

@Override
    public String getDomain() {
        return "8xxx.net";
    }

@Override
    public String getGID(URL url) throws MalformedURLException {
        Pattern p = Pattern.compile("^https?://8xxx\\.net/category/([a-zA-Z0-9]+).*$");
        Matcher m = p.matcher(url.toExternalForm());
        if (m.matches()) {
            // Return the text contained between () in the regex
            throw new MalformedURLException("Expected 8xxx.net URL format: " +
                        "8xxx.net/category/categoryname - got " + url + " instead");
        }
        return m.group(1);
        
    }

@Override
    public Document getFirstPage() throws IOException {
        // "url" is an instance field of the superclass
        return Http.url(url).get();
    }

@Override
    public List<String> getURLsFromPage(Document doc) {
        List<String> result = new ArrayList<String>();
        for (Element el : doc.select("img")) {
            result.add(el.attr("src"));
        }
        return result
    }

@Override
    public void downloadURL(URL url, int index) {
        addURLToDownload(url, getPrefix(index));
    }
    @Override
    public String getPrefix(int index) {
        return String.format("%03d_", index);
    }
}
