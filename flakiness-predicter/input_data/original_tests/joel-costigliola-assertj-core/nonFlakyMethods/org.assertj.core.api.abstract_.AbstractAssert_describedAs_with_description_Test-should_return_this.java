@Test public void should_return_this(){
  assertThat(assertions.describedAs(description)).isSameAs(assertions);
}
