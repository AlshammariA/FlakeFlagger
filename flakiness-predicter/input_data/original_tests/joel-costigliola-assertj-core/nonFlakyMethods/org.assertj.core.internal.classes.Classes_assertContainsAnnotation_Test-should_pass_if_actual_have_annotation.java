@SuppressWarnings("unchecked") @Test public void should_pass_if_actual_have_annotation(){
  actual=AnnotatedClass.class;
  classes.assertContainsAnnotations(someInfo(),actual,MyAnnotation.class);
}
