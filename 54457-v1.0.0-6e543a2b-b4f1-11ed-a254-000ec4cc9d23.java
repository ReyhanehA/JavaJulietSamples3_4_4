/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE379_File_Creation_in_Insecure_Dir__basic_12.java
Label Definition File: CWE379_File_Creation_in_Insecure_Dir__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 379 File Creation in Insecure Directory
* Sinks: perm
*    GoodSink: securely create dir
*    BadSink : permissions never set on dir
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE379_File_Creation_in_Insecure_Dir;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE379_File_Creation_in_Insecure_Dir__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\insecureDir"; /* may have to be changed depending on script */
            /* POSSIBLE FLAW: potentially insecure directory permissions */
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }
            try
            {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }
        }
        else {

            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\basic\\insecureDir";
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }

            /* FIX: explicitly set directory permissions */
            dir.setExecutable(false, true);
            dir.setReadable(true);
            dir.setWritable(false, true);
            try {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\basic\\insecureDir";
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }
            /* FIX: explicitly set directory permissions */
            dir.setExecutable(false, true);
            dir.setReadable(true);
            dir.setWritable(false, true);
            try
            {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }
        }
        else {

            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\basic\\insecureDir";
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }

            /* FIX: explicitly set directory permissions */
            dir.setExecutable(false, true);
            dir.setReadable(true);
            dir.setWritable(false, true);
            try {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }

        }
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
