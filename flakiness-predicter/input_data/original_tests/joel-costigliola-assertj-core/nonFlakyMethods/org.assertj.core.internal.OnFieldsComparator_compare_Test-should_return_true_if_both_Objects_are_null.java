@Test public void should_return_true_if_both_Objects_are_null(){
  assertThat(onFieldsComparator.compare(null,null)).isZero();
}
