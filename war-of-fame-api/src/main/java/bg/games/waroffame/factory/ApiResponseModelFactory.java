package bg.games.waroffame.factory;

import bg.games.waroffame.model.response.ApiResponseModel;

public final class ApiResponseModelFactory {

    public static ApiResponseModel generateApiResponseModel(boolean success, String msg) {
        return new ApiResponseModel(success, msg);
    }

    private ApiResponseModelFactory() {
    }
}
