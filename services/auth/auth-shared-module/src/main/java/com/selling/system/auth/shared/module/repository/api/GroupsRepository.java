package com.selling.system.auth.shared.module.repository.api;

import com.selling.system.auth.shared.module.models.entities.Group;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GroupsRepository {

    Flux<Group> retrieveAllGroups();

    Mono<Long> updateGroupName(String groupName, String updatedGroupName);

    Mono<Long> saveGroup(String groupName);

    Mono<Long> deleteProfilesAuthoritiesGroup(String groupName);

    Mono<Long> deleteAuthoritiesGroup(String groupName, Long count);

    Mono<Long> deleteGroup(String groupName, Long count);

}
