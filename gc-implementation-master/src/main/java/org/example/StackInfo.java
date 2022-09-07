package org.example;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class StackInfo { //класс стек инфо
  Deque<Frame> stack = new LinkedList<>(); //стопка стек имеен дженерик Frame (скелет, костяк) работает как аррейлист (то есть использует методы листа, то есть как изменяемый массив)

  public void push(String methodName, ApplicationBean... parameters) { //метод добавить получает строку имя метода, компонент приложения и параметры компонента приложения)
    stack.push(new Frame(methodName, Arrays.asList(parameters))); //стопка стек добавляет (новый объект скелет(имя метода, принимает массив с параметрами и возвращает список)
  }

  public Frame pop() {
    return stack.pop();
  } // метод pop удаляет последний элемент и возвращает его;

  public Deque<Frame> getStack() {
    return stack;
  } // геттер stack


  public class Frame { //класс Фрейм(скелет)
    String methodName; //строка имя метода
    List<ApplicationBean> parameters; //лист параметры с дженериком "компонент приложения" зачем то

    public String getMethodName() {
      return methodName;
    } //блок строка под названием getMethodName возвращает имя метода

    public List<ApplicationBean> getParameters() {
      return parameters;
    } //лист "компонент приложения" getParameters() (возвращение параметров возвращает параметры почему то

    public Frame(String methodName, List<ApplicationBean> parameters) { //метод Фрейм(скелет) получает параметры строка "имя метода" и листр "компонент приложения" параметры
      this.methodName = methodName; //строка = полю класса
      this.parameters = parameters; //параметры = полю параметры класса
    }
  }
}

