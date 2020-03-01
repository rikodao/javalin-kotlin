package app.usecases.user.interactors.user.index

interface IUserIndexUseCase {
    fun handle(): List<String>
}