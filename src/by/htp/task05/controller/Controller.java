package by.htp.task05.controller;

import by.htp.task05.service.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

  private static Controller instance;

  public static synchronized Controller getInstance() {
    if (instance == null) {
      instance = new Controller();
    }
    return instance;
  }

  public List<String> findAppliances(String request) {

    Map<String, String> filterParameters = new HashMap<>();
    String[] parameters = request.split("&");
    for (String parameter : parameters) {
      String[] keyValue = parameter.split("=");
      filterParameters.put(keyValue[0], keyValue[1]);
    }

    return Service.getInstance().findAppliancesByNameAndProperty(filterParameters);
  }
}

