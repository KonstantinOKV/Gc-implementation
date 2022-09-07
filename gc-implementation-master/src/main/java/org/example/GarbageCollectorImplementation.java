package org.example;

import java.util.*;

public class GarbageCollectorImplementation implements GarbageCollector {//расширяет garbage collector

    /*
     1. Создаюем коллекцию сетов, собирающих в себе все Мапы;
     2. Создаюем коллекцию сетов, собирающих в себе все Очереди;
     3. Рекурсией обеспечиваем прохождение по всем вложенным классам, методам, полям в поисках связей
     4. Проводим сравнение объектов из Хипа и из Стека. Если есть в стеке, а в Хипе нет, добавляем в лист для удаления
     */
    @Override
    public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
        Map<String, ApplicationBean> beans = heap.getBeans();
        Deque<StackInfo.Frame> frames = stack.getStack();
        return comparison(collectHeap(beans), collectStack(frames));
    }

    public Set<ApplicationBean> collectHeap(Map<String, ApplicationBean> beans) {
        Set<ApplicationBean> heapBeans = new HashSet<>();
        for (Map.Entry<String, ApplicationBean> beanEntry : beans.entrySet()) {
            heapBeans.add(beanEntry.getValue());
        }
        return heapBeans;
    }

    public Set<ApplicationBean> collectStack(Deque<StackInfo.Frame> frames) {
        Set<ApplicationBean> setBeans = new HashSet<>();
        for (StackInfo.Frame frame : frames) {
            for (ApplicationBean applicationBean : frame.getParameters()) {
                setBeans.addAll(deepLook(applicationBean, setBeans));
            }
        }
        return setBeans;
    }

    public Set<ApplicationBean> deepLook(ApplicationBean bean, Set<ApplicationBean> setBeans) {
        setBeans.add(bean);
        for (ApplicationBean applicationBean : bean.getFieldValues().values()) {
            if (!setBeans.contains(applicationBean)) setBeans.addAll(deepLook(applicationBean, setBeans));
        }
        return setBeans;
    }

    public ArrayList<ApplicationBean> comparison(Set<ApplicationBean> heapBeans, Set<ApplicationBean> setBeans) {
        heapBeans.removeAll(setBeans);
        return new ArrayList<>(heapBeans);
    }
}