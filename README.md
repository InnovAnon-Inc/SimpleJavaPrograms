# SimpleJavaPrograms
Simple Java Programs, examples for tutoring
==========

Common operations:
- Checkout the project:
  ```git clone https://github.com/InnovAnon-Inc/SimpleJavaPrograms.git```
  ```cd SimpleJavaPrograms```
- Clean, Build and Test the project:
  ```mvn             clean test```
- Deploy artifacts to Maven repository branch on Github:
  ```mvn -DskipTests clean deploy```
- Deploy site/docs to gh-pages branch:
  ```mvn -DskipTests clean site-deploy```
- Tag a release:
  ```mvn -DskipTests clean release:prepare release:perform```

Sub-projects:
- util:                 common utilities
- letter_grade:         assignment 1
- numerical_comparison: assignment 2

These projects can be opened in simple IDEs such as BlueJ,
but common code, such as the util sub-project, must be
built outside the IDE using the build system (Maven; see above) and the artifacts must be
[imported manually](https://stackoverflow.com/questions/12902466/how-can-i-compile-code-that-uses-a-jar-file-class-with-bluej).

# Status
Not stable; no fixes planned
----------
abandoned until maven+github+circleci are able to be integrated in simple projects.
Maven and Github don't integrate well together:
until Github adds real (i.e., more than mere nominal) support for Maven,
Java is not a viable language for software development.
We're not stuck on Github; it's simply the most viable option for releasing public domain code,
as all other artifact repositories are non-free or simply don't work with Maven.
The problem seems to be with Maven, which simply doesn't support Github,
no matter what any documentation might tell you.
After further attempts, I'm now certain that Maven isn't production-ready.
Thanks Apache:
Another old piece of software that somehow managed to make it into widespread industry use before it's stable/reliable.
Prove me wrong: make a Maven project that can integrate with Github.
