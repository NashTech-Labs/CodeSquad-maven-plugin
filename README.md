# CodeSquad-maven-plugin
A CodeSquad maven plugin to upload code quality report on CodeSquad server.

# For Report Upload In CodeSquad
1. Add Configuration in pox.xml

   &lt;configuration &gt;
   
    &lt;organisationName&gt; Organisation Name &lt;/organisationName&gt;
    
     &lt;projectName&gt; Project Name &lt;/projectName&gt;
     
      &lt;moduleName&gt; Module Name &lt;/moduleName&gt;
      
      &lt;registrationKey&gt; Registration Key &lt;/registrationKey&gt;
      
       <files>  // we can have multiple file inside files. 
       
          <file> report file location </file>
          
          <file> report file location </file>
          
         <files>
         
   &lt;/configuration&gt;

2. mvn codesquad:ReportUpload (run from project directory terminal to upload reports in codesquad)
