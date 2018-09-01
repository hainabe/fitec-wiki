package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private UserLoggerModel userLoggerModel;
    private UserInfoModel userInfoModel;

    private List<ArticleModel> articlesModel;
    private List<CommentModel> commentsModel;
    private StatusModel statusModel;

    public UserModel(UserLoggerModel userLoggerModel) {
        this.userLoggerModel = userLoggerModel;
    }

    public UserModel(UserLoggerModel userLoggerModel, UserInfoModel userInfoModel) {
        this.userLoggerModel = userLoggerModel;
        this.userInfoModel = userInfoModel;
    }

    public UserModel(UserLoggerModel userLoggerModel, UserInfoModel userInfoModel, StatusModel statusModel) {
        this.userLoggerModel = userLoggerModel;
        this.userInfoModel = userInfoModel;
        this.statusModel = statusModel;
    }

    @Override
    public String toString() {
        return "User []\n" +
                userLoggerModel + "\n" +
                userInfoModel;
    }
}
