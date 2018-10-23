package conexao;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.model.FileList;

import java.security.GeneralSecurityException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayOutputStream;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Conexao {
    
    private static final String APPLICATION_NAME      = "Google Drive API Java Quickstart";
    private static final JsonFactory JSON_FACTORY     = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    
    /*Variavel global utilizada afim de pegar o servico*/
    private static Drive service = null;

    /*Instancia global da variavel SCOPES, utilizada dessa forma retorna todas as permissoes possiveis para manipular o drive*/
    private static final List<String> SCOPES = new ArrayList<>(DriveScopes.all());
    
    /*Variavel global com o intuito de salvar o caminho de onde estao as credencias do drive*/
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Construtor da classe - onde se inicia a variavel do servico
     */
    private Conexao(){
        
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                          .setApplicationName(APPLICATION_NAME)
                          .build();
        } catch (Exception e) {
            e.getMessage();
        }        
    }
    
    /**
     * Cria um objeto de credencial autorizado.
     * @param HTTP_TRANSPORT HTTP transporte da rede.
     * @return Um objeto de credencial autorizado.
     * @throws IOException se o arquivo de credentials.json não for encontrado.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {

        /*Carrega os "secredos" do cliente*/
        InputStream in = Conexao.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        /*Constroi o fluxo e uma trigger do pedido do usuario*/
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }
    
    /**
     * Caso o serviço ainda não esteja instânciado então instância.
     * @return O servico
     */
    public static Drive service() {
        
        if (service == null) {
            new Conexao();
        }
        return service;
    }
    
    /**
     * Verifica se existe essa pasta no Google Drive.
     * @param nome Nome da pasta.
     * @return Retorna o id dessa pasta ou se ela não existir retorna "".
     * @throws IOException
     * @throws GeneralSecurityException 
     */
    public static String existePasta(String nome)  throws IOException, GeneralSecurityException {
        
        String pageToken = null;
        do {
          FileList result = service.files().list()
              .setQ("mimeType='application/vnd.google-apps.folder'")
              .setSpaces("drive")
              .setFields("nextPageToken, files(id, name)")
              .setPageToken(pageToken)
              .execute();
          
          /*Laco rodando todos os arquivos que estao no drive*/
          for (File file : result.getFiles()) {
              
              /*Verifica se o nome do arquivo que esta no drive e igual ao procurado*/
              if (file.getName().equals(nome)){
                  
                  /*Se for igual entao retorn o id do arquivo*/
                  return file.getId();
              }
          }
          pageToken = result.getNextPageToken();
        } while (pageToken != null);
        
        return "";
    }
    
    
    
    
    /*FALTA COMENTAR DAQUI PRA BAIXO*/
    
    
    public static String existeArquivo(String nome)  throws IOException, GeneralSecurityException {
        
        String pageToken = null;
        do {
          FileList result = service.files().list()
              .setQ("mimeType='arquivosjson/json'")
              .setSpaces("drive")
              .setFields("nextPageToken, files(id, name)")
              .setPageToken(pageToken)
              .execute();
          for (File file : result.getFiles()) {
              if (file.getName().equals(nome)){
                  return file.getId();
              }
          }
          pageToken = result.getNextPageToken();
        } while (pageToken != null);
        
        return "";
    }
    
    
    
    
    
    
    
    public static String criaPasta(Drive service, String name) throws IOException, GeneralSecurityException{
        
        File fileMetadata = new File();
        fileMetadata.setName(name);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");

        File file = service.files().create(fileMetadata)
            .setFields("id")
            .execute();
        
        return file.getId();        
    }
    
    public static void getFolderID() throws IOException, GeneralSecurityException {
        
        FileList result = service.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
        }
    }
    
    public static void removeArquivo(String fileId) throws IOException, GeneralSecurityException{
        
        try {
          service.files().delete(fileId).execute();
        } catch (IOException e) {
          System.out.println("An error occurred: " + e);
        }
    }
    
    public static String enviaArquivo(String folderId, String url) throws IOException, GeneralSecurityException{

        File fileMetadata = new File();
        fileMetadata.setName(url);
        fileMetadata.setParents(Collections.singletonList(folderId));
        java.io.File filePath = new java.io.File("ArquivosJson/" + url);
        FileContent mediaContent = new FileContent("ArquivosJson/json", filePath);
        File file = service.files().create(fileMetadata, mediaContent)
            .setFields("id, parents")
            .execute();
        
        return file.getId();
    }
    
    public static String printFile(String fileId) throws IOException, GeneralSecurityException{

          File file = service.files().get(fileId).execute();
          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
          service.files().get(fileId).executeMediaAndDownloadTo(outputStream);
          
          return outputStream.toString();
    }
}