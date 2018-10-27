/*
 * TheTVDB API v2
 * API v2 targets v1 functionality with a few minor additions. The API is accessible via https://api.thetvdb.com and provides the following REST endpoints in JSON format.   How to use this API documentation ----------------   You may browse the API routes without authentication, but if you wish to send requests to the API and see response data, then you must authenticate. 1. Obtain a JWT token by `POST`ing  to the `/login` route in the `Authentication` section with your API key and credentials. 1. Paste the JWT token from the response into the \"JWT Token\" field at the top of the page and click the 'Add Token' button.   You will now be able to use the remaining routes to send requests to the API and get a response.   Language Selection ----------------   Language selection is done via the `Accept-Language` header. At the moment, you may only pass one language abbreviation in the header at a time. Valid language abbreviations can be found at the `/languages` route..   Authentication ----------------   Authentication to use the API is similar to the How-to section above. Users must `POST` to the `/login` route with their API key and credentials in the following format in order to obtain a JWT token.  `{\"apikey\":\"APIKEY\",\"username\":\"USERNAME\",\"userkey\":\"USERKEY\"}`  Note that the username and key are ONLY required for the `/user` routes. The user's key is labled `Account Identifier` in the account section of the main site. The token is then used in all subsequent requests by providing it in the `Authorization` header. The header will look like: `Authorization: Bearer <yourJWTtoken>`. Currently, the token expires after 24 hours. You can `GET` the `/refresh_token` route to extend that expiration date.   Versioning ----------------   You may request a different version of the API by including an `Accept` header in your request with the following format: `Accept:application/vnd.thetvdb.v$VERSION`. This documentation automatically uses the version seen at the top and bottom of the page.
 *
 * OpenAPI spec version: 2.2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package de.generationcode.flightseries.backend.client.thetvdb.api;

import com.google.gson.reflect.TypeToken;

import de.generationcode.flightseries.backend.client.thetvdb.ApiCallback;
import de.generationcode.flightseries.backend.client.thetvdb.ApiClient;
import de.generationcode.flightseries.backend.client.thetvdb.ApiException;
import de.generationcode.flightseries.backend.client.thetvdb.ApiResponse;
import de.generationcode.flightseries.backend.client.thetvdb.Configuration;
import de.generationcode.flightseries.backend.client.thetvdb.Pair;
import de.generationcode.flightseries.backend.client.thetvdb.ProgressRequestBody;
import de.generationcode.flightseries.backend.client.thetvdb.ProgressResponseBody;
import de.generationcode.flightseries.backend.client.thetvdb.model.NotAuthorized;
import de.generationcode.flightseries.backend.client.thetvdb.model.NotFound;
import de.generationcode.flightseries.backend.client.thetvdb.model.UpdateData;
import de.generationcode.flightseries.backend.client.thetvdb.model.UpdateDataQueryParams;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdatesApi {
    private ApiClient apiClient;

    public UpdatesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UpdatesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for updatedQueryGet
     * @param fromTime Epoch time to start your date range. (required)
     * @param toTime Epoch time to end your date range. Must be one week from &#x60;fromTime&#x60;. (optional)
     * @param acceptLanguage Records are returned with the Episode name and Overview in the desired language, if it exists. If there is no translation for the given language, then the record is still returned but with empty values for the translated fields. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updatedQueryGetCall(String fromTime, String toTime, String acceptLanguage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/updated/query";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fromTime != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fromTime", fromTime));
        if (toTime != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("toTime", toTime));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (acceptLanguage != null)
        localVarHeaderParams.put("Accept-Language", apiClient.parameterToString(acceptLanguage));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "jwtToken" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updatedQueryGetValidateBeforeCall(String fromTime, String toTime, String acceptLanguage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'fromTime' is set
        if (fromTime == null) {
            throw new ApiException("Missing the required parameter 'fromTime' when calling updatedQueryGet(Async)");
        }
        

        com.squareup.okhttp.Call call = updatedQueryGetCall(fromTime, toTime, acceptLanguage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * 
     * Returns an array of series that have changed in a maximum of one week blocks since the provided &#x60;fromTime&#x60;.   The user may specify a &#x60;toTime&#x60; to grab results for less than a week. Any timespan larger than a week will be reduced down to one week automatically.
     * @param fromTime Epoch time to start your date range. (required)
     * @param toTime Epoch time to end your date range. Must be one week from &#x60;fromTime&#x60;. (optional)
     * @param acceptLanguage Records are returned with the Episode name and Overview in the desired language, if it exists. If there is no translation for the given language, then the record is still returned but with empty values for the translated fields. (optional)
     * @return UpdateData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateData updatedQueryGet(String fromTime, String toTime, String acceptLanguage) throws ApiException {
        ApiResponse<UpdateData> resp = updatedQueryGetWithHttpInfo(fromTime, toTime, acceptLanguage);
        return resp.getData();
    }

    /**
     * 
     * Returns an array of series that have changed in a maximum of one week blocks since the provided &#x60;fromTime&#x60;.   The user may specify a &#x60;toTime&#x60; to grab results for less than a week. Any timespan larger than a week will be reduced down to one week automatically.
     * @param fromTime Epoch time to start your date range. (required)
     * @param toTime Epoch time to end your date range. Must be one week from &#x60;fromTime&#x60;. (optional)
     * @param acceptLanguage Records are returned with the Episode name and Overview in the desired language, if it exists. If there is no translation for the given language, then the record is still returned but with empty values for the translated fields. (optional)
     * @return ApiResponse&lt;UpdateData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UpdateData> updatedQueryGetWithHttpInfo(String fromTime, String toTime, String acceptLanguage) throws ApiException {
        com.squareup.okhttp.Call call = updatedQueryGetValidateBeforeCall(fromTime, toTime, acceptLanguage, null, null);
        Type localVarReturnType = new TypeToken<UpdateData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Returns an array of series that have changed in a maximum of one week blocks since the provided &#x60;fromTime&#x60;.   The user may specify a &#x60;toTime&#x60; to grab results for less than a week. Any timespan larger than a week will be reduced down to one week automatically.
     * @param fromTime Epoch time to start your date range. (required)
     * @param toTime Epoch time to end your date range. Must be one week from &#x60;fromTime&#x60;. (optional)
     * @param acceptLanguage Records are returned with the Episode name and Overview in the desired language, if it exists. If there is no translation for the given language, then the record is still returned but with empty values for the translated fields. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updatedQueryGetAsync(String fromTime, String toTime, String acceptLanguage, final ApiCallback<UpdateData> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updatedQueryGetValidateBeforeCall(fromTime, toTime, acceptLanguage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UpdateData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updatedQueryParamsGet
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updatedQueryParamsGetCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/updated/query/params";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "jwtToken" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updatedQueryParamsGetValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = updatedQueryParamsGetCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * 
     * Returns an array of valid query keys for the &#x60;/updated/query/params&#x60; route.
     * @return UpdateDataQueryParams
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateDataQueryParams updatedQueryParamsGet() throws ApiException {
        ApiResponse<UpdateDataQueryParams> resp = updatedQueryParamsGetWithHttpInfo();
        return resp.getData();
    }

    /**
     * 
     * Returns an array of valid query keys for the &#x60;/updated/query/params&#x60; route.
     * @return ApiResponse&lt;UpdateDataQueryParams&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UpdateDataQueryParams> updatedQueryParamsGetWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = updatedQueryParamsGetValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<UpdateDataQueryParams>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Returns an array of valid query keys for the &#x60;/updated/query/params&#x60; route.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updatedQueryParamsGetAsync(final ApiCallback<UpdateDataQueryParams> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updatedQueryParamsGetValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UpdateDataQueryParams>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
