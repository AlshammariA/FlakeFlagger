@Test public void should_format_tuples(){
  assertThat(toStringOf(tuple(1,2,3))).isEqualTo("(1, 2, 3)");
}
