package com.example.school.services;

import com.example.school.model.DTO.GroupDto;
import com.example.school.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.school.repository.GroupRepository;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroup() {
        return groupRepository.findAll();
    }

    public Group getGroupById(long id) {
        return groupRepository.findById(id).orElseThrow();
    }

    public Group addGroup(GroupDto groupDto) {
        Group group = Group.builder()
                .groupName(groupDto.getGroupName())
                .groupNum(groupDto.getGroupNum())
                .build();
        return groupRepository.save(group);
    }

    public void deleteGroup(long id) {
        groupRepository.deleteById(id);
    }

    public Group updateGroup(Group group, long id) {
        Group oldGroup = groupRepository.findById(id).orElseThrow();
        group.setId(oldGroup.getId());
        return groupRepository.save(group);
    }
}
