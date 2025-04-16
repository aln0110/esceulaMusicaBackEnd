package com.aln.esceulamusicabackend.Model.Response;

import java.util.Objects;

public class Response<T> {
    private String status;
    private String title;
    private String message;
    private T data;

    public Response() {
    }

    public Response(String status, String title, String message, T data) {
        this.status = status;
        this.title = title;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response<?> response = (Response<?>) o;
        return Objects.equals(status, response.status) &&
                Objects.equals(title, response.title) &&
                Objects.equals(message, response.message) &&
                Objects.equals(data, response.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, title, message, data);
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}