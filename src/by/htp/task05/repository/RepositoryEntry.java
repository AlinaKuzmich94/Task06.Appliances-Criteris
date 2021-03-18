package by.htp.task05.repository;

import java.util.Map;

public class RepositoryEntry {

  public RepositoryEntry(String name, Map<String, String> features){
    this.name = name;
    this.features = features;
  }

  private String name;

  private Map<String, String> features;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, String> getFeatures() {
    return features;
  }

  public void setFeatures(Map<String, String> features) {
    this.features = features;
  }

  @Override
  public String toString() {
    return name;
  }
}
