package app.usecases.user.adapters.presenters

import app.usecases.user.interactors.user.dto.UserData

interface IUserCreatePresenter {
    fun output(outputData: UserData): String
}