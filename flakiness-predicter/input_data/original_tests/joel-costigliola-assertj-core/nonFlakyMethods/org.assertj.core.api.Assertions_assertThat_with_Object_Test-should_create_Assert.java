@Test public void should_create_Assert(){
  Object actual=new Object();
  AbstractObjectAssert<?,Object> assertions=Assertions.assertThat(actual);
  assertNotNull(assertions);
}
