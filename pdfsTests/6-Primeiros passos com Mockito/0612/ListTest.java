package br.com.erudio.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void mockingListSizeTest() {
		// Given / Arrange
		List list = mock(List.class);
		given(list.size()).willReturn(10);
		// When / Act && Then / Assert
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(10));
	}

	@Test
	public void mockingListSize_withMultipleReturnValues() {
		// Given / Arrange
		List list = mock(List.class);
		given(list.size()).willReturn(10).willReturn(20);
		// When / Act && Then / Assert
		assertThat(list.size(), is(10)); // First Call
		assertThat(list.size(), is(20)); // Second Call
	}

	@Test
	public void mockingListGet() {
		// Given / Arrange
		Var list = mock(List.class);
		given(list.get(0)).willReturn("Erudio");
		// When / Act && Then / Assert
		assertThat(list.get(0), is("Erudio"));
		assertNull(list.get(1));
	}

	@Test
	public void mockingListGet_withAny() {

		// Given / Arrange
		Var list = mock(List.class);
		given(list.get(Mockito.anyInt())).willReturn("Erudio");

		// When / Act && Then / Assert
		assertThat(list.get(0), is("Erudio"));
		assertThat(list.get(1), is("Erudio"));
	}

	@Test
	public void mockingList_throwAnException() {
		// Given / Arrange
		Var list = mock(List.class);
		given(list.get(Mockito.anyInt())).willThrow(new RuntimeException("Foo Bar!!"));

		// When / Act && Then / Assert
		assertThrows(RuntimeException.class, () -> {
			// When / Act
			list.get(0);
		}, () -> "Should have throw an RuntimeException");
	}
}
