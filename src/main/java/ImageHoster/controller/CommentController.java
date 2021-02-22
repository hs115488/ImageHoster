package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class CommentController {
        @Autowired
        private CommentService commentService;

        @Autowired
        private ImageService imageService;

        //This controller method is called when the request pattern is of type '/image/{imageId}/{imageTitle}/comments' and also the incoming request is of POST type
        //The method calls the addComment() method in the business logic passing the Comment object to add comment to a image
        //Redirects for a controller method with request mapping of type '/images/{ImageId}/{title}'
        @RequestMapping(value="/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
        public String addCommentToImage(@RequestParam("comment") String commentText, @PathVariable("imageId") int imageId, Comment newComment, HttpSession session)
        {
                Image image = imageService.getImage(imageId);
                User commentOwner = (User) session.getAttribute("loggeduser");
                newComment.setUser(commentOwner);
                newComment.setImage(image);
                newComment.setText(commentText);
                newComment.setCreatedDate(LocalDate.now());
                commentService.addComment(newComment);
                return "redirect:/images/"+image.getId()+"/"+image.getTitle();
        }


}