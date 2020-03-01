package app.domain.model.user

class User(val firstName: String, val lastName: String, var age: Int) : BaseModel() {

    val name: String
        get() = "$firstName $lastName"
}