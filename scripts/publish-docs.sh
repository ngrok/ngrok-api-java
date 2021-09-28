#!/usr/bin/env bash

set -e

rm -rf docs/
mkdir docs
echo 'java-api.docs.ngrok.com' >docs/CNAME
cp -av target/apidocs/* docs
git add docs/
git commit -m 'Update docs' -- docs/
