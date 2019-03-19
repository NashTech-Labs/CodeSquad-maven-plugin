package com.knoldus;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Mojo(name = "ReportUpload", threadSafe = true)
public class CodeSquad extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.directory}")
    private String target;
    @Parameter(defaultValue = "${project.artifactId}")
    private String moduleName;

    private String route = "http://52.15.45.40:8080/add/reports";

    private void uploadReport(String organisationName, String projectName, String moduleName, String registrationKey, String file) {
        if (new File(file).exists()) {
            try {
                String[] command = {"curl", "-X", "PUT", "-F", "projectName=" + projectName, "-F", "registrationKey=" + registrationKey, "-F",
                        "moduleName=" + moduleName, "-F", "organisation=" + organisationName, "-F",
                        "file=@" + file, route};

                ProcessBuilder processBuilder = new ProcessBuilder(command);
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.getProperty("line.separator"));
                }
                String result = builder.toString();
                System.out.print(result);
            } catch (IOException e) {
                System.out.print("error");
                e.printStackTrace();
            }
        }
    }

    public void execute() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(".codesquad.properties");
            properties.load(fileInputStream);
            String registrationKey = System.getenv("registrationKey");
            String organisationName = properties.getProperty("organisationName");
            String projectName = properties.getProperty("projectName");

            if (registrationKey == null)
                throw new MojoExecutionException("Please add registrationKey in environment variable.");

            if (projectName == null || organisationName == null)
                throw new IllegalAccessException("Please add projectName and organisationName in .codesquad.properties");

            String[] command = {"mvn", "clean", "verify"};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            String result = builder.toString();
            System.out.print(result);

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                uploadReport(organisationName, projectName, moduleName, registrationKey, target + "/checkstyle-result.xml");
                uploadReport(organisationName, projectName, moduleName, registrationKey, target + "/cpd.xml");
                uploadReport(organisationName, projectName, moduleName, registrationKey, target + "/pmd.xml");
                uploadReport(organisationName, projectName, moduleName, registrationKey, target + "/findbugsXml.xml");
                uploadReport(organisationName, projectName, moduleName, registrationKey, target + "/site/jacoco/jacoco.xml");
            }
        } catch (Exception ex) {
            System.out.print("Error" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
