@echo off
where gradle >nul 2>nul
if [%ERRORLEVEL%]==[0] (
    gradle %*
) else (
    echo Gradle is not installed or not on PATH. Please install Android Studio or Gradle first.
    exit /b 1
)
