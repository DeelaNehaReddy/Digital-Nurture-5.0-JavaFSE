import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getDataById(anyInt())).thenReturn("Mock Data By Id");
        MyService service = new MyService(mockApi);
        service.fetchDataById(1);
        verify(mockApi).getDataById(anyInt());
    }

    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).sendData(anyString());
        MyService service = new MyService(mockApi);
        service.sendData("Test Data");
        verify(mockApi).sendData("Test Data");
    }

    @Test
    public void testMultipleReturnValues() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");
        MyService service = new MyService(mockApi);
        String firstResult = service.fetchData();
        String secondResult = service.fetchData();
        assertEquals("First Mock Data", firstResult);
        assertEquals("Second Mock Data", secondResult);
    }

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.sendAndProcess("Test Data");
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).sendData("Test Data");
        inOrder.verify(mockApi).processData("Test Data");
    }

    @Test
    public void testVoidMethodWithException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new RuntimeException("Exception occurred"))
                .when(mockApi).sendData(anyString());
        MyService service = new MyService(mockApi);
        assertThrows(RuntimeException.class, () -> service.sendData("Test Data"));
        verify(mockApi).sendData("Test Data");
    }
}