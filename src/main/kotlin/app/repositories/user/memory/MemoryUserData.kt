package app.repositories.user.memory

import app.domain.model.user.User
import app.repositories.base.BaseDataModel

data class MemoryUserData(val dbid: String? = null, val firstName: String, val lastName: String, var age: Int):
    BaseDataModel() {
    fun toDB(user: User): MemoryUserData {
        val firstName = user.firstName
        val lastName = user.lastName
        val age = user.age
        return MemoryUserData(firstName=firstName,lastName=lastName,age=age)
    }

    fun toDomain(): User {
        return User(firstName, lastName, age)
    }
}
