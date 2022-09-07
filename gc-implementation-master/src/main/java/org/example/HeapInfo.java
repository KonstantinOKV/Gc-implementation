package org.example;

import java.util.Map;


public class HeapInfo {

  private Map<String, ApplicationBean> beans; //поле "зернышки". Почему зернышки? значения что ли? дженерики стринг и компонент приложения

  public HeapInfo(Map<String, ApplicationBean> beans) {
    this.beans = beans;
  } //метод хип инфо (принимает в мапу стринг и компонент приложения)

  public Map<String, ApplicationBean> getBeans() {
    return beans;
  } //геттер достать фасоль принимает мапу из стринга и компонента приложения, возвращает зернышки
}