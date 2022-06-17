package doc;

import java.util.Arrays;
import java.util.Vector;

import git.Zapomnij.getopt.*;

public class Example {
    public static void main(String[] args) {
        // Construct a Options class
        Options opts = new Options(
            // Construct new String vector which contains all passed arguments to program
            new Vector<String>(Arrays.asList(args)), 
            // Options. First colon means that program will stop, if we pass unknown option. 'S:' is definition of -S option which requires an argument.
            // 'a' is definition of option -a which doesn't take any arguments
            ":S:a"
        );

        // Char buffer. Must be a integer
        int c;

        // This is a loop that performs one operation until all arguments are processed
        while ((c = opts.getopt()) != -1) {
            switch (c) {
                case 'S':
                    // If option '-S' is passed, print passed additional argument
                    System.out.println("Argument: " + opts.optarg);
                    break;
                case 'a':
                    // If optiom '-a' is passed, print message: -a passed!
                    System.out.println("-a passed!");
                    break;
                case ':':
                    // If you don't pass argument to option, which needs it, program exits with 1 exit status (indicates an error)
                    System.exit(1);
                    break;
                case '?':
                    // If you pass unknown option and first char of options definition is colon, program exits with 1 exit status (indicates an error)
                    System.exit(1);
                    break;
            }
        }

        // Prints value of optind
        System.out.println("Optind is: " + opts.optind);

        // optind is index of additional argument. -1 means, that there aren't any additional options
        if (opts.optind == -1) {
            System.out.println("There aren't any additional arguments passed to this program");
        } else {
            System.out.print("Additional arguments passed to this program: ");

            // Using optind as index for args, we can do operation for all additional arguments
            for (; opts.optind < args.length; opts.optind++) {
                System.out.print(args[opts.optind] + " ");
            }

            System.out.println();
        }
    }
}
