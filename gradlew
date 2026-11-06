#!/usr/bin/env sh

if [ -x "$(command -v gradle)" ]; then
    exec gradle "$@"
else
    echo "Gradle is not installed or not on PATH. Please install Android Studio or Gradle first."
    exit 1
fi
