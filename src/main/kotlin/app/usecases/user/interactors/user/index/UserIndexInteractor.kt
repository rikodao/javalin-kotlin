package app.usecases.user.interactors.user.index

import app.usecases.user.adapters.presenters.IUserIndexPresenter
import app.usecases.user.adapters.repository.IUserRepository
import app.usecases.user.interactors.user.dto.UserData

class UserIndexInteractor(val userRepository: IUserRepository, val userIndexPresenter: IUserIndexPresenter) :
    IUserIndexUseCase {
    override fun handle(): List<String> {
        val userList = userRepository.getAll()
        val userDtoList: List<UserData> = userList.map { it -> UserData(it) }

        val userJsonStringList: List<String> = userIndexPresenter.output(userDtoList)
        return userJsonStringList

    }
}