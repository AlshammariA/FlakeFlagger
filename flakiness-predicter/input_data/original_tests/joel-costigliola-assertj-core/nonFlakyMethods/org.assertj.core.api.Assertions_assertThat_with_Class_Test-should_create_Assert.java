@Test public void should_create_Assert(){
  Class<Assertions_assertThat_with_Class_Test> clazz=Assertions_assertThat_with_Class_Test.class;
  AbstractClassAssert<?> assertions=Assertions.assertThat(clazz);
  assertNotNull(assertions);
}
