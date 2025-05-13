
import java.io.*;
import java.util.*;
import java.util.function.Function;

public class CsvUtil {

    /**
     * Read CSV file and map rows into a list of objects
     *
     * @param filePath CSV file path
     * @param mapper Function that maps the fields of each row into objects
     * after segmentation
     */
    public static <T> List<T> readCsv(String filePath, Function<String[], T> mapper) throws IOException {
        List<T> list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            // Create an empty file if the file does not exist
            file.createNewFile();
            return list;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] fields = line.split(",");
                list.add(mapper.apply(fields));
            }
        }
        return list;
    }

    /**
     * Write the list of objects back to a CSV file
     *
     * @param filePath CSV file path
     * @param list object list
     * @param mapper function that maps objects into string arrays
     * (corresponding to each column field)
     *
     */
    public static <T> void writeCsv(String filePath, List<T> list, Function<T, String[]> mapper) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (T item : list) {
                String[] fields = mapper.apply(item);
                bw.write(String.join(",", fields));
                bw.newLine();
            }
        }
    }
}
