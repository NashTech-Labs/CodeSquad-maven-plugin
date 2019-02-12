# CodeSquad-maven-plugin
A CodeSquad maven plugin to upload code quality report on CodeSquad server.

# Upload Single Module Project's Report In CodeSquad 

step 1: Add PlugIn in pox.xml
          
       <build>
          <plugins>
            <plugin>
                 <groupId>com.knoldus</groupId>
                               <artifactId>codesquad-maven-plugin</artifactId>
                               <version>1.0-SNAPSHOT</version>                              
                <configuration>
                    <organisationName>XXXXXXXXXX</organisationName>
                    <projectName>XXXXXXXXXX</projectName>
                    <registrationKey>XXXXXXXXXX-XXXXXXXXXX</registrationKey>
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
         
         <plugin> 
                <groupId>com.knoldus</groupId>
                <artifactId>codesquad-maven-plugin</artifactId>
                <version>1.0-SNAPSHOT</version>
            </plugin>
            
            
 step 2: Add PlugIn in every child pom.xml
 
        <plugin>         
                 <groupId>com.knoldus</groupId>
                               <artifactId>codesquad-maven-plugin</artifactId>
                               <version>1.0-SNAPSHOT</version>                              
                <configuration>
                    <organisationName>XXXXXXXXXX</organisationName>
                    <projectName>XXXXXXXXXX</projectName>
                    <registrationKey>XXXXXXXXXX-XXXXXXXXXX</registrationKey>
                            <moduleName>XXXXXXXXXX</moduleName>
                            <files>
                                <file>Report's absolute/relative path</file>  // Here you can have multiple file tag. Each file tag should contain report's absolute/relative path. 
                            </files>                 
                </configuration>
            </plugin>



# mvn codesquad:ReportUpload
(Upload all module's reports in codesquad)
# mvn codesquad:ReportUpload -pl moduleName
(Upload specific module's reports in codesquad)
