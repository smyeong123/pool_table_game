# Pool Table Game

## Introduction

This source code is implementation for 2022 SOFT2201 A3.
We are recommended you to use ```Java 17```, ```Gradle 7.4```.

## Implementations 

**Note 1:** All the difficulty json file placed in resources directory. That easy one will be named as `config_easy.json`. Normal one will be named as `config_normal.json`. Hard one will be named as `config_hard.json`.

**Note 2:** Score updated once ball is disabled.

**Note 3:** For undo section, `z` need to be pressed before all balls are stopped.

**Note 4** Playable zone is now centred on first pocket location
## Commands

* Run: `gradle run` to load default config from resources folder.
* Press ```z``` to roll back. But it has to be pressed by all balls are stopped
* Press `r` to remove all red balls
* Press `y` to remove all yellow balls
* Press `g` to remove all green balls
* Press `b` to remove all brown balls
* Press `e` to remove all blue balls
* Press `p` to remove all purple balls
* Press `l` to remove all black balls
* Press `o` to remove all orange balls
* Generate documentation:`gradle javadoc`