package com.example.hotelManager.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "room_number")
public class RoomNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tasklist_id")
    private TaskList taskList;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "camera_type_id", referencedColumnName = "id")
    private CameraType cameraType;


    public RoomNumber(Long id, Integer number, TaskList taskLists) {
        this.id = id;
        this.number = number;
        this.taskList = taskLists;
    }

    public CameraType getCameraType() {
        return cameraType;
    }

    public RoomNumber(Long id, Integer number, TaskList taskList, CameraType cameraType) {
        this.id = id;
        this.number = number;
        this.taskList = taskList;
        this.cameraType = cameraType;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public void setCameraType(CameraType cameraType) {
        this.cameraType = cameraType;
    }

    public RoomNumber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    // constructor, getters, and setters
}