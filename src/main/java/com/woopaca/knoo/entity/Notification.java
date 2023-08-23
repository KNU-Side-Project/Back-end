package com.woopaca.knoo.entity;

import com.woopaca.knoo.entity.value.NotificationType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notification")
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    @Column(name = "notification_description")
    private String notificationDescription;

    @Column(name = "notification_type")
    private NotificationType notificationType;

    @Column(name = "read")
    private boolean isRead;

    @Column(name = "notification_date")
    private LocalDateTime notificationDate;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    protected Notification(String notificationDescription, NotificationType notificationType,
                           boolean isRead, LocalDateTime notificationDate) {
        this.notificationDescription = notificationDescription;
        this.notificationType = notificationType;
        this.isRead = isRead;
        this.notificationDate = notificationDate;
    }
}