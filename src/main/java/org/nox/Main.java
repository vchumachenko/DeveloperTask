package org.nox;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {

    Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
    Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
    Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));

    Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);

    // Создаю Set для хранения языков программирования
    Set<String> uniqLanguages = new HashSet<>();


    developerStream.filter(developer -> {
      // Временный set для хранения языков текущего разработчика
      HashSet<String> tmp = new HashSet<>(developer.getLanguages());

      // Сохраняю только те языки, которые уже не были добавлены в uniqLanguages
      tmp.retainAll(uniqLanguages);

      // true, если временное множество пусто (разработчик использует уникальные языки)
      return tmp.isEmpty();
    }).forEach(developer -> {
      System.out.println(developer.getName());

      // Добавляю языки текущего разработчика в множество uniqLanguages
      uniqLanguages.addAll(developer.getLanguages());
    });
  }
}

