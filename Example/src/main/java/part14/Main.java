package part14;

import part14.common.ArgsException;
import part14.step1.draft.boolNstringNinteger.Args;

import java.text.ParseException;

/**
 * -l true -p 1000 -d test
 */
public class Main {
    public static void main(String[] args) {
        try {
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void executeApplication(boolean logging, int port, String directory) throws ArgsException {

    }
}
