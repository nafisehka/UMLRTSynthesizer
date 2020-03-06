# UMLRTSynthesizer
UMLRTSynthesizer is a model synthesizer that takes input a structural model of an RTE system using UML-RT (UML profile for real-time system) and a set of pre/post constraints, and then synthesizes a behavioural model consistent with the system and the constraints. UMLRTSyntesizer synthesizes the behavioural model in four phases: (1) It generates a synthesis formula for each component, which is consistent with system properties and structural models, and respects the execution semantics of the component. (2) It performs a State-Space Exploration (SSE) by enumeration of all possible input messages of the component. Each step of the SSE solves the synthesis formula in a different context, based on input messages and the current execution state. The result of the SSE is saved in a Labeled Transition System (LTS). (3) The LTS produced in phase 2 does not include actions (i.e., action code). A backtracking algorithm is used to search over the set of possible actions to find a sequence of actions for each transition. During the search, each action is executed and checked based on the synthesis formula, to ensure its consistency with the system properties. (4) Finally, it applies state merging techniques adapted from existing work to minimize the number of states in the LTSs, transform them into UML-RT SMs, and integrate them with the structural models.
UMLRTSynthesizer uses Papyrus-RT, Eclipse Modeling Framework (EMF), Epsilon transformation language, Xtext, and Microsft Z3.

# Background

As stated, UMLRTSynthesizer synthesizes UMLRT models. The following links may provide useful resources regarding the UML-RT concepts, and using PapyrusRT.

[PapyrusRT Website](https://eclipse.org/papyrus-rt/)

[PapyrusRT Forums](https://www.eclipse.org/forums/index.php/f/314/)

[Getting Started with PapyrusRT](https://wiki.eclipse.org/Papyrus-RT/User/User_Guide/Getting_Started)

[UML-RT Language Concepts](https://pdfs.semanticscholar.org/7fae/fac63155a404e431c97201f89fc8c37a7d62.pdf)

[An executable formal semantics for UML-RT](https://link.springer.com/article/10.1007/s10270-014-0399-z)


# Building code 
You can use the following steps to build and run the code. Note that we only tested the following instruction on Mac. If you try it in other operating systems and face issues. Feel free to open an issue and we would happily help you to get issues to be resolved.

## Prerequisites
Before starting the build, the following tools/libraies need to be installed.

- Java 1.8 
- Microsoft Z3 version 3: you can find the Z3 For Mac [here](https://github.com/Z3Prover/z3/releases/download/z3-4.8.6/z3-4.8.6-x64-osx-10.14.6.zip). 

- Install required MVN plugin: The code uses EMF, Papyrus-RT, and several other libraries that are not available publicly as mvn plugins. For those libraries, you need to install them manually as mvn plugin. Do not worry, we already have prepared a script along with libraries and you only need to run the script to install them. After you clone the project, open a terminal and follow the below instruction:

```
cd /to/project/location
cd mvn-plugins
./install

```


The script uses mvn, so please make sure that mvn is installed before running the script. Also, check the output of the script and make sure that all of the plugins are installed successfully.

## Compile and build the code
Once the prerequisites are installed, you can simply compile and build the project using the following commands.

```
cd /to/project/location
cd cd umlrtsyntesizer.ExecTraces.parent/
mvn install

cd umlrtsyntesizer.constLang.parent/
mvn install

cd UMLRTSynthesizer
mvn install or mvn compile

```


## run the tool 
Once UMLRTSynthesizer is built sucessfully, you may run it using the following commands:

```
cd /path/to/project/UMLRTSynthesizer/target

java -jar UMLRTSynthesizer-jar-with-dependencies.jar -m /path/to/strucuraul model -s /path/to/constraintscript . -o /path/to/output

```

You may run the tool without passing argument, and It will show you the option as shown below:

```
Usage: UMLRTSyntesizer [options]
  Options:
  * -outputDir, -o
      Directory where the result will be saved
  * -script, -s
      Path of the constraint script
  * -umlrtmodel, -m
      Path of the structural UMLRTModel model


```

Sample models and scripts are available at `Evaluation-Result`. 


