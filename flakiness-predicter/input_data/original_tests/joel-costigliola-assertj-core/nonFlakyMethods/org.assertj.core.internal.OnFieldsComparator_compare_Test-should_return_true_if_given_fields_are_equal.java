@Test public void should_return_true_if_given_fields_are_equal(){
  DarthVader actual=new DarthVader("I like you","I'll kill you");
  DarthVader other=new DarthVader("I like you","I like you");
  assertThat(onFieldsComparator.compare(actual,other)).isZero();
}
