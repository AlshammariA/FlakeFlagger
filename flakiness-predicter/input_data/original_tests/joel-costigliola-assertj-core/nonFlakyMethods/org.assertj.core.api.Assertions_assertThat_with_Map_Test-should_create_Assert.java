@Test public void should_create_Assert(){
  AbstractMapAssert<?,? extends Map<Object,Object>,Object,Object> assertions=Assertions.assertThat(emptyMap());
  assertNotNull(assertions);
}
