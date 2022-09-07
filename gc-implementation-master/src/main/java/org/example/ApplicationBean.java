package org.example;

import java.util.HashMap;
import java.util.Map;

public class ApplicationBean { 

  private Map<String, ApplicationBean> fieldValues = new HashMap<>(); //значение полей

  public Map<String, ApplicationBean> getFieldValues() {
    return fieldValues;
  } //получение значений полей

  public ApplicationBean getChildBean(String beanName) {
    return fieldValues.get(beanName);
  } //получить дочерний боб

  public void addRelation(String fieldName, ApplicationBean relation) {
    fieldValues.put(fieldName, relation);
  } //добавить отношение


}
