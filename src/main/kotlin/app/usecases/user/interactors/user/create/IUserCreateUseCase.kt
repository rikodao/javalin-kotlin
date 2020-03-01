package app.usecases.user.interactors.user.create

import app.usecases.user.adapters.controllers.UserCreateInputData

interface IUserCreateUseCase {
    fun handle(inputData: UserCreateInputData): String
}