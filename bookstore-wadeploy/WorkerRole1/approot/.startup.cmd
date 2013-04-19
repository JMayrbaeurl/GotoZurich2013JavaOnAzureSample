rd "\%ROLENAME%"
mklink /D "\%ROLENAME%" "%ROLEROOT%\approot"
set SERVER_APPS_LOCATION=\%ROLENAME%

set JAVA_HOME=%ROLEROOT%\approot\jdk1.7.0_13
set PATH=%JAVA_HOME%\bin;%PATH%
set CATALINA_HOME=\%ROLENAME%\apache-tomcat-7.0.37
set SERVER_APPS_LOCATION=%CATALINA_HOME%\webapps
set _JAVA_OPTIONS=-agentlib:jdwp=transport=dt_socket,server=y,address=8090,suspend=n


if exist "bookstore-web.war"\* (echo d | xcopy /y /e "bookstore-web.war" "%SERVER_APPS_LOCATION%\bookstore-web.war") else (echo f | xcopy /y "bookstore-web.war" "%SERVER_APPS_LOCATION%\bookstore-web.war")
start "Windows Azure" /D"%CATALINA_HOME%\bin" startup.bat


:: *** This script will run whenever Windows Azure starts this role instance.
:: *** This is where you can describe the deployment logic of your server, JRE and applications.
:: *** See this project's samples directory for ready made examples.
::     (Note though, that if you're using this in Eclipse, you may find it easier to configure the JDK,
::     the server and the server and the applications using the New Windows Azure Deployment Project wizard 
::     or the Server Configuration property page for a selected role.)

echo Hello World!
exit 0


@ECHO OFF
set ERRLEV=%ERRORLEVEL%
if %ERRLEV%==0 (set _MSG="Startup completed successfully.") else (_MSG="*** Windows Azure startup failed - exiting...")
choice /d y /t 5 /c Y /N /M %_MSG%
exit %ERRLEV%