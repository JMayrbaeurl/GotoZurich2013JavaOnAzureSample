@ECHO OFF

:: Require elevation
if "%_ELEVATED%"=="" (goto:Elevate) else (goto:Deploy)
:Elevate
SET _ELEVATED=1
start /min cscript /NoLogo "%~dp0.elevate.vbs" %~f0
SET _ELEVATED=
exit

:: Deploy the package to emulator
:Deploy
SET _ELEVATED=
"C:\Program Files\Microsoft SDKs\Windows Azure\Emulator\csrun.exe" /devstore
"C:\Program Files\Microsoft SDKs\Windows Azure\Emulator\csrun.exe" "C:\Users\jurgenma.EUROPE\Documents\workspace-sts-3.1.0.RELEASE\bookstore-wadeploy\deploy\WindowsAzurePackage.cspkg" "C:\Users\jurgenma.EUROPE\Documents\workspace-sts-3.1.0.RELEASE\bookstore-wadeploy\deploy\ServiceConfiguration.cscfg"

:: Ensure that emulator UI is running
for /f %%G in ('tasklist ^| find /I /C "dfui.exe"') do set _PROCCOUNT=%%G
if NOT %_PROCCOUNT%==0 goto:Bye
cd /d "C:\Program Files\Microsoft SDKs\Windows Azure\Emulator"
start dfui.exe

:Bye
choice /d y /t 5 /c Y /N
exit
