# Mezu framework
A minimalistic Java based failsafe event driven framework

Based on the amazing work of: *Hydrotoast*, check github profile at https://github.com/Hydrotoast

## Event-Driven Programming

Most programs and devices like a cellphone respond to events — things that happen. For example, you might move your mouse, and the computer responds. Or you click a button, and the program does something interesting. In this chapter we’ll touch very briefly on how event-driven programming works.

## Features

* Minimalistic Event driven framework.
* Full code failsafe.
* Full error handling using exception messages.
* Stable, light and fast.

## Description

This framework is built using pure Java and for starting using it you only need 3 things:

* An event dispatcher (EbentDispatcher.class)
* A dispatchable event (AbstractEvent.class)
* An event handler (AbstractHandler.class)

Once you have declared your Event class and your Handler for that event you can link them on dispatcher. This is all you need to do to link a some kind of behaviour to an action.

### Usage

1. Create an `DemoEvent` class that inherits from `AbstractEvent`.

  ```java
  public class DemoEvent extends AbstractEvent {
  
      private String name;
  
      public DemoEvent(String name) {
          this.name = name;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  }
  ```

2. Create a `DemoHandler` class that inherits from `AbstractHandler`. This class must hold the logic that you want to do when receiving that type of event. In this case, is just a simple `println`on `name` variable.

  ```java
  public class DemoHandler extends AbstractHandler {
  
      @Override
      public void dispatch(AbstractEvent message) {
          DemoEvent demoEvent = (DemoEvent) message;
          System.out.println("This message says: " + demoEvent.getName());
          System.out.println("Demo event successfully dispatched!");
      }
  }
  ```

3. Register the created `DemoHandler` and link to that event. Link the handler to be executed when receiving a `DemoEvent` class message.

  ```java
  dispatcher.registerEventHandler(DemoEvent.class, new DemoHandler());
  ```

4. Dispatch a new `DemoEvent`event.

  ```java
  dispatcher.dispatch(new DemoEvent("Hello World!"));
  ```

### Code example

Full code example of event registestration, creation and dispatch is under `demo` folder. Here is the main code:

  ```java
  EbentDispatcher dispatcher = new EbentDispatcher();
  try {
      dispatcher.registerEventHandler(DemoEvent.class, new DemoHandler());
      dispatcher.dispatch(new DemoEvent("Hello World!"));
  } catch (EventRegistrationException | NoValidHandlerException | EventDispatchException e) {
      System.err.println(e.getMessage());
  }
  ```
