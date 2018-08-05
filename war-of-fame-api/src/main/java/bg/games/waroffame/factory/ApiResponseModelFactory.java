package bg.games.waroffame.factory;

import bg.games.waroffame.model.response.HttpErrorResponse;

public final class ApiResponseModelFactory {

    public static HttpErrorResponse generateApiResponseModel(int status, String msg) {
        return new HttpErrorResponse(status, msg);
    }

    private ApiResponseModelFactory() {
    }
}
