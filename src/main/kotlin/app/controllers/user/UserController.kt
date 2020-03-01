package app.controllers.user

import app.usecases.user.adapters.controllers.UserCreateInputData
import app.usecases.user.interactors.user.create.IUserCreateUseCase
import app.usecases.user.interactors.user.index.IUserIndexUseCase

class UserController(val userCreateUseCase: IUserCreateUseCase, val userIndexUseCase: IUserIndexUseCase) {
    fun getAllUsers(): List<String> {
        val userStringList: List<String> = userIndexUseCase.handle()
        return userStringList
    }


    fun createUser(name: String?, age: Int?): String {
        if (name == null) throw IllegalArgumentException("No Name Argument")
        if (age == null) throw IllegalArgumentException("No Age Argument")

        val (firstName: String, lastName: String) = splitName(name)
        val userInputData = UserCreateInputData(firstName, lastName, age)
        val userString: String = userCreateUseCase.handle(userInputData)
        return userString
    }


    private fun splitName(name: String): Pair<String, String> {
        val namelist: List<String> = name.split('\n')
        val firstName = namelist[0]
        val lastName = namelist[1]
        return Pair(firstName, lastName)
    }
}