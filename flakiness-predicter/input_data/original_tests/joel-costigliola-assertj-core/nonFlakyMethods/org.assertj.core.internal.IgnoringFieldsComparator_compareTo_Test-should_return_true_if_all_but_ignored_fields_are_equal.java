@Test public void should_return_true_if_all_but_ignored_fields_are_equal(){
  assertThat(ignoringFieldsComparator.compare(new DarthVader("I like you","I'll kill you"),new DarthVader("I like you","I like you"))).isZero();
}
