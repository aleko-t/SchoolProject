package com.example.school.controller;

import com.example.school.model.DTO.GroupDto;
import com.example.school.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.school.services.GroupService;

import java.util.List;

@RestController
@RequestMapping("/Group")
public class GroupControler {
    @Autowired
    private GroupService groupService;
    @GetMapping("")
    public List<Group> getGroup(){
        return groupService.getGroup();
    }

    @PostMapping("")
    public Group addGroup(@RequestBody GroupDto groupDto){
        return groupService.addGroup(groupDto);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup( @PathVariable long id){
        groupService.deleteGroup(id);
    }
    @PutMapping("/{id}")
    public Group updateGroup(@RequestBody Group group, @PathVariable long id){
        return groupService.updateGroup(group, id);
    }
}
