package rest;

import com.google.gson.Gson;

public class RestHelper {
    private static final Gson gson = new Gson();

    public static String getErrorResponseString()
    {
        Response response = new Response();
        response.setSuccess(false);
        String output = gson.toJson(response);
        System.out.println("[Server response] " + output);
        return output;
    }

    public static String getSuccessResponse(boolean success)
    {
        Response response = new Response();
        response.setSuccess(success);
        String output = gson.toJson(response);
        System.out.println("[Server response] " + output);
        return output;
    }
}
