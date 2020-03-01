package app.repositories.user.memory

import app.domain.model.user.User
import app.repositories.base.BaseRepository
import app.usecases.user.adapters.repository.IUserRepository

class InMemoryUser : BaseRepository(), IUserRepository {
    override fun getAll(): List<User> {

        // ここでデータとってくる
        val ore: MemoryUserData = toDataModel("fr8f7af98a","naoto", "oiso", 28)
        val cto: MemoryUserData = toDataModel("fr8f7af98a","ryo", "takano", 30)
        val userDataList: List<MemoryUserData>  = listOf(ore, cto)

        val userList: List<User> = userDataList.map { it -> toModel(it) }
        return userList
    }

    override fun create(user: User): User {
        val newUserDataModel = toDataModel(user)
        // ここに保存処理
        val newUserModel = toModel(newUserDataModel)
        return newUserModel
    }

    override fun delete(user: User): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(user: User): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toDataModel(from: User): MemoryUserData {
        val firstName = from.firstName
        val lastName = from.lastName
        val age = from.age
        return MemoryUserData(firstName = firstName, lastName = lastName, age = age)
    }

    private fun toDataModel(dbid:String?=null, firstName: String, lastName: String, age: Int): MemoryUserData {
        return MemoryUserData(firstName = firstName, lastName = lastName, age = age)
    }

    override fun toModel(from: MemoryUserData): User {
        return User(from.firstName, from.lastName, from.age)
    }
}

