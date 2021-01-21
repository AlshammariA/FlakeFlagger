@Test public void should_pass_if_objects_are_not_equal(){
  Person a=spy(new Person("Han"));
  Person o=new Person("Yoda");
  comparables.assertNotEqualByComparison(someInfo(),a,o);
  verify(a).compareTo(o);
}
