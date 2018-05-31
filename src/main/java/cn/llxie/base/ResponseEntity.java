package cn.llxie.base;

public class ResponseEntity<T> {

    int status;
    T body;

    public ResponseEntity() {

    }

    public ResponseEntity(Builder<T> builder) {
        this.status = builder.status;
        this.body = builder.body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static class Builder<T> {

        int status;
        T body;

        public Builder() {
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder body(T body) {
            this.body = body;
            return this;
        }

        public ResponseEntity build() {
            return new ResponseEntity(this);
        }

    }

}
