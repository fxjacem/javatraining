package optionaltask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.*;

public class TechnicalDictionary {

    private static final String GIT_BEGIN = "https://github.com";

    private static final String RAW_BEGIN = "https://raw.githubusercontent.com";

    private static final String OUTPUT_DIRECTORY = "src/main/resources/";

    public static void main(String[] args){

        TechnicalDictionary rff = new TechnicalDictionary();

        String url = "https://github.com/Strukturavaltas3-Alap-Java/java-strukturavalto3-alap/blob/main/dictionary.md";
        String filename = "out.md";

        rff.createDictionary(url, filename);
    }

    public void createDictionary(String url, String filename) {
        String lines = urlReader(createRawUrl(url));

        Map<String, String> content = processLines(lines);

        List<String> outputContent = createOutputContent(content);

        writeContentToFile(filename, outputContent);
    }

    private void writeContentToFile(String filename, List<String> raw) {
        try {
            Files.write(Path.of(OUTPUT_DIRECTORY + filename), raw);
        } catch (IOException ioe) {
            throw new IllegalStateException("File write error", ioe);
        }
    }

    private List<String> createOutputContent(Map<String, String> content) {
        List<String> outputContent = new ArrayList<>();

        outputContent.add("| Magyar | Angol |");
        outputContent.add("| --- | --- |");
        for (Map.Entry<String, String> actual : content.entrySet()){
            outputContent.add("| " + actual.getKey() + " | " + actual.getValue() + " |");
        }

        return outputContent;
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
}
