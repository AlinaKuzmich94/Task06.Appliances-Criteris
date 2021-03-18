package by.htp.task05.learnmain;

import by.htp.task05.controller.Controller;

public class MainContext {

  public static final String REQUEST_STRING = "name=Oven&WEIGHT=12";

  public static void main(String[] args) {

    String requestString = REQUEST_STRING;
    for (String result : Controller.getInstance().findAppliances(requestString)) {
      System.out.println("*****"+result);
    }
  }
}

