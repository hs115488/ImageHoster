package ImageHoster.model;


import ImageHoster.model.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "comment")
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column( name = "text")
        private String text;

        @Column( name = "createdDate")
        private LocalDate createdDate;

        //The 'comment' table is mapped to 'users' table with Many:One mapping
        //One comment can belong to only one user (owner) but one user can have multiple comments
        //FetchType is EAGER
        @ManyToOne(fetch = FetchType.EAGER)
        //Below annotation indicates that the the name of the column in 'comment' table referring the primary key in 'users' table will be 'user_id'
        @JoinColumn(name = "user_id")
        private User user ;

        //The 'comment' table is mapped to 'images' table with Many:One mapping
        //One comment can belong to only one image  but one image can have multiple comments
        //FetchType is EAGER
        @ManyToOne(fetch = FetchType.EAGER)
        //Below annotation indicates that the name of the column in 'comment' table referring the primary key in 'images' table will be 'image_id'
        @JoinColumn(name = "image_id")
        private Image Image;

        public Comment()
        {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public LocalDate getCreatedDate() {
                return createdDate;
        }

        public void setCreatedDate(LocalDate createdDate) {
                this.createdDate = createdDate;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public Image getImage() {
                return Image;
        }

        public void setImage(Image image) {
                this.Image = image;
        }

}