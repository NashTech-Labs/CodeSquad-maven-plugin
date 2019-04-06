# CodeSquad-maven-plugin
A CodeSquad maven plugin is to upload code quality report on CodeSquad server.

## 1. Upload Single Module Project's Report In CodeSquad 

step 1: Add Plugin in pom.xml
          
       <build>
          <plugins>
            <plugin>
            <groupId>com.github.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>1.0.2</version>                            
            </plugin>
        </plugins>
    </build>
    

## 1. Upload Multi Module Project's Report In CodeSquad 

step 1: Add Plugin in root pom.xml

           <plugin>
               <groupId>com.github.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>1.0.2</version>
            </plugin>
            
            
 step 2: Add PlugIn in every child pom.xml
           
           <plugin>
                 <groupId>com.github.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>1.0.2</version>
            </plugin>

## 2. output directory for file reports should be following.
    a)checkstyle:  target/checkstyle-result.xml
    b)cpd:         target/cpd.xml
    c)pmd:         target/pmd.xml
    d)findbugs:    target/findbugsXml.xml
    e)jacoco:      target/site/jacoco/jacoco.xml

## 3. create file .codesquad.properties in project base directory with following infomation
   
      organisationName=XXXXXXX
      projectName=XXXXXX

## 4. export registrationKey=XXXXXXXXXXX
set registrationKey as environment variable
## 5. mvn codesquad:reportUpload
Upload all module's reports in codesquad


# Alternative(Second) way to upload code quality report on CodeSquad server.


## 1. Upload Single Module Project's Report In CodeSquad 

step 1: Add Plugin in pom.xml
          
       <build>
          <plugins>
            <plugin>
            <groupId>com.github.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>1.0.0</version>                            
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
    

## 1. Upload Multi Module Project's Report In CodeSquad 

step 1: Add Plugin in root pom.xml

           <plugin>
               <groupId>com.github.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>1.0.0</version>
            </plugin>
            
            
 step 2: Add PlugIn in every child pom.xml
 
        <plugin>
                 <groupId>com.github.knoldus</groupId>
                <artifactId>codesquad</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <organisationName>XXXXXXX</organisationName>
                    <projectName>${project.parent.artifactId}</projectName>
                        <moduleName>${project.artifactId}</moduleName>
                        <files>
                            <file>Report's absolute/relative path</file>// Here you can have multiple file tag. Each file tag should contain report's absolute/relative path. 
                        </files>
                </configuration>
            </plugin>


## 2. export registrationKey=XXXXXXXXXXX
set registrationKey as environment variable
## 3. mvn codesquad:ReportUpload
Upload all module's reports in codesquad
## 4. mvn codesquad:ReportUpload -pl moduleName
Upload specific module's reports in codesquad
