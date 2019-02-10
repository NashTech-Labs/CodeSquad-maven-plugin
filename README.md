# CodeSquad-maven-plugin
A CodeSquad maven plugin to upload code quality report on CodeSquad server.

# For Report Upload In CodeSquad
1. Add Configuration in pox.xml
 
 &lt;build>
   
        <plugins>
            <plugin>
                <artifactId>codesquad-maven-plugin</artifactId>
                <configuration>
                    <organisationName>XXXXXXXXXX</organisationName>
                    <projectName>XXXXXXXXXX</projectName>
                    <registrationKey>XXXXXXXXXX-XXXXXXXXXX</registrationKey>
                    <modules>
                        <module1>
                            <moduleName>XXXXXXXXXX</moduleName>
                            <files>
                                <file>Absolute path</file>
                            </files>
                        </module1>
                    </modules>
                </configuration>
            </plugin>
        </plugins>
    </build>
    

2. mvn codesquad:ReportUpload (run from project directory terminal to upload reports in codesquad)
