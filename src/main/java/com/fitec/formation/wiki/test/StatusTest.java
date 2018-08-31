package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.mapper.StatusMapper;
import com.fitec.formation.wiki.model.StatusModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatusTest {

    public List<Status> initStatusSuite() {
        final List<Status> stati = new ArrayList<>();

        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_ARTICLE_APPROVED));
        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_ARTICLE_UNAPPROVED));
        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_ARTICLE_SUBMITTED));
        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_ARTICLE_DISABLED));

        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_USER_CONNECTED));
        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_USER_DISCONNECTED));
        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_USER_BANNED));
        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_USER_DISABLED));

        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_COMMENT_ENABLED));
        stati.add(StatusMapper.mapToStatus(StatusModel.STATUS_COMMENT_DISABLED));

        System.out.println("initStatusSuite() = " + !stati.isEmpty());
        return stati;
    }
}
