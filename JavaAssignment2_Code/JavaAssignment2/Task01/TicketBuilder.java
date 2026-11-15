public class TicketBuilder {
    static String usingString(int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            result += "Field" + i + " ";
        }

        return result;
    }

    static String usingBuilder(int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append("Field").append(i).append(" ");
        }

        return result.toString();
    }

    static String usingBuffer(int n) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < n; i++) {
            result.append("Field").append(i).append(" ");
        }

        return result.toString();
    }

    static void measure(String name, int n, int type) {
        long start = System.nanoTime();

        String result = "";

        for (int i = 0; i < 1000; i++) {
            if (type == 1)
                result = usingString(n);
            else if (type == 2)
                result = usingBuilder(n);
            else
                result = usingBuffer(n);
        }

        long end = System.nanoTime();

        System.out.println(name + " Time: " +
            (end - start) / 1000000.0 + " ms");

        System.out.println("Output Length: " + result.length());
    }

    public static void main(String[] args) {
        int fields = 50;

        measure("String", fields, 1);
        measure("StringBuilder", fields, 2);
        measure("StringBuffer", fields, 3);
    }
}
