package optionaltask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TechnicalDictionary {

    private static final String GIT_BEGIN = "https://github.com";

    private static final String RAW_BEGIN = "https://raw.githubusercontent.com";


    public Map<String, String> createDictionary(String url) {
        String lines = urlReader(createRawUrl(url));

        return processLines(lines);
    }

    private Map<String, String> processLines(String content) {
        Map<String, String> result = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));

        String[] lines = content.split("\n");
        for (int i = 3; i < lines.length; i++) {
            String[] parts = lines[i].split("\\| ");
            if (parts.length == 3) {
                result.put(parts[1].strip(), parts[2].substring(0, parts[2].length()-1).strip());
            }
        }

        return result;
    }
    private String urlReader(URL url) {
        String content;
        try (Scanner scanner = new Scanner(url.openStream(), String.valueOf(StandardCharsets.UTF_8))) {
            content = scanner.useDelimiter("\\A").next();
        } catch (IOException ioe) {
            throw new IllegalStateException("File read error!", ioe);
        }
        return content;
    }

    private URL createRawUrl(String url)  {
        String[] parts = url.split(GIT_BEGIN);

        try {
            return new URL(RAW_BEGIN + parts[1].replace("/blob", ""));
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Wrong url " + url, e);
        }
    }

    public static void main(String[] args){

        TechnicalDictionary rff = new TechnicalDictionary();
        String url = "https://github.com/Strukturavaltas3-Alap-Java/java-strukturavalto3-alap/blob/main/dictionary.md";

        Map<String, String> content = rff.createDictionary(url);

        for (Map.Entry<String, String> actual : content.entrySet()){
            System.out.println(actual.getKey() + " = " + actual.getValue());
        }
    }
}
