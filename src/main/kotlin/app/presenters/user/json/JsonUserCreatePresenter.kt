import app.usecases.user.adapters.presenters.IUserCreatePresenter
import app.usecases.user.interactors.user.dto.UserData
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class JsonUserCreatePresenter : IUserCreatePresenter {
    override fun output(outputData: UserData): String{
        val mapper: ObjectMapper = jacksonObjectMapper()
        val response: String = mapper.writeValueAsString(outputData)
        return response
    }
}

