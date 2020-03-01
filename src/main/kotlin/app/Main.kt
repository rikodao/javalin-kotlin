package app

import JsonUserCreatePresenter
import JsonUserIndexPresenter
import app.controllers.user.UserController
import app.repositories.user.memory.InMemoryUser
import app.usecases.user.interactors.user.create.UserCreateInteractor
import app.usecases.user.interactors.user.index.UserIndexInteractor
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*


fun main(args: Array<String>) {
    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start(7000)


    fun getUserController(): UserController { // DI化する
        val userRepository = InMemoryUser()
        val userIndexPresenter = JsonUserIndexPresenter()
        val userCreatePresenter = JsonUserCreatePresenter()
        val userCreateInteractor = UserCreateInteractor(userRepository, userCreatePresenter)
        val userIndexInteractor = UserIndexInteractor(userRepository, userIndexPresenter)
        val userController = UserController(userCreateInteractor, userIndexInteractor)
        return userController
    }

    val userController = getUserController()

    fun userRoutes() {
        return path("users") {
            get() { ctx ->
                val response = userController.getAllUsers()
                ctx.json(response)
            }
            post() { ctx ->
                val name = "大磯 直人"
                val age = 28
                val response = userController.createUser(name, age)
                ctx.json(response)
            }
        }
    }

    app.routes {
        userRoutes()
    }
}