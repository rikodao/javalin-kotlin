package app.usecases.user.adapters.presenters

import app.usecases.user.interactors.user.dto.UserData

interface IUserIndexPresenter {
    fun output(outputData: List<UserData>): List<String>
}