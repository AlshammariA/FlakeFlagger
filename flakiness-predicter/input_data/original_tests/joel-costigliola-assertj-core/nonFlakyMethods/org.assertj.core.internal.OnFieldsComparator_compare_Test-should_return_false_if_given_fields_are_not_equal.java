@Test public void should_return_false_if_given_fields_are_not_equal(){
  DarthVader actual=new DarthVader("I like you","I'll kill you");
  DarthVader other=new DarthVader("I'll kill you","I'll kill you");
  assertThat(onFieldsComparator.compare(actual,other)).isNotZero();
}
