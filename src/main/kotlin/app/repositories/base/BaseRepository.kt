package app.repositories.base

import app.domain.model.user.BaseModel
import app.domain.model.user.User
import app.repositories.user.memory.MemoryUserData

abstract class BaseRepository {
    protected abstract fun toDataModel(from: User): BaseDataModel //private強制したいけどやり方わからん
    protected abstract fun toModel(from: MemoryUserData): BaseModel //private強制したいけどやり方わからん
}


