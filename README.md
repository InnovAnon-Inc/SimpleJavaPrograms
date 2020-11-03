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
abandoned until maven+github+circleci are able to be integrated in any sort of meaningful way.
until then, Java is not a usable language,
as it's not accessible to developers who aren't supported by an entire dev ops team.

