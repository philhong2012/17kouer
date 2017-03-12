mybatis codegenerator 使用说明
官方参考文档:http://www.mybatis.org/generator/running/runningWithMaven.html


The MBG Maven plugin includes one goal:

mybatis-generator:generate
The goal is not automatically executed by Maven. It can be executed in two ways.

The goal can be executed from the command line with the command:

mvn mybatis-generator:generate
You can pass parameters to the goal with standard Maven command line properties. For example:

mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate


