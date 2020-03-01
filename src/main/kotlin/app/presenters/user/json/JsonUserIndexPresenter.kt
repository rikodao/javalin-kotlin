import app.usecases.user.adapters.presenters.IUserIndexPresenter
import app.usecases.user.interactors.user.dto.UserData
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class JsonUserIndexPresenter : IUserIndexPresenter {
    override fun output(outputData: List<UserData>): List<String>{
        val mapper: ObjectMapper = jacksonObjectMapper()
        val response: List<String> = outputData.map { it-> mapper.writeValueAsString(it)}
        return response
    }
}

