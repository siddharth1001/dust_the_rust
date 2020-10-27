package cultfit;

public class Error {
    private String msg;
    private boolean isError;

    public Error(String msg, boolean isError) {
        this.msg = msg;
        this.isError = isError;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isError() {
        return isError;
    }
}
