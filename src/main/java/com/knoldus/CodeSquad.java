package com.knoldus;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Mojo(name = "ReportUpload", threadSafe = true)
public class CodeSquad extends AbstractMojo {

    @Parameter(property = "organisationName", required = true)
    public String organisationName;
    @Parameter(property = "projectName", required = true)
    public String projectName;
    @Parameter(property = "moduleName", required = true)
    public String moduleName;
    @Parameter(property = "file", required = true)
    public List<String> files;

    @Parameter(property = "registrationKey", required = true)
    public String registrationKey;

    private String route = "http://18.221.78.85:8080/add/reports";

    public void execute() throws MojoExecutionException {
        try {
            for (String file : files) {
                String[] command = {"curl", "-X", "PUT", "-F", "projectName=" + projectName, "-F", "registrationKey=" + registrationKey, "-F",
                        "moduleName=" + moduleName, "-F", "organisation=" + organisationName, "-F",
                        "file=@" + file, route};

                ProcessBuilder process = new ProcessBuilder(command);
                Process p = process.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.getProperty("line.separator"));
                }
                String result = builder.toString();
                System.out.print(result);
            }

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
    }
}
