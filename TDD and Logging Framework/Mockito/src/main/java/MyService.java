public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataById(int id) {
        return externalApi.getDataById(id);
    }

    public void sendData(String data) {
        externalApi.sendData(data);
    }

    public void sendAndProcess(String data) {
        externalApi.sendData(data);
        externalApi.processData(data);
    }
}