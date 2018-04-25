/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rtpa1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;

public interface github {

     public static void githubpush(){
        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd && cd \"C:\\Users\\User\\240898-STIW3054-A172-A1\" && git add * && git commit -m \"Testing\" && git pull && git push");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            System.out.println("\nResult : \n");
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            sleep(5000);
        } catch (Exception e) {
            System.out.println("Terminal having problem to run");
        }
    }

}
