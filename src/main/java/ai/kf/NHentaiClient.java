package ai.kf;

import com.google.gson.Gson;
import okhttp3.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NHentaiClient implements AutoCloseable {
    private static final String API_ROOT_URL = "https://nhentai.net";
    private static final String IMAGE_ROOT_URL = "https://i.nhentai.net";
    private static final String THUMBNAIL_ROOT_URL = "https://t.nhentai.net";

    private final OkHttpClient client;
    private final Gson gson = new Gson();
    private final Map<String, String> cookies;

    public NHentaiClient(String userAgent, Map<String, String> cookies) {

        this.client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> result = new ArrayList<>();
                        for (Map.Entry<String, String> entry : NHentaiClient.this.cookies.entrySet()) {
                            result.add(new Cookie.Builder()
                                    .name(entry.getKey())
                                    .value(entry.getValue())
                                    .domain(url.host())
                                    .build());
                        }
                        return result;
                    }
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request request = chain.request().newBuilder()
                            .addHeader("User-Agent", userAgent)
                            .build();
                    return chain.proceed(request);
                })
                .build();
        this.cookies = cookies != null ? cookies : new HashMap<>();
    }

    public void close() {
        client.dispatcher().executorService().shutdown();
        client.connectionPool().evictAll();
    }

    public void getDoujin(int id) {
        Request request = new Request.Builder()
                .url(API_ROOT_URL + "/api/gallery/" + id)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Unexpected code " + response);
            }
            assert response.body() != null;
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define your URL roots and methods here
}
