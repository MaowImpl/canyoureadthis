import java.util.regex.Pattern;

// A Java version of the Main.kt class so I can show people that Kotlin is, in fact, superior.
public class Main {
    private static final Pattern SUFFIXES = Pattern.compile("[.,!?:;'\"]");

    public static void main(String[] args) {
        if (args.length == 1) {
            final StringBuilder builder = new StringBuilder();
            for (String s : args[0].split(" ")) {
                if (s.length() > 3)
                    s = s.charAt(0) + getMiddle(s) + getEnd(s);
                builder
                        .append(s)
                        .append(' ');
            }
            System.out.println(builder.toString());
        }
    }

    /**
     * PLACEHOLDER
     */
    public static String getMiddle(String s) {
        return s;
    }

    /**
     * PLACEHOLDER
     */
    public static String getEnd(String s) {
        return s;
    }
}
