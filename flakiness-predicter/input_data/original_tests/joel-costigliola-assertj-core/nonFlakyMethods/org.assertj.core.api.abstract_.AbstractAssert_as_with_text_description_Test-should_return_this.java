@Test public void should_return_this(){
  assertThat(assertions.as(description)).isSameAs(assertions);
}
