@Test public void should_pass_if_iterable_is_empty(){
  arrays.assertContainsAll(someInfo(),actual,newArrayList());
}
