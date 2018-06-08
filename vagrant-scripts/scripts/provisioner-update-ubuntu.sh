#!/bin/sh
set -e # Exit script immediately on first error.
set -x # Print commands and their arguments as they are executed.

echo "update ubuntu"
sudo apt-get update -y