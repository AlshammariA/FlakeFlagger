@Test public void should_create_Assert(){
  SomeComparable comparable=new SomeComparable();
  AbstractComparableAssert<?,SomeComparable> assertions=Assertions.assertThat(comparable);
  assertNotNull(assertions);
}
