#!/bin/sh

set -e

MASTER="main"
RELEASE="release"
MAVEN_CONFIG=".mvn/maven.config"
LOCAL_RELEASE=
RELEASE_CMD="mvn clean deploy"

awsLogin() {
  aws ecr get-login-password --region eu-central-1 | docker login --username "$AWS_USERNAME" --password-stdin "$AWS_ACCOUNT"
}

releaseWithTag() {
  git add $MAVEN_CONFIG
  git commit -m "Preparing release $1"
  git tag "$1"
  if [ -z "$LOCAL_RELEASE" ]; then
    git push
    git push origin "$1"
  fi
  git checkout "$1"
}

mergeChanges() {
  printf '%s' "Merge $MASTER into $RELEASE, OK? [yN]"
  read -r yn
  case $yn in
  'y')
    git merge "$MASTER"
    ;;
  *)
    printf '%s\n' "Merge skipped"
    ;;
  esac
}

init() {
  git checkout $MASTER
  if [ -z "$LOCAL_RELEASE" ]; then
    git pull
  fi
  git checkout $RELEASE
  if [ -z "$LOCAL_RELEASE" ]; then
    git pull
  fi
}

if [ -z "$LOCAL_RELEASE" ]; then
  printf '%s\n' "Not a local release, will try to apply changes to remote repositories"
else
  printf '%s\n' "Local release, no changes will be applied to remote repositories"
fi
init
currentRevision=$(cut -f1- -w "$MAVEN_CONFIG" | tr -s "[:space:]" "\n" | grep "\-Drevision=" | cut -c12-)
userResponse=$(./version_wizard.sh $currentRevision)
set -- $userResponse
nextRevision=$1
if [ -z $2 ]; then
  mergeChanges
fi
printf '%s' "Are you ready to release $nextRevision?"
read -r yn
case $yn in
'y')
  printf '%s\n' "Executing release..."
  sed -i.bak 's/Drevision='"$currentRevision"'/Drevision='"$nextRevision"'/' "$MAVEN_CONFIG"
  releaseWithTag "v$nextRevision"
  /bin/sh -c "$RELEASE_CMD"
  ;;
*)
  printf '%s\n' "Release cancelled"
  ;;
esac
printf '%s\n' "Done"
