package com.example.hotelManager.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "task_list")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomNumber> roomNumbers;

    public TaskList() {

    }

    public TaskList(Long id, String title, List<RoomNumber> roomNumbers) {
        this.id = id;
        this.title = title;
        this.roomNumbers = roomNumbers;
    }

    public void setRoomNumbers(List<RoomNumber> roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RoomNumber> getRoomNumbers() {
        return roomNumbers;
    }
}