#!/bin/sh

set -e # Exit script immediately on first error.
set -x # Print commands and their arguments as they are executed.

service docker stop

usermod -aG docker ${USER}
service docker restart
docker run hello-world