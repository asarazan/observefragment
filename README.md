# ObserveFragment
A set of Fragment classes that implement the Observer pattern.

### Purpose
We believe that a large number of silly bugs occur on Android because of the unwieldy boilerplate that goes into Lifecycle event handling. 

Simply adding Observer support to fragments enables us to cleanly compartmentalize our code into companion classes that can easily respond to Lifecycle events in the fragment without gumming up its code.

Expect to see these classes used in numerous Level open source projects to come.

### Install

```gradle
dependencies {
  compile 'com.levelmoney.observefragment:observefragment:1.0@aar'
}
```
