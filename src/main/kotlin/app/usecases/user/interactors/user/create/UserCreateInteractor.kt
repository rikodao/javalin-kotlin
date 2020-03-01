package app.usecases.user.interactors.user.create

import app.domain.model.user.User
import app.usecases.user.adapters.controllers.UserCreateInputData
import app.usecases.user.adapters.presenters.IUserCreatePresenter
import app.usecases.user.adapters.presenters.IUserIndexPresenter
import app.usecases.user.adapters.repository.IUserRepository
import app.usecases.user.interactors.user.dto.UserData

class UserCreateInteractor(val userRepository: IUserRepository, val userCreatePresenter: IUserCreatePresenter) :
    IUserCreateUseCase {
    override fun handle(inputData: UserCreateInputData):String {
        val (firstName,lastName, age) = inputData
        val userModel = User(firstName,lastName, age)
        val newUser = userRepository.create(userModel)
        val userDto: UserData = UserData(newUser)

        val userJsonString = userCreatePresenter.output(userDto)
        return userJsonString

    }
}