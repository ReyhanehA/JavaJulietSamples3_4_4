/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet_01.java
Label Definition File: CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 382 bad case calls System.exit during a normal work flow.
 Note: System.exit may be justifiable if
  a) significant failures occur during application initialization.
  b) the program is invoked by another application and intended to exit with a
  status code to determine success/failure.
 Otherwise alternatives, such as throwing exceptions should be used as a fail safe
 measure.
* Sinks:
*    GoodSink: notify user, do not use System.exit
*    BadSink : calling System.exit, breaching best practices
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE382_J2EE_Bad_Practices_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.IOException;

public class CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet_01 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        System.exit(1); /* FLAW: use of System.exit */

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */

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

