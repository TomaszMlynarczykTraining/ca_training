package com.example.workflow.delegate

import com.example.workflow.mvc.entity.User
import com.example.workflow.mvc.repository.UserRepository
import org.camunda.bpm.engine.delegate.DelegateExecution
import spock.lang.Specification

class GetUserDataDelegateTest extends Specification {

    def userRepository = Mock(UserRepository)
    def delegateExecution = Mock(DelegateExecution)

    def delegate = new GetUserDataDelegate(userRepository)

    def "Execute"() {
        given:
        def user = User.builder()
                .firstName("AAA")
                .isLogged("0")
                .build()
        def userListResult = [user]

        when:
        delegate.execute(delegateExecution)

        then:
        1 * userRepository.findAll() >> userListResult
        1 * delegateExecution.setVariable("allUser", userListResult)
        1 * delegateExecution.setVariable("isLogged", "0")
        0 * _
    }
}
