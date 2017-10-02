@echo off
set BASE_ROOT=..\deors.demos.annotations.module
set PROC_ROOT=..\deors.demos.annotations.module.processors
set OPT=-XprintProcessorInfo -XprintRounds
set CP=%BASE_ROOT%\target\deors.demos.annotations.module-1.0-SNAPSHOT.jar
set PRP=%CP%;%PROC_ROOT%\target\deors.demos.annotations.module.processors-1.0-SNAPSHOT.jar
set SRC=src\main\java\deors\demos\annotations\module\client\Article.java
set GEN_SRC=target\generated-sources\annotations
set GEN_CLS=target\classes
mkdir %GEN_SRC%
mkdir %GEN_CLS%
javac %OPT% --module-path %CP% -processorpath %PRP% %SRC% -s %GEN_SRC% -d %GEN_CLS%
