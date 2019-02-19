# CodeSquad-maven-plugin
A CodeSquad maven plugin to upload code quality report on CodeSquad server.

# Upload Single Module Project's Report In CodeSquad 

step 1: Add PlugIn in pox.xml
          
            <dependency>
                <groupId>com.github.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>1.0.0</version>
            </dependency>
     
       <build>
          <plugins>
            <plugin>
               <groupId>com.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>0.1</version>                             
                <configuration>
                    <organisationName>XXXXXXXXXX</organisationName>
                    <projectName>XXXXXXXXXX</projectName>
                            <moduleName>XXXXXXXXXX</moduleName>
                            <files>
                                <file>Report's absolute/relative path</file>  // Here you can have multiple file tag. Each file tag should contain report's absolute/relative path. 
                            </files>                 
                </configuration>
            </plugin>
        </plugins>
    </build>
    

# Upload Multi Module Project's Report In CodeSquad 

step 1: Add PlugIn in root pom.xml

    <repositories>
        <repository>
            <id>CodeSquad-maven-plugin</id>
            <url>https://raw.github.com/knoldus/CodeSquad-maven-plugin/codesquad-plugin/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
         
           <plugin>
                <groupId>com.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>0.1</version>
            </plugin>
            
            
 step 2: Add PlugIn in every child pom.xml
 
        <plugin>
                <groupId>com.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>0.1</version>
                <configuration>
                    <organisationName>XXXXXXX</organisationName>
                    <projectName>${project.parent.artifactId}</projectName>
                        <moduleName>${project.artifactId}</moduleName>
                        <files>
                            <file>Report's absolute/relative path</file>// Here you can have multiple file tag. Each file tag should contain report's absolute/relative path. 
                        </files>
                </configuration>
            </plugin>


# export registrationKey=XXXXXXXXXXX
(set registrationKey as environment variable)
# mvn codesquad:ReportUpload
(Upload all module's reports in codesquad)
# mvn codesquad:ReportUpload -pl moduleName
(Upload specific module's reports in codesquad)
