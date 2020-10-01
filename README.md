# OTUS.AdapterSecondProject
Проект в рамках обучения на платформе OTUS.

## Курс: Архитектура и шаблоны проектирования.

### Занятия: Адаптер и мост.

Задание: Адаптер для работы двух независимых программ. Описание применения шаблона в проекте
         Цель: 1. Вы напишете адаптер, чтобы связать функционал двух отдельных программ в единый процесс. разберётесь с тем, как адаптер работает в случае вызова отдельных программ. Получите навыки работы с формальными и фактическими параметрами передачи данных
         2. Получите навык анализа системы - использовать или нет этот шаблон в проектной работе.
         Написать простую консольную программу П1, с интерфейсом вызова И1, которая читает данные о двух матрицах А и В из файла F0, складывает матрицы и сохраняет результат А+В в другой файл F1.
         Написать вторую консольную программу П2, которая может генерить данные матриц А и В и писать их в файл с именем F2.
         Чтобы она могла их просуммировать, следует сделать адаптер для программы П1, который позволит программе П2 вызвать П1.
         1. Написать программу П1
         2. Написать программу П2, включив туда адаптер вызова и использования программы П1
         3. Написать автотест для проверки функционирования
         4. Если потребуется использовать адаптер в проектной работе, предоставить описание в текстовом файле в GitHub репозитории где конкретно и в какой роли используется этот шаблон.
         5. нарисовать диаграмму классов.

Программа #2. Использует адаптер из Программы #1, подключченной как библиотека (в ресурсах лежит jar, в pom.xml указана зависимость)

## Запуск:
1. mvn clean test -DsuiteXmlFile=testng.xml 
    или
2. mvn clean test
3. mvn clean install (если необходимо собрать исполняемый jar файл AdapterSecondProject-1.0-jar-with-dependencies.jar, после сборки лежит в target)

### Описание тестирования:
###### 1 Способ. Уже собранный jar-файл (AdapterSecondProject-1.0-jar-with-dependencies.jar) расположен в корне проекта.
Пример запуска через cmd: java -jar AdapterSecondProject-1.0-jar-with-dependencies.jar -i inputFile.txt -o outputFile.txt
При этом в данном случае оба файла могут не существовать до запуска,
так как в процессе работы приложение файл input будет создан при генерации двух матриц,
а файл output будет создан при работе адаптера, туда будет записана сумма матриц.

###### 2 Способ.Тест расположен в директории src/test/java.
Для теста подставляю вместо рандомно-генерируемого файла, статичный файл expectedGeneratedMatrices.txt,
вызываю для теста метод сложения у Адаптера и ожидаю, что файл output будет идентичен файлу expectedAdapterResult.txt(сумма матриц, указанных в expectedGeneratedMatrices.txt)
В процессе запуска тестирования они программно копируются в папку target/test-classes/,
где в результате теста генерится свой файл output, который сравнивается с expected

### Логирование: 
Файл logMain.log созданиется в директории проекта/jar файла.
Содержит информацию о сгенеренных двух матрицах и суммы матриц, получнной в адаптере.

##### Диаграмма классов:
Файл diagram.png находится в корне проекта (сгенерирован ресурсами Intelij IDEA)

#### Версии с которыми разрабатывалось приложение:

java version "11.0.8" 2020-07-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.8+10-LTS, mixed mode)
Apache Maven 3.3.9

##### Библиотеки:

#### AdapterFirstProject: otus/AdapterFirstProject/1.0

log4j:https://mvnrepository.com/artifact/log4j/log4j/1.2.17

testng:https://mvnrepository.com/artifact/org.testng/testng/7.3.0

commons-cli:https://mvnrepository.com/artifact/commons-cli/commons-cli/1.3.1

commons-io:https://mvnrepository.com/artifact/commons-io/commons-io/2.8.0
