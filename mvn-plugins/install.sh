#!/bin/sh

mvn install:install-file -Dfile=epsilon-core-1.5.jar          -DgroupId=org.eclipse.epsilon    -DartifactId=epsilon-core -Dversion=1.5 -Dpackaging=jar
mvn install:install-file -Dfile=epsilon-emf-1.5.jar           -DgroupId=org.eclipse.epsilon    -DartifactId=epsilon-emf -Dversion=1.5 -Dpackaging=jar
mvn install:install-file -Dfile=epsilon-uml-1.5.jar           -DgroupId=org.eclipse.epsilon    -DartifactId=epsilon-uml -Dversion=1.5 -Dpackaging=jar

mvn install:install-file -Dfile=umlrt.profile-1.0.jar         -DgroupId=org.eclipse.papyrusrt  -DartifactId=umlrt.profile -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=codegen.cpp.profile-1.0.jar   -DgroupId=org.eclipse.papyrusrt  -DartifactId=codegen.cpp.profile -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=UMLRTRTS-1.0.jar              -DgroupId=org.eclipse.papyrusrt  -DartifactId=UMLRTRTS -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=profile.standard-1.0.jar      -DgroupId=org.eclipse.uml       -DartifactId=profile.standard -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=uml-5.3.jar                   -DgroupId=org.eclipse.uml2      -DartifactId=uml -Dversion=5.3 -Dpackaging=jar
mvn install:install-file -Dfile=uml.resources-5.3.jar         -DgroupId=org.eclipse.uml2      -DartifactId=uml.resources -Dversion=5.3 -Dpackaging=jar
mvn install:install-file -Dfile=uml.common-5.3.jar            -DgroupId=org.eclipse.uml2      -DartifactId=uml.common -Dversion=5.3 -Dpackaging=jar
mvn install:install-file -Dfile=uml.types-5.3.jar             -DgroupId=org.eclipse.uml2      -DartifactId=uml.types -Dversion=5.3 -Dpackaging=jar

mvn install:install-file -Dfile=mapping.ecore2xml-2.13.jar    -DgroupId=org.eclipse.emf       -DartifactId=mapping.ecore2xml -Dversion=2.13 -Dpackaging=jar
