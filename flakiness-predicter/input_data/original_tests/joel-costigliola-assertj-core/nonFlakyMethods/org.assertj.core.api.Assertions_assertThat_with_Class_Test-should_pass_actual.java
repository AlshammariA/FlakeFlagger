@Test public void should_pass_actual(){
  Class<Assertions_assertThat_with_Class_Test> clazz=Assertions_assertThat_with_Class_Test.class;
  AbstractClassAssert<?> assertions=Assertions.assertThat(clazz);
  assertSame(clazz,assertions.actual);
}
