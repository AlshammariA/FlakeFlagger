@Test public void should_pass_if_objects_are_same(){
  Object actual=new Object();
  objects.assertSame(someInfo(),actual,actual);
}
