@Test public void should_return_false_if_all_but_ignored_fields_are_not_equal(){
  assertThat(ignoringFieldsComparator.compare(new DarthVader("I like you","I'll kill you"),new DarthVader("I'll kill you","I'll kill you"))).isNotZero();
}
