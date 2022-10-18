package com.jpa.bookmanager.domain.listener;

import com.jpa.bookmanager.domain.User;
import com.jpa.bookmanager.domain.UserHistory;
import com.jpa.bookmanager.repository.UserHistoryRepository;
import com.jpa.bookmanager.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

// EntityListener 에서는 스프링 Bean @Autowired 로 주입 불가
public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}
