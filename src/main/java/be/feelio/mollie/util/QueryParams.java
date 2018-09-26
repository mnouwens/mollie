package be.feelio.mollie.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class QueryParams extends LinkedHashMap<String, String> {

    public static final QueryParams EMPTY = new QueryParams();

    /**
     * Generate the query string from all the [key, value] pairs
     *
     * @return the query string starting with ?
     */
    public String toString() {
        if (size() == 0) {
            return "";
        }

        StringJoiner sj = new StringJoiner("&", "?", "");
        for (Map.Entry<String, String> entry : this.entrySet()) {
            sj.add(urlEncode(entry.getKey()) + "=" + urlEncode(entry.getValue()));
        }

        return sj.toString();
    }

    private String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
