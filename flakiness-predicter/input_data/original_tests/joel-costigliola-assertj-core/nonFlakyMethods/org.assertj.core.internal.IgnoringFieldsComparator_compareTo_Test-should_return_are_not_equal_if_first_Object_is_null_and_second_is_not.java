@Test public void should_return_are_not_equal_if_first_Object_is_null_and_second_is_not(){
  assertThat(ignoringFieldsComparator.compare(null,new DarthVader("I like you","I'll kill you"))).isNotZero();
}
