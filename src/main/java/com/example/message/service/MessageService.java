package com.example.message.service;

import com.example.message.model.Message;
import com.example.message.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
     private final MessageRepository repository;

       public MessageService(MessageRepository repository){
           this.repository = repository;
    }

        public List<Message> getAllMessages(){
                 return repository.findAll();
        }

          public void addMessage(String name, String text){
               repository.save(new Message(name,text));
          }

    // IDでメッセージを取得
    public Message findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // メッセージを更新
    public void updateMessage(Integer id, Message updatedMessage) {
        Message message = repository.findById(id).orElse(null);
        if (message != null) {
            message.setName(updatedMessage.getName());
            message.setText(updatedMessage.getText());
            repository.save(message);
        }
    }      
    
}
