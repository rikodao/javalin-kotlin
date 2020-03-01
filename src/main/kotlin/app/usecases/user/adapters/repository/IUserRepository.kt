package app.usecases.user.adapters.repository

import app.domain.model.user.User
import app.repositories.user.memory.MemoryUserData

interface IUserRepository {
    fun getAll(): List<User>
    fun create(user:User): User
    fun delete(user:User): User
    fun get(user:User): User
    fun toDataModel(from: User): MemoryUserData
    fun toModel(from: MemoryUserData): User
}