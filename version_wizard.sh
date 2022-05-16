#!/bin/sh

revision=$1
version=$(echo "$revision" | cut -f1 -d'-')

isReleaseCandidate=$(echo "$revision" | grep "^[0-9]\+\.[0-9]\+\.[0-9]\+.*\-RC[0-9]\+$")
isRelease=$(echo "$revision" | grep "^[0-9]\+\.[0-9]\+\.[0-9]\+$")
if [ -z "$isReleaseCandidate" ] && [ -z "$isRelease" ]; then
  printf '%s\n' "Invalid revision $revision, cannot infer next version number" >/dev/tty
  printf '%s' "Enter custom version: " >/dev/tty
  read -r selectedVersion </dev/tty
  printf '\n'
fi

if [ -n "$isReleaseCandidate" ] && [ -z "$selectedVersion" ]; then
  currentRc=$(echo "$revision" | cut -f2 -d'-' | cut -c3-)
  nextRc="$version-RC$((currentRc + 1))"
  printf '%s\n' "You are currently on Release Candidate $revision. What would you like to do?" >/dev/tty
  printf '%s\n' " [1] Build next RC $nextRc in this release cycle" >/dev/tty
  printf '%s\n' " [2] Build release $version from current RC " >/dev/tty
  printf '%s\n' " [3] Begin new release cycle" >/dev/tty
  while true; do
    read -r response </dev/tty
    case $response in
    '1')
      selectedVersion="$nextRc"
      break
      ;;
    '2')
      selectedVersion="$version 1"
      break
      ;;
    '3')
      selectedVersion=
      break
      ;;
    *)
      printf '%s\n' "Unknown response, try again:" >/dev/tty
      ;;
    esac
  done
fi

if [ -z "$selectedVersion" ]; then
  major=$(echo "$revision" | cut -f1 -d'.')
  minor=$(echo "$revision" | cut -f2 -d'.')
  patch=$(echo "$revision" | cut -f3 -d'.' | cut -f1 -d'-')
  nextMajor="$((major + 1)).0.0-RC1"
  nextMinor="$major.$((minor + 1)).0-RC1"
  nextPatch="$major.$minor.$((patch + 1))-RC1"
  printf '%s\n' "You are currently on revision: $revision. What would you like to do?" >/dev/tty
  printf '%s\n' " [1] Begin new patch release cycle ($nextPatch)?" >/dev/tty
  printf '%s\n' " [2] Begin new minor release cycle ($nextMinor)?" >/dev/tty
  printf '%s\n' " [3] Begin new major release cycle ($nextMajor)?" >/dev/tty
  printf '%s\n' " [4] Build new release with custom version" >/dev/tty
  while true; do
    read -r response </dev/tty
    case $response in
    '1')
      selectedVersion="$nextPatch"
      break
      ;;
    '2')
      selectedVersion="$nextMinor"
      break
      ;;
    '3')
      selectedVersion="$nextMajor"
      break
      ;;
    '4')
      printf '%s' "Enter custom version: " >/dev/tty
      read -r selectedVersion </dev/tty
      printf '\n'
      break
      ;;
    *)
      printf '%s\n' "Unknown response, try again:" >/dev/tty
      ;;
    esac
  done
fi

echo "$selectedVersion"
