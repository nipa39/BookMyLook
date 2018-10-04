package com.example.uzma.bookmylook;

    public class RateComment {
        String user,comment;
        float ratingbar;
        public RateComment(){

        }

        public RateComment(String user, String comment, float ratingbar) {
            this.user=user;
            this.comment = comment;
            this.ratingbar = ratingbar;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public float getRatingbar() {
            return ratingbar;
        }

        public void setRatingbar(float ratingbar) {
            this.ratingbar = ratingbar;
        }
    }



