Port of old JBoss AS 5 JMX Console to Wildfly
===========

# Introduction

In JBoss AS 5 we had a web-based JMX console installed by default. It was placed in /jmx-console context. In JBoss 7 
and above (for example Wildfly) this console has been removed. 

This project contains ported old JMX console which can be started in AS7 and Wildfly.

# Alternatives

There are a couple of alternative tools:
* JConsole
* JVisualVM
* [Howt.io](http://hawt.io/)
* [JBoss RHQ](https://docs.jboss.org/author/display/RHQ/Home)

# Repository layout

This repository contains 2 projects:
* jmx-console WAR modules
* Integration tests

# How to install

It's really easy - just copy war into JBoss AS7/Wildfly deployment directory and you're done. Note that security is 
turned on by default. It will use `ApplicationRealm` with `jmx-console` role.



