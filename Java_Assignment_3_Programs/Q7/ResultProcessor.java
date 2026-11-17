import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ResultProcessor {

    static class ResultTask implements Callable<String> {
        private String fileName;

        ResultTask(String fileName) {
            this.fileName = fileName;
        }

        public String call() {
            try (BufferedReader br =
                 new BufferedReader(new FileReader(fileName))) {

                String line = br.readLine();

                if (line == null)
                    throw new IOException("Empty file");

                int marks = Integer.parseInt(line);

                if (marks < 0 || marks > 100)
                    throw new IllegalArgumentException("Invalid marks");

                return fileName + ": Success, Marks = " + marks;
            }
            catch (Exception e) {
                return fileName + ": Failed - " + e.getMessage();
            }
        }
    }

    public static void main(String[] args)
            throws Exception {

        ExecutorService pool =
            Executors.newFixedThreadPool(4);

        List<Future<String>> futures = new ArrayList<>();

        String[] files = {
            "student1.txt",
            "student2.txt",
            "student3.txt",
            "student4.txt"
        };

        for (String file : files) {
            futures.add(pool.submit(new ResultTask(file)));
        }

        int success = 0;
        int failure = 0;

        for (Future<String> future : futures) {
            String result = future.get();
            System.out.println(result);

            if (result.contains(": Success"))
                success++;
            else
                failure++;
        }

        pool.shutdown();

        System.out.println("Successful files: " + success);
        System.out.println("Failed files: " + failure);
    }
}
