package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class CommentService {
        @Autowired
        private CommentRepository commentRepository;

        public void addComment(Comment comment) {
                commentRepository.createComment(comment);
        }


}