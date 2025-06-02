package com.backend.api.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class Di2winService {

    private final String token = "TrqCU9QOTc01EOBFD6wHQ7x8FvbNM7xxuNMQEulbnxotCxYqOw";
    private final String endpoint = "https://homol.extraidados.com.br/api/portalEngines-processApp/process";

    public String processDocument(MultipartFile file, String classification) throws IOException {
        HttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(endpoint);
        httpPost.setHeader("Authorization", token);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody(
                "document",
                file.getBytes(),
                ContentType.DEFAULT_BINARY,
                file.getOriginalFilename()
        );
        builder.addTextBody("userId", "341");
        builder.addTextBody("documentClassification", classification);

        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);

        HttpResponse response = client.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        System.out.println("Status da resposta Di2win: " + statusCode);
        System.out.println("Resposta da Di2win: " + responseBody);

        if (statusCode >= 200 && statusCode < 300) {
            return responseBody;
        } else {
            throw new IOException("Erro ao processar na Di2win. Status: " + statusCode + " - Resposta: " + responseBody);
        }
    }
}
