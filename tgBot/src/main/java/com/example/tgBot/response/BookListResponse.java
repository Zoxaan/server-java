package com.example.tgBot.response;


import com.example.tgBot.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookListResponse extends BaseResponse{
    public BookListResponse(Iterable<BookEntity> data){
        super(true,"Книги");
        this.data = data;
    }
    private Iterable<BookEntity> data;

    @Override
    public String toString() {
        return "BookListResponse{" +
                "data=" + data +
                '}';
    }
}
