import data.Priority
import data.Task
import data.TasksRepositoryMemory
import net.serenitybdd.annotations.Step
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

open class StepSerenityTest {
    lateinit var mainAuthor : String

    private val tasks: TasksRepositoryMemory = TasksRepositoryMemory()
    private val name = "test"
    private val priority = Priority.HIGH

    // arrange
    private val task = Task(name = name, priority = priority)

    @Step("#mainAuthor Add task")
    open fun testAddTask() {
        // act
        tasks.addTask(task)
        val task = tasks.getTasks().find { it.name == name }
        val taskName = task?.name
        val taskPriority = task?.priority
        // assert
        assertEquals(name, taskName)
        assertEquals(priority, taskPriority)
    }

    @Step("#mainAuthor Finished task")
    open fun testCompleteTask() {
        val taskId = tasks.addTask(task)
        // act
        tasks.completeTask(taskId)
        val completedTasks = tasks.getTasks()
        // assert
        assertEquals(completedTasks.size, 1)
        assertTrue { completedTasks.first().completed }
    }

    @Step("#mainAuthor Filtering by uncompleted tasks")
    open fun uncompleteTask() {
        val taskId = tasks.addTask(task)
        // act
        tasks.uncompleteTask(taskId)
        val uncompleteTasks = tasks.getTasks(false)
        // assert
        assertEquals(uncompleteTasks.size, 1)
        assertFalse(uncompleteTasks.first().completed)
    }

    override fun toString(): String {
        return mainAuthor
    }
}