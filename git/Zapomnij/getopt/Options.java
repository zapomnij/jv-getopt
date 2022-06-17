package git.Zapomnij.getopt;

import java.util.Vector;

public class Options {
    // Basic information
    private Vector<String> from;
    private String what;
    
    // Buffer for option argument and index for additional arguments
    public String optarg;
    public int optind = -1;

    // Index
    private int index = 0;
    private boolean acc_colon = false;

    // Class constructor
    public Options(Vector<String> from, String what) {
        this.from = from;
        this.what = what;

        if (what.charAt(0) == ':') {
            acc_colon = true;
        }
    }

    public int getopt() {
        // If we have all options checked, getopt returns -1, what means, that all options are configured
        if (index >= from.size()) {
            return -1;
        }

        for (int i = 0; i < what.length(); i++) {
            // If option is semicolor, just continue loop
            if (what.charAt(i) == ':') {
                continue;
            }

            // Compares argument with option
            if (
                String.format("-%c", what.charAt(i)).equals(from.get(index))
            ) {
                // This 'if' is used to avoid vector/array indexing errors
                if (what.length() != i + 1) {
                    if (what.charAt(i + 1) == ':') {
                        // If option is defined with color, getopt will get an option's argument
                        if (from.size() <= index + 1) {
                            System.err.println("Option " + what.charAt(i) + " requires an argument");
                            return ':';
                        }

                        // Set up optarg and index
                        optarg = from.get(index + 1);
                        index = index + 2;
                    } else index++;
                } else {
                    // If we don't define option with color, getopt will only increase index
                    index++;
                }

                // Return an option
                return what.charAt(i);
            }
        }

        // Checks for unknown option, if first character of options string is ':'
        if ((from.get(index).charAt(0) == '-') && (from.get(index).length() == 2) && (acc_colon)) {
            System.err.println("Unknown option: " + from.get(index));
                    
            // Sets up optind
            if (optind == -1)
                optind = index;
            
            index++;

            // Returns a character, which means unrecognized option
            return '?';
        }

        // Sets of optind
        if (optind == -1)
            optind = index;

        // Increases index and sets up optind
        index++;

        // Returns 0 if there isn't any suspicious things
        return 0;
    }
}
