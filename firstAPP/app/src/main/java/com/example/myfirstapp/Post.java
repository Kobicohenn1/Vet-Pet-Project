package com.example.myfirstapp;

public class Post {
    public String key,uid,body,title;

    public Post(){
    }
    public Post(String uid,String title,String body,String key)
    {
        this.uid=uid;
        this.key=key;
        this.body=body;
        this.title=title;
    }
/*
    public boolean isDone(boolean done)
    {
        return done=true;
    }

    public boolean isDone() {
        return isDone;
    }
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }*/
}
