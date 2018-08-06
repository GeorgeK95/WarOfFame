package bg.games.waroffame.factory;

import bg.games.waroffame.model.response.HttpErrorResponseModel;

public final class ApiResponseModelFactory {

    public static HttpErrorResponseModel generateApiResponseModel(int status, String msg) {
        return new HttpErrorResponseModel(status, msg);
    }

    private ApiResponseModelFactory() {
    }
}
