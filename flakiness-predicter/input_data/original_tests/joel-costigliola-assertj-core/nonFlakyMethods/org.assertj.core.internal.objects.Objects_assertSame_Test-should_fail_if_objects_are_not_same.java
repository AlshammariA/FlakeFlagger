@Test public void should_fail_if_objects_are_not_same(){
  AssertionInfo info=someInfo();
  Object a=new Person("Yoda");
  Object e=new Person("Yoda");
  try {
    objects.assertSame(info,a,e);
    fail();
  }
 catch (  AssertionError err) {
  }
  verify(failures).failure(info,shouldBeSame(a,e));
}
