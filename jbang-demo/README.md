# JBang Demo
Using JBang to build and run JavaFX.

Unfortunately it does not work

Using the JavaFX SDK and CLI to tun ad follow
```shell
export PATH_TO_FX=path/to/javafx-sdk-21/lib
javac --module-path $PATH_TO_FX --add-modules javafx.controls HelloFX.java
java --module-path $PATH_TO_FX --add-modules javafx.controls HelloFX
```

For details see https://openjfx.io/openjfx-docs/#install-javafx
