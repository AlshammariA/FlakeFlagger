@Test public void should_pass_if_actual_is_not_an_annotation(){
  actual=Classes_assertIsNotAnnotation_Test.class;
  classes.assertIsNotAnnotation(someInfo(),actual);
}
