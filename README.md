# CodeSquad-maven-plugin
A CodeSquad maven plugin to upload code quality report on CodeSquad server.

# For Report Upload In CodeSquad
1. Add Configuration in pox.xml
 
 &lt;build>
   
        <plugins>
            <plugin>
                 <groupId>com.knoldus</groupId>
                               <artifactId>codesquad-maven-plugin</artifactId>
                               <version>1.0-SNAPSHOT</version>
                                <inherited>false</inherited> // Only For multi module
                <configuration>
                    <organisationName>XXXXXXXXXX</organisationName>
                    <projectName>XXXXXXXXXX</projectName>
                    <registrationKey>XXXXXXXXXX-XXXXXXXXXX</registrationKey>
                    <modules>
                        <module>
                            <moduleName>XXXXXXXXXX</moduleName>
                            <files>
                                <file>Absolute path</file>
                            </files>
                        </module>
                    </modules>
                </configuration>
            </plugin>
        </plugins>
    </build>
    

2. mvn codesquad:ReportUpload (run from project directory terminal to upload reports in codesquad)
