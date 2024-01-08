
import net.serenitybdd.annotations.Steps
import net.serenitybdd.junit5.SerenityJUnit5Extension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

//Описание/Пошаговая инструкция выполнения домашнего задания:
//Возьмите исходный код приложения ToDo
//Создайте тесты основных сценариев (аналогично модулю 1) с использованием двух любых подходов к описанию тестов
//Добавьте в gradle запуск тестов на уязвимости и корректность стиля кодирования
//Подготовьте отчет через Allure
//Вам потребуется 60-90 минут на выполнения задания.
//Если возникнут сложности, вы всегда можете обсудить их с одногруппниками или задать вопрос преподавателю Slack
//
//Критерии оценки:
//Созданы тесты добавления, завершения, фильтрации и сортировки (одним подходом) - 3.
//Созданы тесты добавления, завершения, фильтрации и сортировки (двумя разными подходами) - 5.
//Подготовлен отчет в формате Allure - 3.
//Соблюдены правила форматирования, функции, классы и переменные назвали осмысленно - 2.
//Работа считается принятой, если оценка 7 или более баллов.
//Максимальная оценка за работу - 10.



@ExtendWith(SerenityJUnit5Extension::class)
class SerenityTest {
    @Steps
    lateinit var mark: StepSerenityTest
   @Test
   fun testAddTask(){
       mark.testAddTask()
   }
    @Test
    fun testCompleteTask(){
        mark.testCompleteTask()
    }
    @Test
    fun uncompleteTask(){
        mark.uncompleteTask()

    }
}