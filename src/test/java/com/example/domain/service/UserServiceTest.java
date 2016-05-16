package com.example.domain.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.domain.entity.User;
import com.example.infrastructure.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;	
      

	@Test
	public void testMetodoUserParaTeste() {
		User user = new User(1L, "1234567890", "");		
		when(userRepository.findById(5L)).thenReturn(user);
		when(userRepository.count()).thenReturn(5L).thenReturn(6L);
		
		assertThat(userService.metodoUserParaTeste(5L), is(15));	
		verify(userRepository, atLeast(2)).count();
	}
}
