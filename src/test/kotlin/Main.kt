// Описание/Пошаговая инструкция выполнения домашнего задания:
// Сделать тест добавления задачи и появления ее в списке.
// Завершить задачу и проверить корректность работы фильтра по завершенным задачам.
// Проверить сортировку задач по названию и сроку исполнения.
// Сформировать отчет с использованием библиотеки Allure Kotlin
// Результатом должен быть код теста, который заполняет пустой список задач тестовыми данными и
// проверяет корректность текущего состояния списка при выполнении

import data.Priority
import data.Task
import data.TasksRepositoryMemory
import jdk.jfr.Description
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Description("Тесты функций TODO")
class Main {
    private val tasks: TasksRepositoryMemory = TasksRepositoryMemory()
    private val name = "test"

    private val priority = Priority.HIGH

    // arrange
    private val task = Task(name = name, priority = priority)

    @Description("Тест добавления задачи и появления ее в списке.")
    @Test
    fun testAddTask() {
        // act
        tasks.addTask(task)
        val task = tasks.getTasks().find { it.name == name }
        val taskName = task?.name
        val taskPriority = task?.priority
        // assert
        assertEquals(name, taskName)
        assertEquals(priority, taskPriority)
    }

    @Description("Завершить задачу и проверить корректность работы фильтра по завершенным задачам.")
    @Test
    fun testCompleteTask() {
        val taskId = tasks.addTask(task)
        // act
        tasks.completeTask(taskId)
        val completedTasks = tasks.getTasks()
        // assert
        assertEquals(completedTasks.size, 1)
        assertTrue { completedTasks.first().completed }
    }

    @Description("Фильтрация по не выполненным задачам")
    @Test
    fun uncompleteTask() {
        val taskId = tasks.addTask(task)
        // act
        tasks.uncompleteTask(taskId)
        val uncompleteTasks = tasks.getTasks(false)
        // assert
        assertEquals(uncompleteTasks.size, 1)
        assertFalse(uncompleteTasks.first().completed)
    }
}
